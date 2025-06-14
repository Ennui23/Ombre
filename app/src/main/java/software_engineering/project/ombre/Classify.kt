@file:Suppress("DEPRECATION")

package software_engineering.project.ombre

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.storage.FirebaseStorage
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import software_engineering.ModelResults
import software_engineering.PickCategory
import software_engineering.project.ombre.ml.Cnn
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.Date
import java.util.Locale
import java.util.UUID

class Classify : AppCompatActivity() {

    private lateinit var classifyBtn: Button
    private lateinit var imageView: ImageView
    private lateinit var bitmap: Bitmap
    private lateinit var labels: List<String>
    private var selectedCategory: String? = null
    private var selectedGender: String? = null

    private val storageRef = FirebaseStorage.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_classify)

        labels = assets.open("labels.txt").bufferedReader().readLines()

        imageView = findViewById(R.id.imageView)
        classifyBtn = findViewById(R.id.classifyBtn)

        val imagePath = intent.getStringExtra("IMAGE_PATH")
        selectedCategory = intent.getStringExtra("event")
        selectedGender = intent.getStringExtra("gender")

        if (!imagePath.isNullOrEmpty()) {
            val imageUri = Uri.parse(imagePath)

            try {
                val inputStream = if (imageUri.scheme == "content") {
                    contentResolver.openInputStream(imageUri)
                } else {
                    FileInputStream(File(imageUri.path))
                }

                bitmap = BitmapFactory.decodeStream(inputStream)
                inputStream?.close()

                imageView.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
                // Handle the exception, for example, show a Toast
                Toast.makeText(this, "Error loading the image", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Handle the case where imagePath is null or empty
            Toast.makeText(this, "Image path is null or empty", Toast.LENGTH_SHORT).show()
        }


        val imageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(64, 64, ResizeOp.ResizeMethod.BILINEAR))
            .build()

        classifyBtn.setOnClickListener {
            if (::bitmap.isInitialized) {
                val progressDialog = ProgressDialog(this)
                progressDialog.setMessage("Classifying...")
                progressDialog.setCancelable(false)
                progressDialog.show()

                Handler().postDelayed({
                    val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true)

                    val tensorImage = TensorImage(DataType.FLOAT32)
                    tensorImage.load(resizedBitmap)

                    val model = Cnn.newInstance(this)

                    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
                    inputFeature0.loadBuffer(tensorImage.buffer)

                    val outputs = model.process(inputFeature0)
                    val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

                    var maxIdx = 0
                    outputFeature0.forEachIndexed { index, fl ->
                        if (outputFeature0[maxIdx] < fl) {
                            maxIdx = index
                        }
                    }

                    model.close()

                    val resultText = labels[maxIdx]

                    val tempFile = File(cacheDir, "temp_image.jpg")
                    val outputStream = FileOutputStream(tempFile)
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
                    outputStream.flush()
                    outputStream.close()

                    val imageUri = saveBitmapAndGetUri(bitmap)

                    imageView.setImageURI(imageUri)

                    val intent = Intent(this, ModelResults::class.java)
                    intent.putExtra("resultText", resultText)
                    intent.putExtra("imageUri", imageUri.toString())
                    intent.putExtra("event", selectedCategory)
                    intent.putExtra("gender", selectedGender)
                    startActivity(intent)

                    progressDialog.dismiss()
                }, 3000)
            } else {
                Toast.makeText(this, "Please select an image first", Toast.LENGTH_SHORT).show()
            }
        }

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

    private fun startActivityWithAnimation(destinationActivity: Class<*>, enterAnim: Int, exitAnim: Int) {
        val intent = Intent(this, destinationActivity)
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
        finish()
    }

    private fun saveBitmapAndGetUri(bitmap: Bitmap): Uri {
        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val randomIdentifier = UUID.randomUUID().toString()
        val fileName = "${formatter.format(now)}_$randomIdentifier.jpg"

        val tempFile = File(cacheDir, fileName)

        val outputStream = FileOutputStream(tempFile)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        outputStream.flush()
        outputStream.close()

        return Uri.fromFile(tempFile)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == Activity.RESULT_OK && data != null) {
            val uri = data.data
            try {
                bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
                imageView.setImageBitmap(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
