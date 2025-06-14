package software_engineering

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import software_engineering.project.ombre.Classify
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations

class PickCategory: AppCompatActivity() {

    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String

    private lateinit var btnActiveChoice: Button
    private lateinit var btnCasualChoice: Button
    private lateinit var btnFormalChoice: Button
    private lateinit var btnUrbanChoice: Button

    private lateinit var btnGirl: Button
    private lateinit var btnBoy: Button

    private lateinit var btnStart: Button

    private var selectedCategoryButton: Button? = null
    private var selectedGenderButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pick_category)

        btnStart = findViewById(R.id.BtnStart)

        btnActiveChoice = findViewById(R.id.ActiveChoice)
        btnCasualChoice = findViewById(R.id.CasualChoice)
        btnFormalChoice = findViewById(R.id.FormalChoice)
        btnUrbanChoice = findViewById(R.id.UrbanChoice)

        btnGirl = findViewById(R.id.btnGirl)
        btnBoy = findViewById(R.id.btnBoy)

        btnActiveChoice.setOnClickListener {
            selectedCategory = "Active Adventure"
            updateCategorySelection(selectedCategory)
        }
        btnCasualChoice.setOnClickListener {
            selectedCategory = "Business Casual"
            updateCategorySelection(selectedCategory)
        }
        btnFormalChoice.setOnClickListener {
            selectedCategory = "Business Formal"
            updateCategorySelection(selectedCategory)
        }
        btnUrbanChoice.setOnClickListener {
            selectedCategory = "Urban Adventure"
            updateCategorySelection(selectedCategory)
        }

        btnBoy.setOnClickListener {
            selectedGender = "Men"
            updateGenderSelection(selectedGender)
        }

        btnGirl.setOnClickListener {
            selectedGender = "Women"
            updateGenderSelection(selectedGender)
        }

        btnStart.setOnClickListener {
            if (::selectedCategory.isInitialized && ::selectedGender.isInitialized) {
                navigateToChooseCategory()
            } else {
                "Please complete all selection.".showToast()
            }
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_home -> {
                    true
                }

                R.id.action_event -> {
                    val intent = Intent(this, Event::class.java)
                    startActivityWithAnimation(Event::class.java, R.anim.swipe_left_enter, R.anim.swipe_left_exit)
                    startActivity(intent)
                    true
                }

                R.id.action_recommendation -> {
                    val intent = Intent(this, Recommendations::class.java)
                    startActivityWithAnimation(Recommendations::class.java, R.anim.swipe_left_enter, R.anim.swipe_left_exit)
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

    private fun updateCategorySelection(selectedCategory: String) {
        clearButtonSelectionCategory()
        when (selectedCategory) {
            "Active Adventure" -> {
                selectedCategoryButton = btnActiveChoice
                selectedCategoryButton?.setBackgroundResource(R.drawable.ctgactivehighlight)
            }

            "Business Casual" -> {
                selectedCategoryButton = btnCasualChoice
                selectedCategoryButton?.setBackgroundResource(R.drawable.ctgcasualhighlight)
            }

            "Business Formal" -> {
                selectedCategoryButton = btnFormalChoice
                selectedCategoryButton?.setBackgroundResource(R.drawable.ctgformalhighlight)
            }

            "Urban Adventure" -> {
                selectedCategoryButton = btnUrbanChoice
                selectedCategoryButton?.setBackgroundResource(R.drawable.ctgurbanhighlight)
            }
        }
    }

    private fun updateGenderSelection(selectedGender: String) {
        clearButtonSelectionGender()

        when (selectedGender) {
            "Men" -> {
                selectedGenderButton = btnBoy
                selectedGenderButton?.setBackgroundResource(R.drawable.highlightboy)
            }
            "Women" -> {
                selectedGenderButton = btnGirl
                selectedGenderButton?.setBackgroundResource(R.drawable.highlightgirl)
            }
        }
        updateStartButtonAppearance()
    }

    private fun updateStartButtonAppearance() {
        if (::selectedCategory.isInitialized && ::selectedGender.isInitialized) {
            btnStart.setBackgroundResource(R.drawable.btnstarthighlight)
        } else {
            btnStart.setBackgroundResource(R.drawable.btnstart)
        }
    }

    private fun clearButtonSelectionCategory() {
        btnActiveChoice.setBackgroundResource(R.drawable.ctgactive)
        btnCasualChoice.setBackgroundResource(R.drawable.ctgcasual)
        btnFormalChoice.setBackgroundResource(R.drawable.ctgformal)
        btnUrbanChoice.setBackgroundResource(R.drawable.ctgurban)
    }

    private fun clearButtonSelectionGender() {
        btnBoy.setBackgroundResource(R.drawable.boy)
        btnGirl.setBackgroundResource(R.drawable.girl)
    }


    private fun navigateToChooseCategory() {
        val intent = Intent(this, OpenCamera::class.java)
        intent.putExtra("event", selectedCategory)
        intent.putExtra("gender", selectedGender)
        startActivity(intent)
    }

    private fun String.showToast() {
        Toast.makeText(this@PickCategory, this, Toast.LENGTH_SHORT).show()
    }
}