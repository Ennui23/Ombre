package software_engineering

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import software_engineering.project.ombre.Classify
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class OpenCamera : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var btnRecommendation: Button
    private lateinit var btnUpload: Button
    private var currentPhotoPath: String? = null
    private var selectedCategory: String? = null
    private var selectedGender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_camera)

        imageView = findViewById(R.id.imageView)
        btnRecommendation = findViewById(R.id.btnrecommendationbtn)
        btnUpload = findViewById(R.id.btnuploadd)

        selectedCategory = intent.getStringExtra("event")
        selectedGender = intent.getStringExtra("gender")

        setupCameraButton()
        setupRecommendationButton()
        setupUploadButton()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    val intent = Intent(this, PickCategory::class.java)
                    startActivityWithAnimation(
                        PickCategory::class.java,
                        R.anim.swipe_right_enter,
                        R.anim.swipe_right_exit
                    )
                    startActivity(intent)
                    true
                }

                R.id.action_event -> {
                    val intent = Intent(this, Event::class.java)
                    startActivityWithAnimation(
                        Event::class.java,
                        R.anim.swipe_left_enter,
                        R.anim.swipe_left_exit
                    )
                    startActivity(intent)
                    true
                }

                R.id.action_recommendation -> {
                    val intent = Intent(this, Recommendations::class.java)
                    startActivityWithAnimation(
                        Recommendations::class.java,
                        R.anim.swipe_left_enter,
                        R.anim.swipe_left_exit
                    )
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }

    private fun setupCameraButton() {
        imageView.setOnClickListener {
            checkAndRequestCameraPermission()
        }
    }

    private fun checkAndRequestCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSION
            )
        } else {
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            try {
                val photoFile: File? = createImageFile()
                photoFile?.also {
                    val photoURI = FileProvider.getUriForFile(
                        this,
                        "software_engineering.project.ombre.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun createImageFile(): File? {
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply {
            currentPhotoPath = absolutePath
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent()
                } else {
                    Toast.makeText(
                        this,
                        "Camera permission denied. Cannot open the camera.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun setupRecommendationButton() {
        btnRecommendation.setOnClickListener {
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
    }

    private fun setupUploadButton() {
        btnUpload.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, REQUEST_PICK_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            currentPhotoPath?.let { path ->
                val imageBitmap = BitmapFactory.decodeFile(path)
                imageView.setImageBitmap(imageBitmap)

                navigateToNextScreen(path)
            }
        } else if (requestCode == REQUEST_PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri = data.data!!
            imageView.setImageURI(selectedImageUri)

            navigateToNextScreen(selectedImageUri.toString())
        }
    }

    private fun navigateToNextScreen(imagePath: String) {
        val intent = Intent(this, Classify::class.java)
        intent.putExtra("IMAGE_PATH", imagePath)
        selectedCategory?.let { intent.putExtra("event", it) }
        selectedGender?.let { intent.putExtra("gender", it) }
        startActivity(intent)
        finish()
    }


    private fun startActivityWithAnimation(destinationActivity: Class<*>, enterAnim: Int, exitAnim: Int) {
        val intent = Intent(this, destinationActivity)
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
        finish()
    }

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1
        private const val REQUEST_CAMERA_PERMISSION = 2
        private const val REQUEST_PICK_IMAGE = 3
    }
}
