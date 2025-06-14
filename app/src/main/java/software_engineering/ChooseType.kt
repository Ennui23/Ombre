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

class ChooseType : AppCompatActivity() {
    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String
    private lateinit var selectedSubCategory: String
    private lateinit var selectedType: String

    private lateinit var btnJacketsMenAdventureActive: Button
    private lateinit var btnJoggersMenAdventureActive: Button
    private lateinit var btnShortsMenAdventureActive: Button
    private lateinit var btnTshirtMenAdventureActive: Button
    private lateinit var btnTanktopsMenAdventureActive: Button

    private lateinit var btnJacketWomenAdventureActive: Button
    private lateinit var btnJoggerWomenAdventureActive: Button
    private lateinit var btnShortsWomenAdventureActive: Button
    private lateinit var btnTshirtWomenAdventureActive: Button
    private lateinit var btnTanktopsWomenAdventureActive: Button

    private lateinit var btnJacketsMenAdventureUrban: Button
    private lateinit var btnJoggersMenAdventureUrban: Button
    private lateinit var btnShortsMenAdventureUrban: Button
    private lateinit var btnTshirtMenAdventureUrban: Button
    private lateinit var btnTanktopsMenAdventureUrban: Button

    private lateinit var btnJacketWomenAdventureUrban: Button
    private lateinit var btnJoggerWomenAdventureUrban: Button
    private lateinit var btnShortsWomenAdventureUrban: Button
    private lateinit var btnTshirtWomenAdventureUrban: Button
    private lateinit var btnTanktopsWomenAdventureUrban: Button

    private lateinit var btnBoardshortsMenAdventureWater: Button
    private lateinit var btnRashguardMenAdventureWater: Button

    private lateinit var btnBikiniWomenAdventureWater: Button
    private lateinit var btnRashguardWomenAdventureWater: Button

    private lateinit var btnChinosMenBusinessCasual: Button
    private lateinit var btnPoloMenBusinessCasual: Button
    private lateinit var btnTrousersMenBusinessCasual: Button

    private lateinit var btnBlouseWomenBusinessCasual: Button
    private lateinit var btnSkirtWomenBusinessCasual: Button
    private lateinit var btnTrouserWomenBusinessCasual: Button

    private lateinit var btnChinosMenBusinessFormal: Button
    private lateinit var btnCoatsMenBusinessFormal: Button
    private lateinit var btnTrousersMenBusinessFormal: Button

    private lateinit var btnBlouseWomenBusinessFormal: Button
    private lateinit var btnJacketWomenBusinessFormal: Button
    private lateinit var btnSkirtWomenBusinessFormal: Button
    private lateinit var btnTrouserWomenBusinessFormal: Button

    private lateinit var btnLongsleeveMenBusinessTravel: Button
    private lateinit var btnPantsMenBusinessTravel: Button
    private lateinit var btnPoloMenBusinessTravel: Button
    private lateinit var btnSuitMenBusinessTravel: Button

    private lateinit var btnBlouseWomenBusinessTravel: Button
    private lateinit var btnDressWomenBusinessTravel: Button
    private lateinit var btnPantsWomenBusinessTravel: Button
    private lateinit var btnSkirtWomenBusinessTravel: Button

    private lateinit var btnNext3: Button

