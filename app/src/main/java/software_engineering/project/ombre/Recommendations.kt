@file:Suppress("DEPRECATION")

package software_engineering.project.ombre

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import software_engineering.LinearSpacingItemDecoration
import software_engineering.PickCategory

class Recommendations : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_recommendations)

        firestore = FirebaseFirestore.getInstance()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    val intent = Intent(this, PickCategory::class.java)
                    startActivityWithAnimation(intent, R.anim.swipe_right_enter, R.anim.swipe_right_exit)
                    finish()
                    true
                }
                R.id.action_event -> {
                    val intent = Intent(this, Event::class.java)
                    startActivityWithAnimation(intent, R.anim.swipe_right_enter, R.anim.swipe_right_exit)
                    true
                }
                R.id.action_recommendation -> {
                    true
                }
                else -> false
            }
        }

        val recyclerView: RecyclerView = findViewById(R.id.recoList_RecyclerView)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        fetchSavedImages { querySnapshot ->
            displaySavedImages(querySnapshot)
        }
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun fetchSavedImages(onSuccess: (QuerySnapshot) -> Unit) {
        firestore.collection("Recommendation Saved Images")
            .get()
            .addOnSuccessListener { documents ->
                onSuccess(documents)
            }
            .addOnFailureListener {
            }
    }

    private fun displaySavedImages(querySnapshot: QuerySnapshot) {
        val recyclerView: RecyclerView = findViewById(R.id.recoList_RecyclerView)

        val adapter = RecommendationAdapter(this, querySnapshot) { document ->
            // Handle the remove operation
            removeSavedImage(recyclerView, document)
        }

        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing_between_items_linear)
        recyclerView.addItemDecoration(LinearSpacingItemDecoration(spacingInPixels, layoutManager.orientation, true))
    }

    private fun removeConfirmationPrompt(recyclerView: RecyclerView, document: DocumentSnapshot) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirm Removal")
        builder.setMessage("Are you sure you want to remove this recommendation?")

        // Add the buttons
        builder.setPositiveButton("Remove") { _, _ ->
            removeSavedImage(recyclerView, document)
        }

        builder.setNegativeButton("Cancel") { _, _ ->

        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun removeSavedImage(recyclerView: RecyclerView, document: DocumentSnapshot) {
        val firestore = FirebaseFirestore.getInstance()

        // Get the document ID and remove the document from Firestore
        val documentId = document.id
        firestore.collection("Recommendation Saved Images")
            .document(documentId)
            .delete()
            .addOnSuccessListener {
                // Fetch the updated data from Firestore
                fetchSavedImages { updatedSnapshot ->
                    // Update the adapter with the new data
                    val adapter = recyclerView.adapter as? RecommendationAdapter
                    adapter?.updateData(updatedSnapshot)

                    Toast.makeText(this, "Recommendation removed successfully", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to remove item", Toast.LENGTH_SHORT).show()
            }
    }

}
