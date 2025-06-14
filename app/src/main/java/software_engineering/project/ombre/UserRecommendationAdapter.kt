@file:Suppress("DEPRECATION")

package software_engineering.project.ombre

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserRecommendationAdapter(
    private val context: Context,
    private var querySnapshot: QuerySnapshot
) : RecyclerView.Adapter<UserRecommendationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.results_recommendation_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val document = querySnapshot.documents[position]

        // Get the image URL from Firestore document
        val imagePath = document.getString("imageUrl") ?: ""

        Glide.with(context)
            .load(imagePath)
            .placeholder(R.drawable.placeholder_bg)
            .error(R.drawable.placeholder_bg)
            .into(holder.imageView)

        // Set a click listener for the save button
        holder.saveButton.setOnClickListener {
            // Call a function to handle the save operation
            saveImage(document)
        }
    }

    override fun getItemCount(): Int {
        return querySnapshot.size()
    }

    fun updateData(newQuerySnapshot: QuerySnapshot) {
        querySnapshot = newQuerySnapshot
        notifyDataSetChanged()
    }

    private fun saveImage(document: DocumentSnapshot) {
        // Get the data you want to save from the document
        val imageUrl = document.getString("imageUrl") ?: ""
        val event = document.getString("event") ?: ""
        val subcategory = document.getString("subcategory") ?: ""
        val type = document.getString("type") ?: ""
        val color = document.getString("color") ?: ""
        val pattern = document.getString("pattern") ?: ""

        // Save the data to Firestore
        val firestore = Firebase.firestore
        val savedImagesRef = firestore.collection("Recommendation Saved Images")

        val savedImage = hashMapOf(
            "imageUrl" to imageUrl,
            "event" to event,
            "subcategory" to subcategory,
            "type" to type,
            "color" to color,
            "pattern" to pattern
        )

        savedImagesRef.add(savedImage)
            .addOnSuccessListener {
                Log.d("SaveItem", "Recommendation saved to Firestore successfully!")

                Toast.makeText(context, "Recommendation saved successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Log.e("SaveItem", "Error saving recommendation to Firestore: $e")

                Toast.makeText(context, "Error saving recommendation. Please try again.", Toast.LENGTH_SHORT).show()
            }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewRecommendation)
        val saveButton: Button = itemView.findViewById(R.id.RecommendationSaveButton)
        init {
            // Set OnClickListener for the save button
            saveButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Call the saveItem function with the clicked position
                    saveImage(querySnapshot.documents[position])
                }
            }
        }
    }
}
