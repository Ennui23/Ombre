@file:Suppress("DEPRECATION")

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

class ChooseColor: AppCompatActivity() {
    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String
    private lateinit var selectedSubCategory: String
    private lateinit var selectedType: String
    private lateinit var selectedColor: String

    private lateinit var btnactiveurbanOutfitBlack: Button
    private lateinit var btnactiveurbanOutfitBrown: Button
    private lateinit var btnactiveurbanOutfitGray: Button
    private lateinit var btnactiveurbanOutfitGreen: Button

    private lateinit var btnwaterAdventureOutfitBlack: Button
    private lateinit var btnwaterAdventureOutfitBlue: Button
    private lateinit var btnwaterAdventureOutfitGreen: Button
    private lateinit var btnwaterAdventureOutfitOrange: Button

    private lateinit var btncasualformalBusinessOutfitBlack: Button
    private lateinit var btncasualformalBusinessOutfitGray: Button
    private lateinit var btncasualformalBusinessOutfitNavy: Button
    private lateinit var btncasualformalBusinessOutfitWhite: Button

    private lateinit var btnLongsleevePoloOutfitGray: Button
    private lateinit var btnLongsleevePoloOutfitLightblue: Button
    private lateinit var btnLongsleevePoloOutfitNavy: Button
    private lateinit var btnLongsleevePoloOutfitWhite: Button

    private lateinit var btnPantsOutfitGray: Button
    private lateinit var btnPantsOutfitKhaki: Button
    private lateinit var btnPantsOutfitLightblue: Button
    private lateinit var btnPantsOutfitTaupe: Button

    private lateinit var btnBlouseOutfitLightblue: Button
    private lateinit var btnBlouseOutfitNavy: Button
    private lateinit var btnBlouseOutfitPink: Button
    private lateinit var btnBlouseOutfitWhite: Button

    private lateinit var btnNext4: Button

