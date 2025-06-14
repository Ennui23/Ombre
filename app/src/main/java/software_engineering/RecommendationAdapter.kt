package software_engineering.project.ombre

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class RecommendationAdapter(
    private val context: Context,
    private var querySnapshot: QuerySnapshot,
    private val onRemoveClickListener: (DocumentSnapshot) -> Unit
) : RecyclerView.Adapter<RecommendationAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recommendation_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val document = querySnapshot.documents[position]

        // Get the data from Firestore document
        val imageUrl = document.getString("imageUrl") ?: ""
        val event = document.getString("event") ?: ""
        val subcategory = document.getString("subcategory") ?: ""
        val type = document.getString("type") ?: ""
        val color = document.getString("color") ?: ""
        val pattern = document.getString("pattern") ?: ""

        // Load image using Glide
        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder_bg)
            .error(R.drawable.placeholder_bg)
            .into(holder.imageView)

        // Set text for event, type, color, and pattern
        holder.textEvent.text = "$event"
        holder.textSubCategory.text = "$subcategory"
        holder.textType.text = "$type"
        holder.textColor.text = "$color"
        holder.textPattern.text = "$pattern"

        holder.removeButton.setOnClickListener {
            // Call the function to show the confirmation prompt
            showConfirmationPrompt(context, document, onRemoveClickListener)
        }
    }

    override fun getItemCount(): Int {
        return querySnapshot.size()
    }

    fun updateData(newQuerySnapshot: QuerySnapshot) {
        querySnapshot = newQuerySnapshot
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val removeButton: ToggleButton = itemView.findViewById(R.id.removeButton)

        val imageView: ImageView = itemView.findViewById(R.id.imageRecommendation)
        val textEvent: TextView = itemView.findViewById(R.id.textEvent)
        val textSubCategory: TextView = itemView.findViewById(R.id.textSubcategory)
        val textType: TextView = itemView.findViewById(R.id.textType)
        val textColor: TextView = itemView.findViewById(R.id.textColor)
        val textPattern: TextView = itemView.findViewById(R.id.textPattern)
    }

    private fun showConfirmationPrompt(context: Context, document: DocumentSnapshot, onRemoveClickListener: (DocumentSnapshot) -> Unit) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Confirm Removal")
        builder.setMessage("Are you sure you want to remove this recommendation?")

        // Add the buttons
        builder.setPositiveButton("Remove") { _, _ ->
            // Call the provided onRemoveClickListener
            onRemoveClickListener(document)
        }

        builder.setNegativeButton("Cancel") { _, _ ->
            // Do nothing if canceled
        }

        val dialog = builder.create()
        dialog.show()
    }
}

