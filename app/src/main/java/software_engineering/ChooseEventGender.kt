@file:Suppress("DEPRECATION")

package software_engineering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import software_engineering.project.ombre.Classify
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations

class ChooseEventGender : AppCompatActivity() {

    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String

    private lateinit var btnAdventure: Button
    private lateinit var btnBusiness: Button
    private lateinit var btnMen: Button
    private lateinit var btnWomen: Button
    private lateinit var btnNext: Button

    private var selectedCategoryButton: Button? = null
    private var selectedGenderButton: Button? = null

    private fun updateNextButtonAppearance() {
        if (::selectedCategory.isInitialized && ::selectedGender.isInitialized) {
            btnNext.setBackgroundResource(R.drawable.continuebtnhighlight)
        } else {
            btnNext.setBackgroundResource(R.drawable.continuebtn)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_event_gender)

        btnAdventure = findViewById(R.id.btnTravelAdventure)
        btnBusiness = findViewById(R.id.btnBusiness)
        btnMen = findViewById(R.id.btnMen)
        btnWomen = findViewById(R.id.btnWomen)
        btnNext = findViewById(R.id.btnNext)

        // Event selection
        btnAdventure.setOnClickListener {
            selectedCategory = "Adventure"
            updateEventSelection(selectedCategory)
        }

        btnBusiness.setOnClickListener {
            selectedCategory = "Business"
            updateEventSelection(selectedCategory)
        }

        // Gender selection
        btnMen.setOnClickListener {
            selectedGender = "Men"
            updateGenderSelection(selectedGender)
        }

        btnWomen.setOnClickListener {
            selectedGender = "Women"
            updateGenderSelection(selectedGender)
        }

        // Next button click
        btnNext.setOnClickListener {
            if (::selectedCategory.isInitialized && ::selectedGender.isInitialized) {
                // Save user choices and navigate to the next screen
                navigateToChooseType()
            } else {
                "Please complete all selections before proceeding".showToast()
            }
        }

        updateNextButtonAppearance()

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

    private fun updateEventSelection(selectedCategory: String) {
        clearButtonSelectionEvent()

        when (selectedCategory) {
            "Adventure" -> {
                selectedCategoryButton = btnAdventure
                selectedCategoryButton?.setBackgroundResource(R.drawable.adventurebtnhighlight)
            }
            "Business" -> {
                selectedCategoryButton = btnBusiness
                selectedCategoryButton?.setBackgroundResource(R.drawable.businessbtnhighlight)
            }
        }
        updateNextButtonAppearance()
    }

    private fun updateGenderSelection(selectedGender: String) {
        clearButtonSelectionGender()

        when (selectedGender) {
            "Men" -> {
                selectedGenderButton = btnMen
                selectedGenderButton?.setBackgroundResource(R.drawable.menbtnhighlight)
            }
            "Women" -> {
                selectedGenderButton = btnWomen
                selectedGenderButton?.setBackgroundResource(R.drawable.womenbtnhighlight)
            }
        }
        updateNextButtonAppearance()
    }

    private fun clearButtonSelectionEvent() {
        btnAdventure.setBackgroundResource(R.drawable.adventurebtn)
        btnBusiness.setBackgroundResource(R.drawable.businessbtn)
    }

    private fun clearButtonSelectionGender() {
        btnMen.setBackgroundResource(R.drawable.menbtn)
        btnWomen.setBackgroundResource(R.drawable.womenbtn)
    }

    private fun navigateToChooseType() {
        val intent = Intent(this, ChooseSubCategory::class.java)
        intent.putExtra("event", selectedCategory)
        intent.putExtra("gender", selectedGender)
        startActivity(intent)
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun String.showToast() {
        Toast.makeText(this@ChooseEventGender, this, Toast.LENGTH_SHORT).show()
    }
}