    private var selectedColorButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_color)

        val event = intent.getStringExtra("event")
        val gender = intent.getStringExtra("gender")
        val subcategory = intent.getStringExtra("subcategory")
        val type = intent.getStringExtra("type")
        val color = intent.getStringExtra("color")

        showHideButtons(event, gender, subcategory, type, color)

        btnNext4 = findViewById(R.id.btnNext4)

        btnactiveurbanOutfitBlack = findViewById(R.id.btnactive_urbanOutfitBlack)
        btnactiveurbanOutfitBrown = findViewById(R.id.btnactive_urbanOutfitBrown)
        btnactiveurbanOutfitGray = findViewById(R.id.btnactive_urbanOutfitGray)
        btnactiveurbanOutfitGreen = findViewById(R.id.btnactive_urbanOutfitGreen)

        btnwaterAdventureOutfitBlack = findViewById(R.id.btnwaterAdventureOutfitBlack)
        btnwaterAdventureOutfitBlue = findViewById(R.id.btnwaterAdventureOutfitBlue)
        btnwaterAdventureOutfitGreen = findViewById(R.id.btnwaterAdventureOutfitGreen)
        btnwaterAdventureOutfitOrange = findViewById(R.id.btnwaterAdventureOutfitOrange)

        btncasualformalBusinessOutfitBlack = findViewById(R.id.btncasual_formalBusinessOutfitBlack)
        btncasualformalBusinessOutfitGray = findViewById(R.id.btncasual_formalBusinessOutfitGray)
        btncasualformalBusinessOutfitNavy = findViewById(R.id.btncasual_formalBusinessOutfitNavy)
        btncasualformalBusinessOutfitWhite = findViewById(R.id.btncasual_formalBusinessOutfitWhite)

        btnLongsleevePoloOutfitGray = findViewById(R.id.btn_LongsleevePoloOutfitGray)
        btnLongsleevePoloOutfitLightblue = findViewById(R.id.btn_LongsleevePoloOutfitLightblue)
        btnLongsleevePoloOutfitNavy = findViewById(R.id.btn_LongsleevePoloOutfitNavy)
        btnLongsleevePoloOutfitWhite = findViewById(R.id.btn_LongsleevePoloOutfitWhite)

        btnPantsOutfitGray = findViewById(R.id.btn_PantsOutfitGray)
        btnPantsOutfitKhaki = findViewById(R.id.btn_PantsOutfitKhaki)
        btnPantsOutfitLightblue = findViewById(R.id.btn_PantsOutfitLightblue)
        btnPantsOutfitTaupe = findViewById(R.id.btn_PantsOutfitTaupe)

        btnBlouseOutfitLightblue = findViewById(R.id.btn_BlouseOutfitLightblue)
        btnBlouseOutfitNavy = findViewById(R.id.btn_BlouseOutfitNavy)
        btnBlouseOutfitPink = findViewById(R.id.btn_BlouseOutfitPink)
        btnBlouseOutfitWhite = findViewById(R.id.btn_BlouseOutfitWhite)

        val btnactiveurbanOutfitBlack: Button = findViewById(R.id.btnactive_urbanOutfitBlack)
        val btnactiveurbanOutfitBrown: Button = findViewById(R.id.btnactive_urbanOutfitBrown)
        val btnactiveurbanOutfitGray: Button = findViewById(R.id.btnactive_urbanOutfitGray)
        val btnactiveurbanOutfitGreen: Button = findViewById(R.id.btnactive_urbanOutfitGreen)

        val btnwaterAdventureOutfitBlack: Button = findViewById(R.id.btnwaterAdventureOutfitBlack)
        val btnwaterAdventureOutfitBlue: Button = findViewById(R.id.btnwaterAdventureOutfitBlue)
        val btnwaterAdventureOutfitGreen: Button = findViewById(R.id.btnwaterAdventureOutfitGreen)
        val btnwaterAdventureOutfitOrange: Button = findViewById(R.id.btnwaterAdventureOutfitOrange)

        val btncasualformalBusinessOutfitBlack: Button = findViewById(R.id.btncasual_formalBusinessOutfitBlack)
        val btncasualformalBusinessOutfitGray: Button = findViewById(R.id.btncasual_formalBusinessOutfitGray)
        val btncasualformalBusinessOutfitNavy: Button = findViewById(R.id.btncasual_formalBusinessOutfitNavy)
        val btncasualformalBusinessOutfitWhite: Button = findViewById(R.id.btncasual_formalBusinessOutfitWhite)

        val btnLongsleevePoloOutfitGray: Button = findViewById(R.id.btn_LongsleevePoloOutfitGray)
        val btnLongsleevePoloOutfitLightblue: Button = findViewById(R.id.btn_LongsleevePoloOutfitLightblue)
        val btnLongsleevePoloOutfitNavy: Button = findViewById(R.id.btn_LongsleevePoloOutfitNavy)
        val btnLongsleevePoloOutfitWhite: Button = findViewById(R.id.btn_LongsleevePoloOutfitWhite)

        btnactiveurbanOutfitBlack.setOnClickListener {
            selectedColor = "Black"
            updateColorSelection("Adventure", "Men", "Active", "Black")
        }
        btnactiveurbanOutfitBrown.setOnClickListener {
            selectedColor = "Brown"
            updateColorSelection("Adventure", "Men", "Active", "Brown")
        }
        btnactiveurbanOutfitGray.setOnClickListener {
            selectedColor = "Gray"
            updateColorSelection("Adventure", "Men", "Active", "Gray")
        }
        btnactiveurbanOutfitGreen.setOnClickListener {
            selectedColor = "Green"
            updateColorSelection("Adventure", "Men", "Active", "Green")
        }

        btnwaterAdventureOutfitBlack.setOnClickListener {
            selectedColor = "Black"
            updateColorSelection("Adventure", "Men", "Water", "Black")
        }
        btnwaterAdventureOutfitBlue.setOnClickListener {
            selectedColor = "Blue"
            updateColorSelection("Adventure", "Men", "Water", "Blue")
        }
        btnwaterAdventureOutfitGreen.setOnClickListener {
            selectedColor = "Green"
            updateColorSelection("Adventure", "Men", "Water", "Green")
        }
        btnwaterAdventureOutfitOrange.setOnClickListener {
            selectedColor = "Orange"
            updateColorSelection("Adventure", "Men", "Water", "Orange")
        }

        btncasualformalBusinessOutfitBlack.setOnClickListener {
            selectedColor = "Black"
            updateColorSelection("Business", "Men", "Casual", "Black")
        }
        btncasualformalBusinessOutfitGray.setOnClickListener {
            selectedColor = "Gray"
            updateColorSelection("Business", "Men", "Casual", "Gray")
        }
        btncasualformalBusinessOutfitNavy.setOnClickListener {
            selectedColor = "Navy"
            updateColorSelection("Business", "Men", "Casual", "Navy")
        }
        btncasualformalBusinessOutfitWhite.setOnClickListener {
            selectedColor = "White"
            updateColorSelection("Business", "Men", "Casual", "White")
        }


        btnLongsleevePoloOutfitGray.setOnClickListener {
            selectedColor = "Gray"
            updateColorSelection("Business", "Men", "Travel", "Gray")
        }
        btnLongsleevePoloOutfitLightblue.setOnClickListener {
            selectedColor = "Lightblue"
            updateColorSelection("Business", "Men", "Travel", "Lightblue")
        }
        btnLongsleevePoloOutfitNavy.setOnClickListener {
            selectedColor = "Navy"
            updateColorSelection("Business", "Men", "Travel", "Navy")
        }
        btnLongsleevePoloOutfitWhite.setOnClickListener {
            selectedColor = "White"
            updateColorSelection("Business", "Men", "Travel", "White")
        }

        btnPantsOutfitGray.setOnClickListener {
            selectedColor = "Gray"
            updateColorSelection("Business", "Men", "Travel", "Gray")
        }
        btnPantsOutfitKhaki.setOnClickListener {
            selectedColor = "Khaki"
            updateColorSelection("Business", "Men", "Travel", "Khaki")
        }
        btnPantsOutfitLightblue.setOnClickListener {
            selectedColor = "Lightblue"
            updateColorSelection("Business", "Men", "Travel", "Lightblue")
        }
        btnPantsOutfitTaupe.setOnClickListener {
            selectedColor = "Taupe"
            updateColorSelection("Business", "Men", "Travel", "Taupe")
        }

        btnBlouseOutfitLightblue.setOnClickListener {
            selectedColor = "Lightblue"
            updateColorSelection("Business", "Women", "Travel", "Lightblue")
        }
        btnBlouseOutfitNavy.setOnClickListener {
            selectedColor = "Navy"
            updateColorSelection("Business", "Women", "Travel", "Navy")
        }
        btnBlouseOutfitPink.setOnClickListener {
            selectedColor = "Pink"
            updateColorSelection("Business", "Women", "Travel", "Pink")
        }
        btnBlouseOutfitWhite.setOnClickListener {
            selectedColor = "White"
            updateColorSelection("Business", "Women", "Travel", "White")
        }

        // Next button click
        btnNext4.setOnClickListener {
            if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized && ::selectedType.isInitialized && ::selectedColor.isInitialized) {
                // Check if any of the selections is empty
                if (selectedCategory.isNotEmpty() && selectedGender.isNotEmpty() && selectedSubCategory.isNotEmpty() && selectedType.isNotEmpty() && selectedColor.isNotEmpty()) {
                    // Save user choices and navigate to the next screen
                    val intent = Intent(this, ChoosePattern::class.java)  // Change to the actual next activity
                    intent.putExtra("event", selectedCategory)
                    intent.putExtra("gender", selectedGender)
                    intent.putExtra("subcategory", selectedSubCategory)
                    intent.putExtra("type", selectedType)
                    intent.putExtra("color", selectedColor)
                    startActivity(intent)
                } else {
                    "Please select a color before proceeding".showToast()
                }
            } else {
                "Please select a color before proceeding".showToast()
            }
        }

        btnNext4.setBackgroundResource(R.drawable.continuebtn)

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

    private fun updateColorSelection(event: String?, gender: String, subcategory: String?, selectedColor: String) {
        clearButtonSelectionColor()
        when (selectedColor) {
            "Black" -> {
                selectedColorButton = when {
                    (gender == "Men" || gender == "Women") && event == "Adventure" && (subcategory == "Active" || subcategory == "Urban") -> btnactiveurbanOutfitBlack
                    (gender == "Men" || gender == "Women") && event == "Adventure" && subcategory == "Water" -> btnwaterAdventureOutfitBlack
                    (gender == "Men" || gender == "Women") && event == "Business" && (subcategory == "Casual" || subcategory == "Formal") -> btncasualformalBusinessOutfitBlack
                     gender == "Women"  && event == "Business" && subcategory == "Travel" -> btncasualformalBusinessOutfitBlack
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedColorButton?.setBackgroundResource(R.drawable.blackbtnhighlight)
            }
            "Gray" -> {
                selectedColorButton = when {
                    (gender == "Men" || gender == "Women") && event == "Adventure" && (subcategory == "Active" || subcategory == "Urban") -> btnactiveurbanOutfitGray
                     gender == "Men" && event == "Business" && subcategory == "Travel" -> btnLongsleevePoloOutfitGray
                    (gender == "Men" || gender == "Women") && event == "Business" && subcategory == "Travel" -> btnPantsOutfitGray
                    (gender == "Men" || gender == "Women") && event == "Business" && (subcategory == "Casual" || subcategory == "Formal") -> btncasualformalBusinessOutfitGray
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedColorButton?.setBackgroundResource(R.drawable.graybtnhighlight)
            }
            "Brown" -> {
                selectedColorButton = btnactiveurbanOutfitBrown
                selectedColorButton?.setBackgroundResource(R.drawable.brownbtnhighlight)
            }
            "Green" -> {
                selectedColorButton = when {
                    (gender == "Men" || gender == "Women") && event == "Adventure" && (subcategory == "Active" || subcategory == "Urban") -> btnactiveurbanOutfitGreen
                    (gender == "Men" || gender == "Women") && event == "Adventure" && subcategory == "Water" -> btnwaterAdventureOutfitGreen
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedColorButton?.setBackgroundResource(R.drawable.greenbtnhighlight)
            }
            "Navy" -> {
                selectedColorButton = when {
                    (gender == "Men" || gender == "Women") && event == "Business" && (subcategory == "Casual" || subcategory == "Formal") -> btncasualformalBusinessOutfitNavy
                     gender == "Men" && event == "Business" && subcategory == "Travel" -> btnLongsleevePoloOutfitNavy
                    gender == "Women" && event == "Business" && subcategory == "Travel" -> btnBlouseOutfitNavy
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedColorButton?.setBackgroundResource(R.drawable.navybtnhighlight)
            }
            "White" -> {
                selectedColorButton = when {
                    (gender == "Men" || gender == "Women") && event == "Business" && (subcategory == "Casual" || subcategory == "Formal") -> btncasualformalBusinessOutfitWhite
                    gender == "Men" && event == "Business" && subcategory == "Travel" -> btnLongsleevePoloOutfitWhite
                    gender == "Women" && event == "Business" && subcategory == "Travel" -> btnBlouseOutfitWhite
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedColorButton?.setBackgroundResource(R.drawable.whitebtnhighlight)
            }
            "Lightblue" -> {
                selectedColorButton = when {
                    gender == "Men" && event == "Business" && subcategory == "Travel" -> btnPantsOutfitLightblue
                    gender == "Women" && event == "Business" && subcategory == "Travel" -> btnBlouseOutfitLightblue
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedColorButton?.setBackgroundResource(R.drawable.lightbluebtnhighlight)
            }
            "Blue" -> {
                selectedColorButton = btnwaterAdventureOutfitBlue
                selectedColorButton?.setBackgroundResource(R.drawable.bluebtnhighlight)
            }
            "Orange" -> {
                selectedColorButton = btnwaterAdventureOutfitOrange
                selectedColorButton?.setBackgroundResource(R.drawable.orangebtnhighlight)
            }
            "Khaki" -> {
                selectedColorButton = btnPantsOutfitKhaki
                selectedColorButton?.setBackgroundResource(R.drawable.khakibtnhighlight)
            }
            "Taupe" -> {
                selectedColorButton = btnPantsOutfitTaupe
                selectedColorButton?.setBackgroundResource(R.drawable.taupebtnhighlight)
            }
            "Pink" -> {
                selectedColorButton = btnBlouseOutfitPink
                selectedColorButton?.setBackgroundResource(R.drawable.pinkbtnhighlight)
            }
        }
        updateNextButtonAppearance()
    }

    private fun updateNextButtonAppearance() {
        if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedType.isInitialized && ::selectedColor.isInitialized) {
            btnNext4.setBackgroundResource(R.drawable.continuebtnhighlight)
        } else {
            btnNext4.setBackgroundResource(R.drawable.continuebtn)
        }
    }

    private fun clearButtonSelectionColor() {
        btnactiveurbanOutfitBlack.setBackgroundResource(R.drawable.blackbtn)
        btnactiveurbanOutfitBrown.setBackgroundResource(R.drawable.brownbtn)
        btnactiveurbanOutfitGray.setBackgroundResource(R.drawable.graybtn)
        btnactiveurbanOutfitGreen.setBackgroundResource(R.drawable.greenbtn)

        btnwaterAdventureOutfitBlack.setBackgroundResource(R.drawable.blackbtn)
        btnwaterAdventureOutfitBlue.setBackgroundResource(R.drawable.bluebtn)
        btnwaterAdventureOutfitGreen.setBackgroundResource(R.drawable.greenbtn)
        btnwaterAdventureOutfitOrange.setBackgroundResource(R.drawable.orangebtn)

        btncasualformalBusinessOutfitBlack.setBackgroundResource(R.drawable.blackbtn)
        btncasualformalBusinessOutfitGray.setBackgroundResource(R.drawable.graybtn)
        btncasualformalBusinessOutfitNavy.setBackgroundResource(R.drawable.navybtn)
        btncasualformalBusinessOutfitWhite.setBackgroundResource(R.drawable.whitebtn)

        btnLongsleevePoloOutfitGray.setBackgroundResource(R.drawable.graybtn)
        btnLongsleevePoloOutfitLightblue.setBackgroundResource(R.drawable.lightbluebtn)
        btnLongsleevePoloOutfitNavy.setBackgroundResource(R.drawable.navybtn)
        btnLongsleevePoloOutfitWhite.setBackgroundResource(R.drawable.whitebtn)

        btnPantsOutfitGray.setBackgroundResource(R.drawable.graybtn)
        btnPantsOutfitKhaki.setBackgroundResource(R.drawable.khakibtn)
        btnPantsOutfitLightblue.setBackgroundResource(R.drawable.lightbluebtn)
        btnPantsOutfitTaupe.setBackgroundResource(R.drawable.taupebtn)

        btnBlouseOutfitLightblue.setBackgroundResource(R.drawable.lightbluebtn)
        btnBlouseOutfitNavy.setBackgroundResource(R.drawable.navybtn)
        btnBlouseOutfitPink.setBackgroundResource(R.drawable.pinkbtn)
        btnBlouseOutfitWhite.setBackgroundResource(R.drawable.whitebtn)
    }

    private fun showHideButtons(event: String?, gender: String?, subcategory: String?, type: String?, color: String?) {

        val btnactiveurbanOutfitBlack: Button = findViewById(R.id.btnactive_urbanOutfitBlack)
        val btnactiveurbanOutfitBrown: Button = findViewById(R.id.btnactive_urbanOutfitBrown)
        val btnactiveurbanOutfitGray: Button = findViewById(R.id.btnactive_urbanOutfitGray)
        val btnactiveurbanOutfitGreen: Button = findViewById(R.id.btnactive_urbanOutfitGreen)

        val btnwaterAdventureOutfitBlack: Button = findViewById(R.id.btnwaterAdventureOutfitBlack)
        val btnwaterAdventureOutfitBlue: Button = findViewById(R.id.btnwaterAdventureOutfitBlue)
        val btnwaterAdventureOutfitGreen: Button = findViewById(R.id.btnwaterAdventureOutfitGreen)
        val btnwaterAdventureOutfitOrange: Button = findViewById(R.id.btnwaterAdventureOutfitOrange)

        val btncasualformalBusinessOutfitBlack: Button = findViewById(R.id.btncasual_formalBusinessOutfitBlack)
        val btncasualformalBusinessOutfitGray: Button = findViewById(R.id.btncasual_formalBusinessOutfitGray)
        val btncasualformalBusinessOutfitNavy: Button = findViewById(R.id.btncasual_formalBusinessOutfitNavy)
        val btncasualformalBusinessOutfitWhite: Button = findViewById(R.id.btncasual_formalBusinessOutfitWhite)

        val btnLongsleevePoloOutfitGray: Button = findViewById(R.id.btn_LongsleevePoloOutfitGray)
        val btnLongsleevePoloOutfitLightblue: Button = findViewById(R.id.btn_LongsleevePoloOutfitLightblue)
        val btnLongsleevePoloOutfitNavy: Button = findViewById(R.id.btn_LongsleevePoloOutfitNavy)
        val btnLongsleevePoloOutfitWhite: Button = findViewById(R.id.btn_LongsleevePoloOutfitWhite)

        val btnPantsOutfitGray: Button = findViewById(R.id.btn_PantsOutfitGray)
        val btnPantsOutfitKhaki: Button = findViewById(R.id.btn_PantsOutfitKhaki)
        val btnPantsOutfitLightblue: Button = findViewById(R.id.btn_PantsOutfitLightblue)
        val btnPantsOutfitTaupe: Button = findViewById(R.id.btn_PantsOutfitTaupe)

        val btnBlouseOutfitLightblue: Button = findViewById(R.id.btn_BlouseOutfitLightblue)
        val btnBlouseOutfitNavy: Button = findViewById(R.id.btn_BlouseOutfitNavy)
        val btnBlouseOutfitPink: Button = findViewById(R.id.btn_BlouseOutfitPink)
        val btnBlouseOutfitWhite: Button = findViewById(R.id.btn_BlouseOutfitWhite)

        // Reset visibility for all buttons
        btnactiveurbanOutfitBlack.visibility = View.GONE
        btnactiveurbanOutfitBrown.visibility = View.GONE
        btnactiveurbanOutfitGray.visibility = View.GONE
        btnactiveurbanOutfitGreen.visibility = View.GONE

        btnwaterAdventureOutfitBlack.visibility = View.GONE
        btnwaterAdventureOutfitBlue.visibility = View.GONE
        btnwaterAdventureOutfitGreen.visibility = View.GONE
        btnwaterAdventureOutfitOrange.visibility = View.GONE

        btncasualformalBusinessOutfitBlack.visibility = View.GONE
        btncasualformalBusinessOutfitGray.visibility = View.GONE
        btncasualformalBusinessOutfitNavy.visibility = View.GONE
        btncasualformalBusinessOutfitWhite.visibility = View.GONE

        btnLongsleevePoloOutfitGray.visibility = View.GONE
        btnLongsleevePoloOutfitLightblue.visibility = View.GONE
        btnLongsleevePoloOutfitNavy.visibility = View.GONE
        btnLongsleevePoloOutfitWhite.visibility = View.GONE

        btnPantsOutfitGray.visibility = View.GONE
        btnPantsOutfitKhaki.visibility = View.GONE
        btnPantsOutfitLightblue.visibility = View.GONE
        btnPantsOutfitTaupe.visibility = View.GONE

        btnBlouseOutfitLightblue.visibility = View.GONE
        btnBlouseOutfitNavy.visibility = View.GONE
        btnBlouseOutfitPink.visibility = View.GONE
        btnBlouseOutfitWhite.visibility = View.GONE

        // Show buttons based on conditions
        when {
            event == "Adventure" && (gender == "Men" || gender == "Women") && (subcategory == "Active" || subcategory == "Urban")
                    && (type in listOf("Jackets", "Joggers", "Shorts", "Tanktops", "Tshirt")) -> {
                btnactiveurbanOutfitBlack.visibility = View.VISIBLE
                btnactiveurbanOutfitBrown.visibility = View.VISIBLE
                btnactiveurbanOutfitGray.visibility = View.VISIBLE
                btnactiveurbanOutfitGreen.visibility = View.VISIBLE
            }
            event == "Adventure" && (gender == "Men" || gender == "Women") && subcategory == "Water"
                    && (type in listOf("Boardshorts", "Rashguard", "Bikini")) -> {
                btnwaterAdventureOutfitBlack.visibility = View.VISIBLE
                btnwaterAdventureOutfitBlue.visibility = View.VISIBLE
                btnwaterAdventureOutfitGreen.visibility = View.VISIBLE
                btnwaterAdventureOutfitOrange.visibility = View.VISIBLE
            }
            event == "Business" && (gender == "Men" || gender == "Women") && subcategory in listOf("Casual", "Formal")
                    && (type in listOf("Chinos", "Polo", "Blouse", "Skirt", "Coats", "Trousers", "Trouser")) -> {
                btncasualformalBusinessOutfitBlack.visibility = View.VISIBLE
                btncasualformalBusinessOutfitGray.visibility = View.VISIBLE
                btncasualformalBusinessOutfitNavy.visibility = View.VISIBLE
                btncasualformalBusinessOutfitWhite.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Jacket" -> {
                btncasualformalBusinessOutfitBlack.visibility = View.VISIBLE
                btncasualformalBusinessOutfitGray.visibility = View.VISIBLE
                btncasualformalBusinessOutfitNavy.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Men" && subcategory == "Travel" && (type == "Longsleeve" || type == "Polo") -> {
                btnLongsleevePoloOutfitGray.visibility = View.VISIBLE
                btnLongsleevePoloOutfitLightblue.visibility = View.VISIBLE
                btnLongsleevePoloOutfitNavy.visibility = View.VISIBLE
                btnLongsleevePoloOutfitWhite.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Pants" -> {
                btnPantsOutfitGray.visibility = View.VISIBLE
                btnPantsOutfitKhaki.visibility = View.VISIBLE
                btnPantsOutfitLightblue.visibility = View.VISIBLE
                btnPantsOutfitTaupe.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Pants" -> {
                btncasualformalBusinessOutfitBlack.visibility = View.VISIBLE
                btncasualformalBusinessOutfitGray.visibility = View.VISIBLE
                btncasualformalBusinessOutfitNavy.visibility = View.VISIBLE
                btncasualformalBusinessOutfitWhite.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Suit" -> {
                btnLongsleevePoloOutfitGray.visibility = View.VISIBLE
                btnLongsleevePoloOutfitLightblue.visibility = View.VISIBLE
                btnLongsleevePoloOutfitNavy.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Blouse" -> {
                btnBlouseOutfitLightblue.visibility = View.VISIBLE
                btnBlouseOutfitNavy.visibility = View.VISIBLE
                btnBlouseOutfitPink.visibility = View.VISIBLE
                btnBlouseOutfitWhite.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Dress" -> {
                btncasualformalBusinessOutfitBlack.visibility = View.VISIBLE
                btncasualformalBusinessOutfitGray.visibility = View.VISIBLE
                btncasualformalBusinessOutfitNavy.visibility = View.VISIBLE
                btncasualformalBusinessOutfitWhite.visibility = View.VISIBLE
            }
            event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Skirt" -> {
                btncasualformalBusinessOutfitBlack.visibility = View.VISIBLE
                btncasualformalBusinessOutfitGray.visibility = View.VISIBLE
                btncasualformalBusinessOutfitNavy.visibility = View.VISIBLE
                btncasualformalBusinessOutfitWhite.visibility = View.VISIBLE
            }
            else -> {
                // Handle the case when none of the above conditions are met
            }
        }

        // Save the event and gender values
        selectedCategory = event ?: ""
        selectedGender = gender ?: ""
        selectedSubCategory = subcategory ?: ""
        selectedType = type ?: ""
        selectedColor = color ?: ""
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun String.showToast() {
        Toast.makeText(this@ChooseColor, this, Toast.LENGTH_SHORT).show()
    }
}