    private var selectedTypeButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_type)

        val event = intent.getStringExtra("event")
        val gender = intent.getStringExtra("gender")
        val subcategory = intent.getStringExtra("subcategory")
        val type = intent.getStringExtra("type")

        showHideButtons(event, gender, subcategory, type)

        btnNext3 = findViewById(R.id.btnNext3)

        btnJacketsMenAdventureActive = findViewById(R.id.btnJacketsActive)
        btnJoggersMenAdventureActive = findViewById(R.id.btnJoggersActive)
        btnShortsMenAdventureActive = findViewById(R.id.btnShortsActive)
        btnTshirtMenAdventureActive = findViewById(R.id.btnShirtActive)
        btnTanktopsMenAdventureActive = findViewById(R.id.btnTanktopActive)

        btnJacketWomenAdventureActive = findViewById(R.id.btnJacketsWomenActive)
        btnJoggerWomenAdventureActive = findViewById(R.id.btnJoggersWomenActive)
        btnShortsWomenAdventureActive = findViewById(R.id.btnShortsWomenActive)
        btnTshirtWomenAdventureActive = findViewById(R.id.btnShirtWomenActive)
        btnTanktopsWomenAdventureActive = findViewById(R.id.btnTanktopWomenActive)

        btnJacketsMenAdventureUrban = findViewById(R.id.btnJacketsUrban)
        btnJoggersMenAdventureUrban = findViewById(R.id.btnJoggersUrban)
        btnShortsMenAdventureUrban = findViewById(R.id.btnShortsUrban)
        btnTshirtMenAdventureUrban = findViewById(R.id.btnShirtUrban)
        btnTanktopsMenAdventureUrban = findViewById(R.id.btnTanktopUrban)

        btnJacketWomenAdventureUrban = findViewById(R.id.btnJacketsWomenUrban)
        btnJoggerWomenAdventureUrban = findViewById(R.id.btnJoggersWomenUrban)
        btnShortsWomenAdventureUrban = findViewById(R.id.btnShortsWomenUrban)
        btnTshirtWomenAdventureUrban = findViewById(R.id.btnShirtWomenUrban)
        btnTanktopsWomenAdventureUrban = findViewById(R.id.btnTanktopWomenUrban)

        btnBoardshortsMenAdventureWater = findViewById(R.id.btnBoardShorts)
        btnRashguardMenAdventureWater = findViewById(R.id.btnRashguard)

        btnBikiniWomenAdventureWater = findViewById(R.id.btnBikini)
        btnRashguardWomenAdventureWater = findViewById(R.id.btnRashguardWomen)

        btnChinosMenBusinessCasual = findViewById(R.id.btnChinos)
        btnPoloMenBusinessCasual = findViewById(R.id.btnPolo)
        btnTrousersMenBusinessCasual = findViewById(R.id.btnTrouserCasualMen)

        btnBlouseWomenBusinessCasual = findViewById(R.id.btnBlouse)
        btnSkirtWomenBusinessCasual = findViewById(R.id.btnSkirt)
        btnTrouserWomenBusinessCasual = findViewById(R.id.btnTrouserCasualWomen)

        btnChinosMenBusinessFormal = findViewById(R.id.btnChinosFormalMen)
        btnCoatsMenBusinessFormal = findViewById(R.id.btnCoats)
        btnTrousersMenBusinessFormal = findViewById(R.id.btnTrouserFormalMen)

        btnBlouseWomenBusinessFormal = findViewById(R.id.btnBlouseFormal)
        btnJacketWomenBusinessFormal = findViewById(R.id.btnJacketFormalWomen)
        btnSkirtWomenBusinessFormal = findViewById(R.id.btnSkirtFormal)
        btnTrouserWomenBusinessFormal = findViewById(R.id.btnTrouserFormalWomen)

        btnLongsleeveMenBusinessTravel = findViewById(R.id.btnLongsleeveTravelMen)
        btnPantsMenBusinessTravel = findViewById(R.id.btnPants)
        btnPoloMenBusinessTravel = findViewById(R.id.btnPoloTravelMen)
        btnSuitMenBusinessTravel = findViewById(R.id.btnSuitTravelMen)

        btnBlouseWomenBusinessTravel = findViewById(R.id.btnBlouseTravel)
        btnDressWomenBusinessTravel = findViewById(R.id.btnDress)
        btnPantsWomenBusinessTravel = findViewById(R.id.btnPantsTravelWomen)
        btnSkirtWomenBusinessTravel = findViewById(R.id.btnSkirtTravel)

        btnJacketsMenAdventureActive.setOnClickListener {
            selectedType = "Jackets"
            updateTypeSelection("Adventure", "Men", "Active", "Jackets")
        }
        btnJoggersMenAdventureActive.setOnClickListener {
            selectedType = "Joggers"
            updateTypeSelection("Adventure", "Men", "Active", "Joggers")
        }
        btnShortsMenAdventureActive.setOnClickListener {
            selectedType = "Shorts"
            updateTypeSelection("Adventure", "Men", "Active", "Shorts")
        }
        btnTanktopsMenAdventureActive.setOnClickListener {
            selectedType = "Tanktops"
            updateTypeSelection("Adventure", "Men", "Active", "Tanktops")
        }
        btnTshirtMenAdventureActive.setOnClickListener {
            selectedType = "Tshirt"
            updateTypeSelection("Adventure", "Men", "Active", "Tshirt")
        }

        btnJacketWomenAdventureActive.setOnClickListener {
            selectedType = "Jackets"
            updateTypeSelection("Adventure", "Women", "Active", "Jackets")
        }
        btnJoggerWomenAdventureActive.setOnClickListener {
            selectedType = "Joggers"
            updateTypeSelection("Adventure", "Women", "Active", "Joggers")
        }
        btnShortsWomenAdventureActive.setOnClickListener {
            selectedType = "Shorts"
            updateTypeSelection("Adventure", "Women", "Active", "Shorts")
        }
        btnTshirtWomenAdventureActive.setOnClickListener {
            selectedType = "Tshirt"
            updateTypeSelection("Adventure", "Women", "Active", "Tshirt")
        }
        btnTanktopsWomenAdventureActive.setOnClickListener {
            selectedType = "Tanktops"
            updateTypeSelection("Adventure", "Women", "Active", "Tanktops")
        }

        btnJacketsMenAdventureUrban.setOnClickListener {
            selectedType = "Jackets"
            updateTypeSelection("Adventure", "Men", "Urban", "Jackets")
        }
        btnJoggersMenAdventureUrban.setOnClickListener {
            selectedType = "Joggers"
            updateTypeSelection("Adventure", "Men", "Urban", "Joggers")
        }
        btnShortsMenAdventureUrban.setOnClickListener {
            selectedType = "Shorts"
            updateTypeSelection("Adventure", "Men", "Urban", "Shorts")
        }
        btnTanktopsMenAdventureUrban.setOnClickListener {
            selectedType = "Tanktops"
            updateTypeSelection("Adventure", "Men", "Urban", "Tanktops")
        }
        btnTshirtMenAdventureUrban.setOnClickListener {
            selectedType = "Tshirt"
            updateTypeSelection("Adventure", "Men", "Urban", "Tshirt")
        }

        btnJacketWomenAdventureUrban.setOnClickListener {
            selectedType = "Jackets"
            updateTypeSelection("Adventure", "Women", "Urban", "Jackets")
        }
        btnJoggerWomenAdventureUrban.setOnClickListener {
            selectedType = "Joggers"
            updateTypeSelection("Adventure", "Women", "Urban", "Joggers")
        }
        btnShortsWomenAdventureUrban.setOnClickListener {
            selectedType = "Shorts"
            updateTypeSelection("Adventure", "Women", "Urban", "Shorts")
        }
        btnTshirtWomenAdventureUrban.setOnClickListener {
            selectedType = "Tshirt"
            updateTypeSelection("Adventure", "Women", "Urban", "Tshirt")
        }
        btnTanktopsWomenAdventureUrban.setOnClickListener {
            selectedType = "Tanktops"
            updateTypeSelection("Adventure", "Women", "Urban", "Tanktops")
        }

        btnBoardshortsMenAdventureWater.setOnClickListener {
            selectedType = "Boardshorts"
            updateTypeSelection("Adventure", "Men", "Water", "Boardshorts")
        }
        btnRashguardMenAdventureWater.setOnClickListener {
            selectedType = "Rashguard"
            updateTypeSelection("Adventure", "Men", "Water", "Rashguard")
        }

        btnBikiniWomenAdventureWater.setOnClickListener {
            selectedType = "Bikini"
            updateTypeSelection("Adventure", "Women", "Water", "Bikini")
        }
        btnRashguardWomenAdventureWater.setOnClickListener {
            selectedType = "Rashguard"
            updateTypeSelection("Adventure", "Women", "Water", "Rashguard")
        }

        btnChinosMenBusinessCasual.setOnClickListener {
            selectedType = "Chinos"
            updateTypeSelection("Business", "Men", "Casual", "Chinos")
        }
        btnPoloMenBusinessCasual.setOnClickListener {
            selectedType = "Polo"
            updateTypeSelection("Business", "Men", "Casual", "Polo")
        }
        btnTrousersMenBusinessCasual.setOnClickListener {
            selectedType = "Trousers"
            updateTypeSelection("Business", "Men", "Casual", "Trousers")
        }

        btnBlouseWomenBusinessCasual.setOnClickListener {
            selectedType = "Blouse"
            updateTypeSelection("Business", "Women", "Casual", "Blouse")
        }
        btnSkirtWomenBusinessCasual.setOnClickListener {
            selectedType = "Skirt"
            updateTypeSelection("Business", "Women", "Casual", "Skirt")
        }
        btnTrouserWomenBusinessCasual.setOnClickListener {
            selectedType = "Trouser"
            updateTypeSelection("Business", "Women", "Casual", "Trouser")
        }

        btnChinosMenBusinessFormal.setOnClickListener {
            selectedType = "Chinos"
            updateTypeSelection("Business", "Men", "Formal", "Chinos")
        }
        btnCoatsMenBusinessFormal.setOnClickListener {
            selectedType = "Coats"
            updateTypeSelection("Business", "Men", "Formal", "Coats")
        }
        btnTrousersMenBusinessFormal.setOnClickListener {
            selectedType = "Trousers"
            updateTypeSelection("Business", "Men", "Formal", "Trousers")
        }

        btnBlouseWomenBusinessFormal.setOnClickListener {
            selectedType = "Blouse"
            updateTypeSelection("Business", "Women", "Formal", "Blouse")
        }
        btnJacketWomenBusinessFormal.setOnClickListener {
            selectedType = "Jacket"
            updateTypeSelection("Business", "Women", "Formal", "Jacket")
        }
        btnSkirtWomenBusinessFormal.setOnClickListener {
            selectedType = "Skirt"
            updateTypeSelection("Business", "Women", "Formal", "Skirt")
        }
        btnTrouserWomenBusinessFormal.setOnClickListener {
            selectedType = "Trouser"
            updateTypeSelection("Business", "Women", "Formal", "Trouser")
        }

        btnLongsleeveMenBusinessTravel.setOnClickListener {
            selectedType = "Longsleeve"
            updateTypeSelection("Business", "Men", "Travel", "Longsleeve")
        }
        btnPantsMenBusinessTravel.setOnClickListener {
            selectedType = "Pants"
            updateTypeSelection("Business", "Men", "Travel", "Pants")
        }
        btnPoloMenBusinessTravel.setOnClickListener {
            selectedType = "Polo"
            updateTypeSelection("Business", "Men", "Travel", "Polo")
        }
        btnSuitMenBusinessTravel.setOnClickListener {
            selectedType = "Suit"
            updateTypeSelection("Business", "Men", "Travel", "Suit")
        }

        btnBlouseWomenBusinessTravel.setOnClickListener {
            selectedType = "Blouse"
            updateTypeSelection("Business", "Women", "Travel", "Blouse")
        }
        btnDressWomenBusinessTravel.setOnClickListener {
            selectedType = "Dress"
            updateTypeSelection("Business", "Women", "Travel", "Dress")
        }
        btnPantsWomenBusinessTravel.setOnClickListener {
            selectedType = "Pants"
            updateTypeSelection("Business", "Women", "Travel", "Pants")
        }
        btnSkirtWomenBusinessTravel.setOnClickListener {
            selectedType = "Skirt"
            updateTypeSelection("Business", "Women", "Travel", "Skirt")
        }

        // Next button click
        btnNext3.setOnClickListener {
            if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized && ::selectedType.isInitialized) {
                // Check if any of the selections is empty
                if (selectedCategory.isNotEmpty() && selectedGender.isNotEmpty() && selectedSubCategory.isNotEmpty() && selectedType.isNotEmpty()) {
                    // Save user choices and navigate to the next screen
                    val intent = Intent(this, ChooseColor::class.java)  // Change to the actual next activity
                    intent.putExtra("event", selectedCategory)
                    intent.putExtra("gender", selectedGender)
                    intent.putExtra("subcategory", selectedSubCategory)
                    intent.putExtra("type", selectedType)
                    startActivity(intent)
                } else {
                    "Please select a type before proceeding".showToast()
                }
            } else {
                "Please select a type before proceeding".showToast()
            }
        }

        btnNext3.setBackgroundResource(R.drawable.continuebtn)

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

    private fun updateTypeSelection(event: String?, gender: String, subcategory: String?, selectedType: String) {
        clearButtonSelectionType()
        when (selectedType) {
            "Jackets" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnJacketsMenAdventureActive
                    } else {
                        btnJacketsMenAdventureUrban
                    }
                } else {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnJacketWomenAdventureActive
                    } else {
                        btnJacketWomenAdventureUrban
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.jacketsbtnhighlight)
            }
            "Joggers" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnJoggersMenAdventureActive
                    } else {
                        btnJoggersMenAdventureUrban
                    }
                } else {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnJoggerWomenAdventureActive
                    } else {
                        btnJoggerWomenAdventureUrban
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.joggersbtnhighlight)
            }
            "Shorts" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnShortsMenAdventureActive
                    } else {
                        btnShortsMenAdventureUrban
                    }
                } else {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnShortsWomenAdventureActive
                    } else {
                        btnShortsWomenAdventureUrban
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.shortshighlight)
            }
            "Tanktops" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnTanktopsMenAdventureActive
                    } else {
                        btnTanktopsMenAdventureUrban
                    }
                } else {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnTanktopsWomenAdventureActive
                    } else {
                        btnTanktopsWomenAdventureUrban
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.tanktopsbtnhighlight)
            }
            "Tshirt" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnTshirtMenAdventureActive
                    } else {
                        btnTshirtMenAdventureUrban
                    }
                } else {
                    if (event == "Adventure" && subcategory == "Active") {
                        btnTshirtWomenAdventureActive
                    } else {
                        btnTshirtWomenAdventureUrban
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.tshirtbtnhighlight)
            }
            "Boardshorts" -> {
                selectedTypeButton = btnBoardshortsMenAdventureWater
                selectedTypeButton?.setBackgroundResource(R.drawable.boardshortsbtnhighlight)
            }
            "Bikini" -> {
                selectedTypeButton = btnBikiniWomenAdventureWater
                selectedTypeButton?.setBackgroundResource(R.drawable.bikinibtnhighlight)
            }
            "Rashguard" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Adventure" && subcategory == "Water") {
                        btnRashguardMenAdventureWater
                    } else {
                        btnRashguardWomenAdventureWater
                    }
                } else {
                    if (event == "Adventure" && subcategory == "Water") {
                        btnRashguardWomenAdventureWater
                    } else {
                        btnRashguardMenAdventureWater
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.rashguardbtnhighlight)
            }
            "Chinos" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Business" && subcategory == "Casual") {
                        btnChinosMenBusinessCasual
                    } else {
                        btnChinosMenBusinessFormal
                    }
                } else {
                    if (event == "Business" && subcategory == "Formal") {
                        btnChinosMenBusinessFormal
                    } else {
                        btnChinosMenBusinessCasual
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.chinosbtnhighlight)
            }
            "Polo" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Business" && subcategory == "Casual") {
                        btnPoloMenBusinessCasual
                    } else {
                        btnPoloMenBusinessTravel
                    }
                } else {
                    if (event == "Business" && subcategory == "Travel") {
                        btnPoloMenBusinessTravel
                    } else {
                        btnPoloMenBusinessCasual
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.polobtnhighlight)
            }
            "Trousers" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Business" && subcategory == "Casual") {
                        btnTrousersMenBusinessCasual
                    } else {
                        btnTrousersMenBusinessFormal
                    }
                } else {
                    if (event == "Business" && subcategory == "Formal") {
                        btnTrousersMenBusinessFormal
                    } else {
                        btnTrousersMenBusinessCasual
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.trouserbtnhighlight)
            }
            "Trouser" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Business" && subcategory == "Casual") {
                        btnTrousersMenBusinessCasual
                    } else {
                        btnTrousersMenBusinessFormal
                    }
                } else {
                    if (event == "Business" && subcategory == "Casual") {
                        btnTrouserWomenBusinessCasual
                    } else {
                        btnTrouserWomenBusinessFormal
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.trouserbtnhighlight)
            }
            "Blouse" -> {
                selectedTypeButton = when {
                    gender == "Women" && event == "Business" && subcategory == "Casual" -> btnBlouseWomenBusinessCasual
                    gender == "Women" && event == "Business" && subcategory == "Travel" -> btnBlouseWomenBusinessTravel
                    gender == "Women" && event == "Business" && subcategory == "Formal" -> btnBlouseWomenBusinessFormal
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.blousebtnhighlight)
            }
            "Skirt" -> {
                selectedTypeButton = when {
                    gender == "Women" && event == "Business" && subcategory == "Casual" -> btnSkirtWomenBusinessCasual
                    gender == "Women" && event == "Business" && subcategory == "Formal" -> btnSkirtWomenBusinessFormal
                    gender == "Women" && event == "Business" && subcategory == "Travel" -> btnSkirtWomenBusinessTravel
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.skirtbtnhighlight)
            }
            "Pants" -> {
                selectedTypeButton = if (gender == "Men") {
                    if (event == "Business" && subcategory == "Travel") {
                        btnPantsMenBusinessTravel
                    } else {
                        btnPantsWomenBusinessTravel
                    }
                } else {
                    if (event == "Business" && subcategory == "Travel") {
                        btnPantsWomenBusinessTravel
                    } else {
                        btnPantsMenBusinessTravel
                    }
                }
                selectedTypeButton?.setBackgroundResource(R.drawable.pantsbtnhighlight)
            }
            "Coats" -> {
                selectedTypeButton = btnCoatsMenBusinessFormal
                selectedTypeButton?.setBackgroundResource(R.drawable.coatsbtnhighlight)
            }
            "Jacket" -> {
                selectedTypeButton = btnJacketWomenBusinessFormal
                selectedTypeButton?.setBackgroundResource(R.drawable.jacketsbtnhighlight)
            }
            "Suit" -> {
                selectedTypeButton = btnSuitMenBusinessTravel
                selectedTypeButton?.setBackgroundResource(R.drawable.suitbtnhighlight)
            }
            "Dress" -> {
                selectedTypeButton = btnDressWomenBusinessTravel
                selectedTypeButton?.setBackgroundResource(R.drawable.dressbtnhighlight)
            }
            "Longsleeve" -> {
                selectedTypeButton = btnLongsleeveMenBusinessTravel
                selectedTypeButton?.setBackgroundResource(R.drawable.longsleevebtnhighlight)
            }
            else -> {
                // Handle the case if the selectedType doesn't match any condition
            }
        }
        updateNextButtonAppearance()
    }

    private fun updateNextButtonAppearance() {
        if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized && ::selectedType.isInitialized) {
            btnNext3.setBackgroundResource(R.drawable.continuebtnhighlight)
        } else {
            btnNext3.setBackgroundResource(R.drawable.continuebtn)
        }
    }

    private fun clearButtonSelectionType() {
        btnJacketsMenAdventureActive.setBackgroundResource(R.drawable.jacketsbtn)
        btnJoggersMenAdventureActive.setBackgroundResource(R.drawable.joggersbtn)
        btnShortsMenAdventureActive.setBackgroundResource(R.drawable.shortsbtn)
        btnTshirtMenAdventureActive.setBackgroundResource(R.drawable.tshirtbtn)
        btnTanktopsMenAdventureActive.setBackgroundResource(R.drawable.tanktopsbtn)

        btnJacketWomenAdventureActive.setBackgroundResource(R.drawable.jacketsbtn)
        btnJoggerWomenAdventureActive.setBackgroundResource(R.drawable.joggersbtn)
        btnShortsWomenAdventureActive.setBackgroundResource(R.drawable.shortsbtn)
        btnTshirtWomenAdventureActive.setBackgroundResource(R.drawable.tshirtbtn)
        btnTanktopsWomenAdventureActive.setBackgroundResource(R.drawable.tanktopsbtn)

        btnJacketsMenAdventureUrban.setBackgroundResource(R.drawable.jacketsbtn)
        btnJoggersMenAdventureUrban.setBackgroundResource(R.drawable.joggersbtn)
        btnShortsMenAdventureUrban.setBackgroundResource(R.drawable.shortsbtn)
        btnTshirtMenAdventureUrban.setBackgroundResource(R.drawable.tshirtbtn)
        btnTanktopsMenAdventureUrban.setBackgroundResource(R.drawable.tanktopsbtn)

        btnJacketWomenAdventureUrban.setBackgroundResource(R.drawable.jacketsbtn)
        btnJoggerWomenAdventureUrban.setBackgroundResource(R.drawable.joggersbtn)
        btnShortsWomenAdventureUrban.setBackgroundResource(R.drawable.shortsbtn)
        btnTshirtWomenAdventureUrban.setBackgroundResource(R.drawable.tshirtbtn)
        btnTanktopsWomenAdventureUrban.setBackgroundResource(R.drawable.tanktopsbtn)

        btnBoardshortsMenAdventureWater.setBackgroundResource(R.drawable.boardshortsbtn)
        btnRashguardMenAdventureWater.setBackgroundResource(R.drawable.rashguardbtn)

        btnBikiniWomenAdventureWater.setBackgroundResource(R.drawable.bikinibtn)
        btnRashguardWomenAdventureWater.setBackgroundResource(R.drawable.rashguardbtn)


        btnChinosMenBusinessCasual.setBackgroundResource(R.drawable.chinosbtn)
        btnPoloMenBusinessCasual.setBackgroundResource(R.drawable.polobtn)
        btnTrousersMenBusinessCasual.setBackgroundResource(R.drawable.trouserbtn)

        btnBlouseWomenBusinessCasual.setBackgroundResource(R.drawable.blousebtn)
        btnSkirtWomenBusinessCasual.setBackgroundResource(R.drawable.skirtbtn)
        btnTrouserWomenBusinessCasual.setBackgroundResource(R.drawable.trouserbtn)

        btnChinosMenBusinessFormal.setBackgroundResource(R.drawable.chinosbtn)
        btnCoatsMenBusinessFormal.setBackgroundResource(R.drawable.coatsbtn)
        btnTrousersMenBusinessFormal.setBackgroundResource(R.drawable.trouserbtn)

        btnBlouseWomenBusinessFormal.setBackgroundResource(R.drawable.blousebtn)
        btnJacketWomenBusinessFormal.setBackgroundResource(R.drawable.jacketsbtn)
        btnSkirtWomenBusinessFormal.setBackgroundResource(R.drawable.skirtbtn)
        btnTrouserWomenBusinessFormal.setBackgroundResource(R.drawable.trouserbtn)

        btnLongsleeveMenBusinessTravel.setBackgroundResource(R.drawable.longsleevebtn)
        btnPantsMenBusinessTravel.setBackgroundResource(R.drawable.pantsbtn)
        btnPoloMenBusinessTravel.setBackgroundResource(R.drawable.polobtn)
        btnSuitMenBusinessTravel.setBackgroundResource(R.drawable.suitbtn)

        btnBlouseWomenBusinessTravel.setBackgroundResource(R.drawable.blousebtn)
        btnDressWomenBusinessTravel.setBackgroundResource(R.drawable.dressbtn)
        btnPantsWomenBusinessTravel.setBackgroundResource(R.drawable.pantsbtn)
        btnSkirtWomenBusinessTravel.setBackgroundResource(R.drawable.skirtbtn)
    }

    private fun showHideButtons(event: String?, gender: String?, subcategory: String?, type: String?) {
        val btnJacketsMenAdventureActive: Button = findViewById(R.id.btnJacketsActive)
        val btnJoggersMenAdventureActive: Button = findViewById(R.id.btnJoggersActive)
        val btnShortsMenAdventureActive: Button = findViewById(R.id.btnShortsActive)
        val btnTshirtMenAdventureActive: Button = findViewById(R.id.btnShirtActive)
        val btnTanktopsMenAdventureActive: Button = findViewById(R.id.btnTanktopActive)

        val btnJacketWomenAdventureActive: Button = findViewById(R.id.btnJacketsWomenActive)
        val btnJoggerWomenAdventureActive: Button = findViewById(R.id.btnJoggersWomenActive)
        val btnShortsWomenAdventureActive: Button = findViewById(R.id.btnShortsWomenActive)
        val btnTshirtWomenAdventureActive: Button = findViewById(R.id.btnShirtWomenActive)
        val btnTanktopsWomenAdventureActive: Button = findViewById(R.id.btnTanktopWomenActive)

        val btnJacketsMenAdventureUrban: Button = findViewById(R.id.btnJacketsUrban)
        val btnJoggersMenAdventureUrban: Button = findViewById(R.id.btnJoggersUrban)
        val btnShortsMenAdventureUrban: Button = findViewById(R.id.btnShortsUrban)
        val btnTshirtMenAdventureUrban: Button = findViewById(R.id.btnShirtUrban)
        val btnTanktopsMenAdventureUrban: Button = findViewById(R.id.btnTanktopUrban)

        val btnJacketWomenAdventureUrban: Button = findViewById(R.id.btnJacketsWomenUrban)
        val btnJoggerWomenAdventureUrban: Button = findViewById(R.id.btnJoggersWomenUrban)
        val btnShortsWomenAdventureUrban: Button = findViewById(R.id.btnShortsWomenUrban)
        val btnTshirtWomenAdventureUrban: Button = findViewById(R.id.btnShirtWomenUrban)
        val btnTanktopsWomenAdventureUrban: Button = findViewById(R.id.btnTanktopWomenUrban)

        val btnBoardShortsMenAdventureWater: Button = findViewById(R.id.btnBoardShorts)
        val btnRashguardMenAdventureWater: Button = findViewById(R.id.btnRashguard)

        val btnBikiniWomenAdventureWater: Button = findViewById(R.id.btnBikini)
        val btnRashguardWomenAdventureWater: Button = findViewById(R.id.btnRashguardWomen)

        val btnChinosMenBusinessCasual: Button = findViewById(R.id.btnChinos)
        val btnPoloMenBusinessCasual: Button = findViewById(R.id.btnPolo)
        val btnTrousersMenBusinessCasual: Button = findViewById(R.id.btnTrouserCasualMen)

        val btnBlouseWomenBusinessCasual: Button = findViewById(R.id.btnBlouse)
        val btnSkirtWomenBusinessCasual: Button = findViewById(R.id.btnSkirt)
        val btnTrouserWomenBusinessCasual: Button = findViewById(R.id.btnTrouserCasualWomen)

        val btnChinosMenBusinessFormal: Button = findViewById(R.id.btnChinosFormalMen)
        val btnCoatsMenBusinessFormal: Button = findViewById(R.id.btnCoats)
        val btnTrousersMenBusinessFormal: Button = findViewById(R.id.btnTrouserFormalMen)

        val btnBlouseWomenBusinessFormal: Button = findViewById(R.id.btnBlouseFormal)
        val btnJacketWomenBusinessFormal: Button = findViewById(R.id.btnJacketFormalWomen)
        val btnSkirtWomenBusinessFormal: Button = findViewById(R.id.btnSkirtFormal)
        val btnTrouserWomenBusinessFormal: Button = findViewById(R.id.btnTrouserFormalWomen)

        val btnLongsleeveMenBusinessTravel: Button = findViewById(R.id.btnLongsleeveTravelMen)
        val btnPantsMenBusinessTravel: Button = findViewById(R.id.btnPants)
        val btnPoloMenBusinessTravel: Button = findViewById(R.id.btnPoloTravelMen)
        val btnSuitMenBusinessTravel: Button = findViewById(R.id.btnSuitTravelMen)

        val btnBlouseWomenBusinessTravel: Button = findViewById(R.id.btnBlouseTravel)
        val btnDressWomenBusinessTravel: Button = findViewById(R.id.btnDress)
        val btnPantsWomenBusinessTravel: Button = findViewById(R.id.btnPantsTravelWomen)
        val btnSkirtWomenBusinessTravel: Button = findViewById(R.id.btnSkirtTravel)


        // Reset visibility for all buttons
        btnJacketsMenAdventureActive.visibility = View.GONE
        btnJoggersMenAdventureActive.visibility = View.GONE
        btnShortsMenAdventureActive.visibility = View.GONE
        btnTshirtMenAdventureActive.visibility = View.GONE
        btnTanktopsMenAdventureActive.visibility = View.GONE

        btnJacketWomenAdventureActive.visibility = View.GONE
        btnJoggerWomenAdventureActive.visibility = View.GONE
        btnShortsWomenAdventureActive.visibility = View.GONE
        btnTshirtWomenAdventureActive.visibility = View.GONE
        btnTanktopsWomenAdventureActive.visibility = View.GONE

        btnJacketsMenAdventureUrban.visibility = View.GONE
        btnJoggersMenAdventureUrban.visibility = View.GONE
        btnShortsMenAdventureUrban.visibility = View.GONE
        btnTshirtMenAdventureUrban.visibility = View.GONE
        btnTanktopsMenAdventureUrban.visibility = View.GONE

        btnJacketWomenAdventureUrban.visibility = View.GONE
        btnJoggerWomenAdventureUrban.visibility = View.GONE
        btnShortsWomenAdventureUrban.visibility = View.GONE
        btnTshirtWomenAdventureUrban.visibility = View.GONE
        btnTanktopsWomenAdventureUrban.visibility = View.GONE

        btnBoardShortsMenAdventureWater.visibility = View.GONE
        btnRashguardMenAdventureWater.visibility = View.GONE

        btnBikiniWomenAdventureWater.visibility = View.GONE
        btnRashguardWomenAdventureWater.visibility = View.GONE

        btnChinosMenBusinessCasual.visibility = View.GONE
        btnPoloMenBusinessCasual.visibility = View.GONE
        btnTrousersMenBusinessCasual.visibility = View.GONE

        btnBlouseWomenBusinessCasual.visibility = View.GONE
        btnSkirtWomenBusinessCasual.visibility = View.GONE
        btnTrouserWomenBusinessCasual.visibility = View.GONE

        btnChinosMenBusinessFormal.visibility = View.GONE
        btnCoatsMenBusinessFormal.visibility = View.GONE
        btnTrousersMenBusinessFormal.visibility = View.GONE

        btnBlouseWomenBusinessFormal.visibility = View.GONE
        btnJacketWomenBusinessFormal.visibility = View.GONE
        btnSkirtWomenBusinessFormal.visibility = View.GONE
        btnTrouserWomenBusinessFormal.visibility = View.GONE

        btnLongsleeveMenBusinessTravel.visibility = View.GONE
        btnPantsMenBusinessTravel.visibility = View.GONE
        btnPoloMenBusinessTravel.visibility = View.GONE
        btnSuitMenBusinessTravel.visibility = View.GONE

        btnBlouseWomenBusinessTravel.visibility = View.GONE
        btnDressWomenBusinessTravel.visibility = View.GONE
        btnPantsWomenBusinessTravel.visibility = View.GONE
        btnSkirtWomenBusinessTravel.visibility = View.GONE

        // Show buttons based on conditions
        if (event == "Adventure" && gender == "Men" && subcategory == "Active") {
            btnJacketsMenAdventureActive.visibility = View.VISIBLE
            btnJoggersMenAdventureActive.visibility = View.VISIBLE
            btnShortsMenAdventureActive.visibility = View.VISIBLE
            btnTanktopsMenAdventureActive.visibility = View.VISIBLE
            btnTshirtMenAdventureActive.visibility = View.VISIBLE
        } else if (event == "Adventure" && gender == "Women" && subcategory == "Active") {
            btnJacketWomenAdventureActive.visibility = View.VISIBLE
            btnJoggerWomenAdventureActive.visibility = View.VISIBLE
            btnShortsWomenAdventureActive.visibility = View.VISIBLE
            btnTanktopsWomenAdventureActive.visibility = View.VISIBLE
            btnTshirtWomenAdventureActive.visibility = View.VISIBLE
        } else if (event == "Adventure" && gender == "Men" && subcategory == "Urban") {
            btnJacketWomenAdventureUrban.visibility = View.VISIBLE
            btnJoggerWomenAdventureUrban.visibility = View.VISIBLE
            btnShortsWomenAdventureUrban.visibility = View.VISIBLE
            btnTanktopsWomenAdventureUrban.visibility = View.VISIBLE
            btnTshirtWomenAdventureUrban.visibility = View.VISIBLE
        } else if (event == "Adventure" && gender == "Women" && subcategory == "Urban") {
            btnJacketWomenAdventureUrban.visibility = View.VISIBLE
            btnJoggerWomenAdventureUrban.visibility = View.VISIBLE
            btnShortsWomenAdventureUrban.visibility = View.VISIBLE
            btnTanktopsWomenAdventureUrban.visibility = View.VISIBLE
            btnTshirtWomenAdventureUrban.visibility = View.VISIBLE
        } else if (event == "Adventure" && gender == "Men" && subcategory == "Water") {
            btnBoardShortsMenAdventureWater.visibility = View.VISIBLE
            btnRashguardMenAdventureWater.visibility = View.VISIBLE
        } else if (event == "Adventure" && gender == "Women" && subcategory == "Water") {
            btnBikiniWomenAdventureWater.visibility = View.VISIBLE
            btnRashguardWomenAdventureWater.visibility = View.VISIBLE
        } else if (event == "Business" && gender == "Men" && subcategory == "Casual") {
            btnChinosMenBusinessCasual.visibility = View.VISIBLE
            btnPoloMenBusinessCasual.visibility = View.VISIBLE
            btnTrousersMenBusinessCasual.visibility = View.VISIBLE
        } else if (event == "Business" && gender == "Women" && subcategory == "Casual") {
            btnBlouseWomenBusinessCasual.visibility = View.VISIBLE
            btnSkirtWomenBusinessCasual.visibility = View.VISIBLE
            btnTrouserWomenBusinessCasual.visibility = View.VISIBLE
        } else if (event == "Business" && gender == "Men" && subcategory == "Formal") {
            btnChinosMenBusinessFormal.visibility = View.VISIBLE
            btnCoatsMenBusinessFormal.visibility = View.VISIBLE
            btnTrousersMenBusinessFormal.visibility = View.VISIBLE
        } else if (event == "Business" && gender == "Women" && subcategory == "Formal") {
            btnBlouseWomenBusinessFormal.visibility = View.VISIBLE
            btnJacketWomenBusinessFormal.visibility = View.VISIBLE
            btnSkirtWomenBusinessFormal.visibility = View.VISIBLE
            btnTrouserWomenBusinessFormal.visibility = View.VISIBLE
        } else if (event == "Business" && gender == "Men" && subcategory == "Travel") {
            btnLongsleeveMenBusinessTravel.visibility = View.VISIBLE
            btnPantsMenBusinessTravel.visibility = View.VISIBLE
            btnPoloMenBusinessTravel.visibility = View.VISIBLE
            btnSuitMenBusinessTravel.visibility = View.VISIBLE
        } else if (event == "Business" && gender == "Women" && subcategory == "Travel") {
            btnBlouseWomenBusinessTravel.visibility = View.VISIBLE
            btnDressWomenBusinessTravel.visibility = View.VISIBLE
            btnPantsWomenBusinessTravel.visibility = View.VISIBLE
            btnSkirtWomenBusinessTravel.visibility = View.VISIBLE
        }

        // Save the event and gender values
        selectedCategory = event ?: ""
        selectedGender = gender ?: ""
        selectedSubCategory = subcategory ?: ""
        selectedType = type ?: ""
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun String.showToast() {
        Toast.makeText(this@ChooseType, this, Toast.LENGTH_SHORT).show()
    }
}