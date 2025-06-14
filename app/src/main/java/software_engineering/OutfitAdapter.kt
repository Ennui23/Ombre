package software_engineering

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import software_engineering.dataclass.ResultData
import software_engineering.project.ombre.R

class OutfitAdapter(private val context: Context) : RecyclerView.Adapter<OutfitAdapter.OutfitViewHolder>() {
    private val outfits: MutableList<ResultData> = mutableListOf()

    inner class OutfitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resultTextView: TextView = itemView.findViewById(R.id.adventureItemResultText)
        val imageView: ImageView = itemView.findViewById(R.id.adventureItemImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OutfitViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_adventure, parent, false)
        return OutfitViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OutfitViewHolder, position: Int) {
        val currentOutfit = outfits[position]
        holder.resultTextView.text = currentOutfit.resultText

        // Assuming imageUrl is the Firebase Storage URL
        val imageUrl = currentOutfit.imageUrl ?: ""

        // Load the outfit image into the 'imageView' using Glide
        CoroutineScope(Dispatchers.Main).launch {
            val bitmap = imageUrl?.let { loadImageAsync(it) }
            if (bitmap != null) {
                holder.imageView.setImageBitmap(bitmap)
            } else {
                // Handle the case when the image is null or loading fails
                // You can set a placeholder image or handle it as needed
                holder.imageView.setImageResource(R.drawable.placeholder_bg)
            }
        }
    }

    override fun getItemCount(): Int {
        return outfits.size
    }

    fun updateData(newOutfits: List<ResultData>) {
        outfits.clear()
        outfits.addAll(newOutfits)
        notifyDataSetChanged()
    }

    private suspend fun loadImageAsync(imageUrl: String): Bitmap? = withContext(Dispatchers.IO) {
        try {
            // Download the image using Glide in a background thread
            Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .submit()
                .get()
        } catch (e: Exception) {
            // Handle errors, e.g., log the error
            null
        }
    }
}
