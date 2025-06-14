@file:Suppress("DEPRECATION")

package software_engineering

import android.app.ProgressDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.ObjectKey
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations
import software_engineering.project.ombre.databinding.ActivityModelResultsBinding
import java.util.Date
import java.util.Locale
import java.util.UUID


@Suppress("DEPRECATION")
class ModelResults : AppCompatActivity() {

    private lateinit var binding: ActivityModelResultsBinding
    private lateinit var imageUrl: String

    private lateinit var resView: TextView
    private lateinit var imageView: ImageView
    private var resultImageUri: Uri? = null
    private var selectedCategory: String? = null
    private var selectedGender: String? = null

    private val TAG = "ModelResults"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelResultsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        resView = view.findViewById(R.id.resView)
        imageView = view.findViewById(R.id.resultImage)

        selectedCategory = intent.getStringExtra("event")
        selectedGender = intent.getStringExtra("gender")

        imageUrl = intent.getStringExtra("imageUri") ?: ""
        val resultText = intent.getStringExtra("resultText") ?: ""

        binding.resView.text = resultText

        loadFirebaseImage(imageUrl)

        binding.save.setOnClickListener {
            saveResults(imageUrl, resultText)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    val intent = Intent(this, PickCategory::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_event -> {
                    val intent = Intent(this, Event::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_recommendation -> {
                    val intent = Intent(this, Recommendations::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        if (selectedCategory.equals(resultText, ignoreCase = true)) {
            Toast.makeText(this@ModelResults, "Categories match!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this@ModelResults, "Categories doesn't match!", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({
                navigateToRecommendations(selectedCategory, selectedGender)
            }, 5000)
        }

    }

    private fun navigateToRecommendations(selectedCategory: String?, selectedGender: String?) {
        val intent: Intent

        val mappedCategory = when (selectedCategory) {
            "Active Adventure", "Urban Adventure" -> "Adventure"
            "Business Casual", "Business Formal" -> "Business"
            else -> selectedCategory
        }

        if (mappedCategory in listOf("Adventure", "Business") && (selectedGender == "Men" || selectedGender == "Women")) {
            intent = Intent(this, ChooseSubCategory::class.java)
            intent.putExtra("event", mappedCategory)
            intent.putExtra("gender", selectedGender)
        } else {
            intent = Intent(this, ChooseEventGender::class.java)
        }

        Log.d("Navigation", "Mapped Category: $mappedCategory, Selected Gender: $selectedGender")
        startActivity(intent)
        finish()
    }


    private fun loadFirebaseImage(imageUrl: String) {
        Thread {
            if (imageUrl.startsWith("file://")) {
                runOnUiThread {
                    binding.resultImage.setImageURI(Uri.parse(imageUrl))
                }
            } else {
                val storageReference = FirebaseStorage.getInstance().getReference(imageUrl)

                storageReference.metadata.addOnSuccessListener { _ ->
                    loadFirebaseImageWithUrl(storageReference)
                }.addOnFailureListener { exception ->
                    Log.e(TAG, "File does not exist: $imageUrl", exception)
                    runOnUiThread {
                        binding.resultImage.setImageResource(R.drawable.placeholder_bg)
                    }
                }
            }
        }.start()
    }

    private fun loadFirebaseImageWithUrl(storageReference: StorageReference) {
        runOnUiThread {
            storageReference.downloadUrl.addOnSuccessListener { uri ->
                Glide.with(this)
                    .load(uri)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .signature(ObjectKey(System.currentTimeMillis()))
                    .into(binding.resultImage)
            }.addOnFailureListener {
                Log.e(TAG, "Error getting download URL", it)
                binding.resultImage.setImageResource(R.drawable.placeholder_bg)
            }
        }
    }

    private fun saveResults(imageUrl: String, resultText: String) {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Saving Results...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val imageUri = Uri.parse(imageUrl)

        val storage = FirebaseStorage.getInstance()
        val storageRef = storage.reference

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val randomIdentifier = UUID.randomUUID().toString()
        val fileName = "images/${formatter.format(now)}_$randomIdentifier.jpg"

        val imageRef = storageRef.child(fileName)

        imageRef.putFile(imageUri)
            .addOnSuccessListener {
                imageRef.downloadUrl.addOnSuccessListener { uri ->

                    saveDataToFirestore(uri.toString(), resultText)

                    Toast.makeText(this@ModelResults, "Successfully Saved!", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@ModelResults, PickCategory::class.java)
                    startActivity(intent)
                    finish()
                    if (progressDialog.isShowing) progressDialog.dismiss()
                }.addOnFailureListener { exception ->
                    Log.e(TAG, "Error getting download URL", exception)
                    if (progressDialog.isShowing) progressDialog.dismiss()
                    Toast.makeText(this@ModelResults, "Saving Failed", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Image upload failed", exception)
                if (progressDialog.isShowing) progressDialog.dismiss()
                Toast.makeText(this@ModelResults, "Saving Failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun saveDataToFirestore(downloadUrl: String, resultText: String) {
        val db = Firebase.firestore

        val category = when {
            resultText.contains("Adventure", ignoreCase = true) -> "Adventure Outfits"
            resultText.contains("Business", ignoreCase = true) -> "Business Outfits"
            else -> "Other"
        }

        val data = hashMapOf(
            "imageUrl" to downloadUrl,
            "resultText" to resultText
        )

        db.collection(category)
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            resultImageUri = data?.data!!
            binding.resultImage.setImageURI(resultImageUri)
        }
    }
}