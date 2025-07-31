@file:Suppress("DEPRECATION")

package software_engineering

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView  // Import TextView
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import software_engineering.project.ombre.Classify
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations
import software_engineering.project.ombre.UserRecommendationAdapter

class ResultsRecommendation : AppCompatActivity() {

    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String
    private lateinit var selectedSubCategory: String
    private lateinit var selectedType: String
    private lateinit var selectedColor: String
    private lateinit var selectedPattern: String
    private lateinit var storage: FirebaseStorage
    private lateinit var firestore: FirebaseFirestore

    private lateinit var btnback: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_recommendation)

        btnback = findViewById(R.id.btnback)

        FirebaseApp.initializeApp(this)

        selectedCategory = intent.getStringExtra("event") ?: ""
        selectedGender = intent.getStringExtra("gender") ?: ""
        selectedSubCategory = intent.getStringExtra("subcategory") ?: ""
        selectedType = intent.getStringExtra("type") ?: ""
        selectedColor = intent.getStringExtra("color") ?: ""
        selectedPattern = intent.getStringExtra("pattern") ?: ""

        storage = FirebaseStorage.getInstance()
        firestore = FirebaseFirestore.getInstance()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

        val textTags: TextView = findViewById(R.id.textTags)

        queryRecommendations(selectedCategory, selectedGender, selectedSubCategory, selectedType, selectedColor, selectedPattern) { documents ->
            displayRecommendations(documents)

            if (!documents.isEmpty) {
                val firstDocument = documents.documents[0]
                val event = firstDocument.getString("event") ?: ""
                val type = firstDocument.getString("type") ?: ""
                val color = firstDocument.getString("color") ?: ""
                val pattern = firstDocument.getString("pattern") ?: ""

                val tagsText = buildString {
                    if (event.isNotEmpty()) append("$event  ")
                    if (type.isNotEmpty()) append("$type  ")
                    if (color.isNotEmpty()) append("$color  ")
                    if (pattern.isNotEmpty()) append("$pattern ")
                }
                textTags.text = tagsText
            }
        }

        btnback.setBackgroundResource(R.drawable.btnback)

        btnback.setOnClickListener {
            val intent = Intent(this, PickCategory::class.java)
            startActivityWithAnimation(intent, R.anim.swipe_right_enter, R.anim.swipe_right_exit)
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    val intent = Intent(this, PickCategory::class.java)
                    startActivityWithAnimation(intent, R.anim.swipe_right_enter, R.anim.swipe_right_exit)
                    startActivity(intent)
                    true
                }
                R.id.action_event -> {
                    val intent = Intent(this, Event::class.java)
                    startActivityWithAnimation(intent, R.anim.swipe_right_enter, R.anim.swipe_right_exit)
                    startActivity(intent)
                    true
                }
                R.id.action_recommendation -> {
                    val intent = Intent(this, Recommendations::class.java)
                    startActivityWithAnimation(intent, R.anim.swipe_right_enter, R.anim.swipe_right_exit)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun queryRecommendations(
        event: String,
        gender: String,
        subcategory: String,
        type: String,
        color: String,
        pattern: String,
        onSuccess: (QuerySnapshot) -> Unit
    ) {
        firestore.collection("Recommendations")
            .whereEqualTo("event", event)
            .whereEqualTo("gender", gender)
            .whereEqualTo("subcategory", subcategory)
            .whereEqualTo("type", type)
            .whereEqualTo("color", color)
            .whereEqualTo("pattern", pattern)
            .get()
            .addOnSuccessListener { documents ->
                Log.d("ResultsRecommendation", "onSuccess called")
                onSuccess(documents)
            }
            .addOnFailureListener {
            }
    }

    private fun displayRecommendations(querySnapshot: QuerySnapshot) {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val adapter = UserRecommendationAdapter(this, querySnapshot)
        recyclerView.adapter = adapter

        val spanCount = 2
        val layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.layoutManager = layoutManager
    }
}
