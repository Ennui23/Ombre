package software_engineering

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import software_engineering.dataclass.ResultData
import software_engineering.project.ombre.R

class Adventure : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var outfitAdapter: OutfitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adventure, container, false)

        recyclerView = view.findViewById(R.id.adventureRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2) // 2 items per row

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        val spacingBetweenRowsInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_rows)
        recyclerView.addItemDecoration(
            GridSpacingItemDecoration(2, spacingInPixels, spacingBetweenRowsInPixels)
        )


        outfitAdapter = OutfitAdapter(requireContext())
        recyclerView.adapter = outfitAdapter

        // Retrieve and populate the adventure outfit items
        retrieveAdventureOutfits()

        return view
    }

    private fun retrieveAdventureOutfits() {
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("Adventure Outfits") // Correct collection name

        collectionRef.get()
            .addOnSuccessListener { result ->
                if (result != null) {
                    val outfitList = mutableListOf<ResultData>()
                    for (document in result) {
                        val imageUrl = document.getString("imageUrl") ?: ""
                        val classificationResult = document.getString("resultText") ?: ""

                        outfitList.add(ResultData(resultText = classificationResult, imageUrl = imageUrl))
                    }
                    outfitAdapter.updateData(outfitList)
                }
            }
            .addOnFailureListener { exception ->
                // Handle failure
            }
    }
}
