@file:Suppress("DEPRECATION")

package software_engineering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import software_engineering.project.ombre.Classify
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations
import androidx.appcompat.widget.Toolbar


class ChooseSubCategory : AppCompatActivity() {
    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String
    private lateinit var selectedSubCategory: String

    private lateinit var btnactiveadventure: Button
    private lateinit var btnurbanadventure: Button
    private lateinit var btnwateradventure: Button
    private lateinit var btnbusinesscasual: Button
    private lateinit var btnbusinessformal: Button
    private lateinit var btnbusinesstravel: Button

    private lateinit var btnNext2: Button

    private var selectedSubcategoryButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_subcategory)

        val event = intent.getStringExtra("event")
        val gender = intent.getStringExtra("gender")
        val subcategory = intent.getStringExtra("subcategory")

        showHideButtons(event, gender, subcategory)

        btnNext2 = findViewById(R.id.btnNext2)

        btnactiveadventure = findViewById(R.id.btnactive_adventure)
        btnurbanadventure = findViewById(R.id.btnurban_adventure)
        btnwateradventure = findViewById(R.id.btnwater_adventure)
        btnbusinesscasual = findViewById(R.id.btnbusiness_casual)
        btnbusinessformal = findViewById(R.id.btnbusiness_formal)
        btnbusinesstravel = findViewById(R.id.btnbusiness_travel)

        btnactiveadventure.setOnClickListener {
            selectedSubCategory = "Active"
            updateSubCategorySelection(selectedSubCategory)
        }
        btnurbanadventure.setOnClickListener {
            selectedSubCategory = "Urban"
            updateSubCategorySelection(selectedSubCategory)
        }
        btnwateradventure.setOnClickListener {
            selectedSubCategory = "Water"
            updateSubCategorySelection(selectedSubCategory)
        }
        btnbusinesscasual.setOnClickListener {
            selectedSubCategory = "Casual"
            updateSubCategorySelection(selectedSubCategory)
        }
        btnbusinessformal.setOnClickListener {
            selectedSubCategory = "Formal"
            updateSubCategorySelection(selectedSubCategory)
        }
        btnbusinesstravel.setOnClickListener {
            selectedSubCategory = "Travel"
            updateSubCategorySelection(selectedSubCategory)
        }

        // Next button click
        btnNext2.setOnClickListener {
            if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized) {
                // Check if any of the selections is empty
                if (selectedCategory.isNotEmpty() && selectedGender.isNotEmpty() && selectedSubCategory.isNotEmpty()) {
                    // Save user choices and navigate to the next screen
                    val intent = Intent(this, ChooseType::class.java)  // Change to the actual next activity
                    intent.putExtra("event", selectedCategory)
                    intent.putExtra("gender", selectedGender)
                    intent.putExtra("subcategory", selectedSubCategory)
                    startActivity(intent)
                } else {
                    "Please select a subcategory before proceeding".showToast()
                }
            } else {
                "Please select a subcategory before proceeding".showToast()
            }
        }

        btnNext2.setBackgroundResource(R.drawable.continuebtn)

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


    private fun updateSubCategorySelection(selectedSubCategory: String) {
        clearButtonSelectionType()

        when (selectedSubCategory) {
            "Active" -> {
                selectedSubcategoryButton = btnactiveadventure
                selectedSubcategoryButton?.setBackgroundResource(R.drawable.activebtnhighlight)
            }
            "Urban" -> {
                selectedSubcategoryButton = btnurbanadventure
                selectedSubcategoryButton?.setBackgroundResource(R.drawable.urbanbtnhighlight)
            }
            "Water" -> {
                selectedSubcategoryButton = btnwateradventure
                selectedSubcategoryButton?.setBackgroundResource(R.drawable.waterbtnhighlight)
            }
            "Casual" -> {
                selectedSubcategoryButton = btnbusinesscasual
                selectedSubcategoryButton?.setBackgroundResource(R.drawable.businesscasualbtnhighlight)
            }
            "Formal" -> {
                selectedSubcategoryButton = btnbusinessformal
                selectedSubcategoryButton?.setBackgroundResource(R.drawable.businessformalbtnhighlight)
            }
            "Travel" -> {
                selectedSubcategoryButton = btnbusinesstravel
                selectedSubcategoryButton?.setBackgroundResource(R.drawable.businesstravelbtnhighlight)
            }
        }
        updateNextButtonAppearance()
    }

    private fun updateNextButtonAppearance() {
        if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized) {
            btnNext2.setBackgroundResource(R.drawable.continuebtnhighlight)
        } else {
            btnNext2.setBackgroundResource(R.drawable.continuebtn)
        }
    }

    private fun clearButtonSelectionType() {
        btnactiveadventure.setBackgroundResource(R.drawable.activebtn)
        btnurbanadventure.setBackgroundResource(R.drawable.urbanbtn)
        btnwateradventure.setBackgroundResource(R.drawable.waterbtn)
        btnbusinesscasual.setBackgroundResource(R.drawable.businesscasualbtn)
        btnbusinessformal.setBackgroundResource(R.drawable.businessformalbtn)
        btnbusinesstravel.setBackgroundResource(R.drawable.businesstravelbtn)
    }

    private fun showHideButtons(event: String?, gender: String?, subcategory: String?) {
        val btnactiveadventure: Button = findViewById(R.id.btnactive_adventure)
        val btnurbanadventure: Button = findViewById(R.id.btnurban_adventure)
        val btnwateradventure: Button = findViewById(R.id.btnwater_adventure)
        val btnbusinesscasual: Button = findViewById(R.id.btnbusiness_casual)
        val btnbusinessformal: Button = findViewById(R.id.btnbusiness_formal)
        val btnbusinesstravel: Button = findViewById(R.id.btnbusiness_travel)

        // Reset visibility for all buttons
        btnactiveadventure.visibility = View.GONE
        btnurbanadventure.visibility = View.GONE
        btnwateradventure.visibility = View.GONE
        btnbusinesscasual.visibility = View.GONE
        btnbusinessformal.visibility = View.GONE
        btnbusinesstravel.visibility = View.GONE

        // Show buttons based on conditions
        if (event == "Adventure" && (gender == "Men" || gender == "Women")) {
            btnactiveadventure.visibility = View.VISIBLE
            btnurbanadventure.visibility = View.VISIBLE
            btnwateradventure.visibility = View.VISIBLE
        } else if (event == "Business" && (gender == "Men" || gender == "Women")) {
            btnbusinesscasual.visibility = View.VISIBLE
            btnbusinessformal.visibility = View.VISIBLE
            btnbusinesstravel.visibility = View.VISIBLE
        }

        // Save the event and gender values
        selectedCategory = event ?: ""
        selectedGender = gender ?: ""
        selectedSubCategory = subcategory ?: ""
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun String.showToast() {
        Toast.makeText(this@ChooseSubCategory, this, Toast.LENGTH_SHORT).show()
    }
}
