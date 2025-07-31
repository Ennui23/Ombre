@file:Suppress("DEPRECATION", "DEPRECATION")

package software_engineering

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import software_engineering.project.ombre.Event
import software_engineering.project.ombre.R
import software_engineering.project.ombre.Recommendations

class ChoosePattern: AppCompatActivity() {
    private lateinit var selectedCategory: String
    private lateinit var selectedGender: String
    private lateinit var selectedSubCategory: String
    private lateinit var selectedType: String
    private lateinit var selectedColor: String
    private lateinit var selectedPattern: String
    private lateinit var btnGetRecommendation: Button

    private lateinit var btnBtnSolidStripedCamouflage: Button
    private lateinit var btnBtnStripedCamouflageSolid: Button
    private lateinit var btnBtnCamouflageSolidStriped: Button

    private lateinit var btnBtnGeometricSolidTropical: Button
    private lateinit var btnBtnSolidGeometricTropical: Button
    private lateinit var btnBtnTropicalSolidGeometric: Button

    private lateinit var btnBtnGeometricSolidFloral: Button
    private lateinit var btnBtnSolidGeometricFloral: Button
    private lateinit var btnBtnFloralSolidGeometric: Button

    private lateinit var btnBtnSolidCamouflage: Button
    private lateinit var btnBtnCamouflageSolid: Button

    private lateinit var btnBtnStripedCamouflage: Button
    private lateinit var btnBtnCamouflageStriped: Button

    private lateinit var btnBtnSolidStriped: Button
    private lateinit var btnBtnStripedSolid: Button

    private lateinit var btnBtnSolidTropical: Button
    private lateinit var btnBtnTropicalSolid: Button

    private lateinit var btnBtnSolidFloral: Button
    private lateinit var btnBtnFloralSolid: Button

    private lateinit var btnBtnSolid: Button

    private lateinit var btnBtnStriped: Button

    private lateinit var btnBtnCamouflage: Button

    private var selectedPatternButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_p)

        val event = intent.getStringExtra("event")
        val gender = intent.getStringExtra("gender")
        val subcategory = intent.getStringExtra("subcategory")
        val type = intent.getStringExtra("type")
        val color = intent.getStringExtra("color")
        val pattern = intent.getStringExtra("pattern")

        showHideButtons(event, gender, subcategory, type, color, pattern)

        btnGetRecommendation = findViewById(R.id.btnGetRecommendation)

        btnBtnSolidStripedCamouflage = findViewById(R.id.BtnSolidStripedCamouflage)
        btnBtnStripedCamouflageSolid = findViewById(R.id.BtnStripedCamouflageSolid)
        btnBtnCamouflageSolidStriped = findViewById(R.id.BtnCamouflageSolidStriped)

        btnBtnGeometricSolidTropical = findViewById(R.id.BtnGeometricSolidTropical)
        btnBtnSolidGeometricTropical = findViewById(R.id.BtnSolidGeometricTropical)
        btnBtnTropicalSolidGeometric = findViewById(R.id.BtnTropicalSolidGeometric)

        btnBtnGeometricSolidFloral = findViewById(R.id.BtnGeometricSolidFloral)
        btnBtnSolidGeometricFloral = findViewById(R.id.BtnSolidGeometricFloral)
        btnBtnFloralSolidGeometric = findViewById(R.id.BtnFloralSolidGeometric)

        btnBtnSolidCamouflage = findViewById(R.id.BtnSolidCamouflage)
        btnBtnCamouflageSolid = findViewById(R.id.BtnCamouflageSolid)

        btnBtnStripedCamouflage = findViewById(R.id.BtnStripedCamouflage)
        btnBtnCamouflageStriped = findViewById(R.id.BtnCamouflageStriped)

        btnBtnSolidStriped = findViewById(R.id.BtnSolidStriped)
        btnBtnStripedSolid = findViewById(R.id.BtnStripedSolid)

        btnBtnSolidTropical = findViewById(R.id.BtnSolidTropical)
        btnBtnTropicalSolid = findViewById(R.id.BtnTropicalSolid)

        btnBtnSolidFloral = findViewById(R.id.BtnSolidFloral)
        btnBtnFloralSolid = findViewById(R.id.BtnFloralSolid)

        btnBtnSolid = findViewById(R.id.BtnSolid)
        btnBtnStriped = findViewById(R.id.BtnStriped)
        btnBtnCamouflage = findViewById(R.id.BtnCamouflage)


        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Green", "Solid")
        }

        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Green", "Striped")
        }

        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Jackets", "Green", "Camouflage")
        }

        btnBtnStriped.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Black", "Striped")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Brown", "Solid")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Gray", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Joggers", "Gray", "Camouflage")
        }

        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Brown", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Gray", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Green", "Solid")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Shorts", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Black", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tanktops", "Green", "Camouflage")
        }

        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Brown", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Gray", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Green", "Solid")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Active", "Tshirt", "Green", "Camouflage")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Jackets", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Brown", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Brown", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Black", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Joggers", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Gray", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Black", "Striped")
        }
        btnBtnStripedCamouflage.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Brown", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Black", "Camouflage")
        }
        btnBtnCamouflageStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Shorts", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Black", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tanktops", "Green", "Camouflage")
        }

        btnBtnCamouflage.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tshirt", "Black", "Camouflage")
        }
        btnBtnCamouflage.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tshirt", "Brown", "Camouflage")
        }
        btnBtnCamouflage.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Active", "Tshirt", "Gray", "Camouflage")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Active", "Tshirt", "Green", "Solid")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Jackets", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Joggers", "Green", "Camouflage")
        }

        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Brown", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Gray", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Green", "Solid")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Shorts", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Brown", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Gray", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Gray", "Striped")
        }
        btnBtnStriped.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Tanktops", "Black", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Black", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Men", "Urban", "Tshirt", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Black", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Black", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Jackets", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Black", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Joggers", "Green", "Camouflage")
        }

        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Gray", "Solid")
        }
        btnBtnSolidCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Gray", "Striped")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Black", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolid.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Shorts", "Green", "Camouflage")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Brown", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Green", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Black", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tanktops", "Green", "Camouflage")
        }

        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Black", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Gray", "Solid")
        }
        btnBtnSolidStripedCamouflage.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Green", "Solid")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Black", "Striped")
        }
        btnBtnStripedCamouflage.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Brown", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Gray", "Striped")
        }
        btnBtnStripedCamouflageSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Green", "Striped")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Black", "Camouflage")
        }
        btnBtnCamouflageStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Brown", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Gray", "Camouflage")
        }
        btnBtnCamouflageSolidStriped.setOnClickListener {
            selectedPattern = "Camouflage"
            updatePatternSelection("Adventure", "Women", "Urban", "Tshirt", "Green", "Camouflage")
        }

        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Black", "Solid")
        }
        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Blue", "Solid")
        }
        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Green", "Solid")
        }
        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Orange", "Solid")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Black", "Tropical")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Blue", "Tropical")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Green", "Tropical")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Orange", "Tropical")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Black", "Geometric")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Blue", "Geometric")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Green", "Geometric")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Boardshorts", "Orange", "Geometric")
        }

        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Black", "Solid")
        }
        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Blue", "Solid")
        }
        btnBtnSolidTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Green", "Solid")
        }
        btnBtnSolidGeometricTropical.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Orange", "Solid")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Black", "Tropical")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Blue", "Tropical")
        }
        btnBtnTropicalSolid.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Green", "Tropical")
        }
        btnBtnTropicalSolidGeometric.setOnClickListener {
            selectedPattern = "Tropical"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Orange", "Tropical")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Black", "Geometric")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Blue", "Geometric")
        }
        btnBtnGeometricSolidTropical.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Men", "Water", "Rashguard", "Orange", "Geometric")
        }

        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Black", "Solid")
        }
        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Blue", "Solid")
        }
        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Green", "Solid")
        }
        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Orange", "Solid")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Black", "Floral")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Blue", "Floral")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Green", "Floral")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Orange", "Floral")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Black", "Geometric")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Blue", "Geometric")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Green", "Geometric")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Bikini", "Orange", "Geometric")
        }

        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Black", "Solid")
        }
        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Blue", "Solid")
        }
        btnBtnSolidFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Green", "Solid")
        }
        btnBtnSolidGeometricFloral.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Orange", "Solid")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Black", "Floral")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Blue", "Floral")
        }
        btnBtnFloralSolid.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Green", "Floral")
        }
        btnBtnFloralSolidGeometric.setOnClickListener {
            selectedPattern = "Floral"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Orange", "Floral")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Black", "Geometric")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Blue", "Geometric")
        }
        btnBtnGeometricSolidFloral.setOnClickListener {
            selectedPattern = "Geometric"
            updatePatternSelection("Adventure", "Women", "Water", "Rashguard", "Orange", "Geometric")
        }

        btnBtnStriped.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Chinos", "Black", "Striped")
        }
        btnBtnStriped.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Chinos", "Gray", "Striped")
        }
        btnBtnStriped.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Chinos", "Navy", "Striped")
        }
        btnBtnStriped.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Chinos", "White", "Striped")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "Gray", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Polo", "Navy", "Striped")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "Navy", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "Gray", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "Navy", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Casual", "Trousers", "White", "Striped")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "Navy", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "Gray", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "Navy", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Casual", "Blouse", "White", "Striped")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Skirt", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Skirt", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Skirt", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Skirt", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Casual", "Skirt", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Casual", "Skirt", "Gray", "Striped")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Trouser", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Trouser", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Trouser", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Casual", "Trouser", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Chinos", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Chinos", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Chinos", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Chinos", "White", "Solid")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "Navy", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "Gray", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "Navy", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Men", "Formal", "Coats", "White", "Striped")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Trousers", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Trousers", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Trousers", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Formal", "Trousers", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Blouse", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Blouse", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Blouse", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Blouse", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Formal", "Blouse", "Navy", "Striped")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Jacket", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Jacket", "Gray", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Jacket", "Navy", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Formal", "Jacket", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Formal", "Jacket", "Gray", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Formal", "Jacket", "Navy", "Striped")
        }

        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Skirt", "Black", "Solid")
        }
        btnBtnSolidStriped.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Skirt", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Skirt", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Skirt", "White", "Solid")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Formal", "Skirt", "Black", "Striped")
        }
        btnBtnStripedSolid.setOnClickListener {
            selectedPattern = "Striped"
            updatePatternSelection("Business", "Women", "Formal", "Skirt", "Gray", "Striped")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Trouser", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Trouser", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Trouser", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Formal", "Trouser", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Longsleeve", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Longsleeve", "Lightblue", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Longsleeve", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Longsleeve", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Pants", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Pants", "Khaki", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Pants", "Lightblue", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Pants", "Taupe", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Polo", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Polo", "Lightblue", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Polo", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Polo", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Suit", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Suit", "Lightblue", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Men", "Travel", "Suit", "Navy", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Blouse", "Lightblue", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Blouse", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Blouse", "Pink", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Blouse", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Dress", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Dress", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Dress", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Dress", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Pants", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Pants", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Pants", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Pants", "White", "Solid")
        }

        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Skirt", "Black", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Skirt", "Gray", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Skirt", "Navy", "Solid")
        }
        btnBtnSolid.setOnClickListener {
            selectedPattern = "Solid"
            updatePatternSelection("Business", "Women", "Travel", "Skirt", "White", "Solid")
        }


        // Next button click
        btnGetRecommendation.setOnClickListener {
            val progressDialog = ProgressDialog(this)
            progressDialog.setMessage("Getting Recommendations...")
            progressDialog.setCancelable(false)
            progressDialog.show()

            if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized && ::selectedType.isInitialized && ::selectedColor.isInitialized && ::selectedPattern.isInitialized) {
                // Check if any of the selections is empty
                if (selectedCategory.isNotEmpty() && selectedGender.isNotEmpty() && selectedSubCategory.isNotEmpty() && selectedType.isNotEmpty() && selectedColor.isNotEmpty() && selectedPattern.isNotEmpty()) {
                    // Save user choices and navigate to the next screen
                    val intent = Intent(this, ResultsRecommendation::class.java)  // Change to the actual next activity
                    intent.putExtra("event", selectedCategory)
                    intent.putExtra("gender", selectedGender)
                    intent.putExtra("subcategory", selectedSubCategory)
                    intent.putExtra("type", selectedType)
                    intent.putExtra("color", selectedColor)
                    intent.putExtra("pattern", selectedPattern)
                    startActivity(intent)

                    progressDialog.dismiss()
                } else {
                    "Please select a pattern before proceeding".showToast()
                    progressDialog.dismiss()
                }
            } else {
                "Please select a pattern before proceeding".showToast()
                progressDialog.dismiss()
            }
        }

        btnGetRecommendation.setBackgroundResource(R.drawable.getrecommendationbtn)

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

    private fun updatePatternSelection(event: String?, gender: String?, subcategory: String?, type: String?, color: String?, selectedPattern: String?) {
        clearButtonSelectionPattern()
        when (selectedPattern) {
            "Solid" -> {
                selectedPatternButton = when {
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Green" -> btnBtnSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Black" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Gray" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Green" -> btnBtnSolidCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Black" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Green" -> btnBtnSolidCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Gray" -> btnBtnSolidCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Green" -> btnBtnSolidCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Green" -> btnBtnSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Black" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Gray" -> btnBtnSolidCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Green" -> btnBtnSolidCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Brown" -> btnBtnSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Gray" -> btnBtnSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Brown" -> btnBtnSolidCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Black" -> btnBtnSolidCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Green" -> btnBtnSolidCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Black" -> btnBtnSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Black" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Brown" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Gray" -> btnBtnSolidStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Green" -> btnBtnSolidStripedCamouflage

                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Boardshorts" && color == "Black" -> btnBtnSolidGeometricTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Boardshorts" && color == "Blue" -> btnBtnSolidGeometricTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Boardshorts" && color == "Green" -> btnBtnSolidGeometricTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Boardshorts" && color == "Orange" -> btnBtnSolidGeometricTropical

                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Black" -> btnBtnSolidGeometricTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Blue" -> btnBtnSolidGeometricTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Green" -> btnBtnSolidTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Orange" -> btnBtnSolidGeometricTropical

                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Bikini" && color == "Black" -> btnBtnSolidGeometricFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Bikini" && color == "Blue" -> btnBtnSolidGeometricFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Bikini" && color == "Green" -> btnBtnSolidGeometricFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Bikini" && color == "Orange" -> btnBtnSolidGeometricFloral

                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Black" -> btnBtnSolidGeometricFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Blue" -> btnBtnSolidGeometricFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Green" -> btnBtnSolidFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water"  && type == "Rashguard" && color == "Orange" -> btnBtnSolidGeometricFloral

                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "Black" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "Navy" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "White" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "Black" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "Navy" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "White" -> btnBtnSolidStriped

                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "Black" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "Navy" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "White" -> btnBtnSolidStriped

                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Skirt" && color == "Black" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Skirt" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Skirt" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Skirt" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Trouser" && color == "Black" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Trouser" && color == "Gray" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Trouser" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Trouser" && color == "White" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Chinos" && color == "Black" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Chinos" && color == "Gray" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Chinos" && color == "Navy" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Chinos" && color == "White" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "Black" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "Navy" -> btnBtnSolidStriped
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "White" -> btnBtnSolidStriped

                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Trousers" && color == "Black" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Trousers" && color == "Gray" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Trousers" && color == "Navy" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Trousers" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Blouse" && color == "Black" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Blouse" && color == "Gray" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Blouse" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Blouse" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Jacket" && color == "Black" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Jacket" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Jacket" && color == "Navy" -> btnBtnSolidStriped

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Skirt" && color == "Black" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Skirt" && color == "Gray" -> btnBtnSolidStriped
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Skirt" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Skirt" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Trouser" && color == "Black" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Trouser" && color == "Gray" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Trouser" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Trouser" && color == "White" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Longsleeve" && color == "Gray" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Longsleeve" && color == "Lightblue" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Longsleeve" && color == "Navy" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Longsleeve" && color == "White" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Gray" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Khaki" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Lightblue" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Taupe" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Polo" && color == "Gray" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Polo" && color == "Lightblue" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Polo" && color == "Navy" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Polo" && color == "White" -> btnBtnSolid

                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Suit" && color == "Gray" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Suit" && color == "Lightblue" -> btnBtnSolid
                    gender == "Men" && event == "Business" && subcategory == "Travel"  && type == "Suit" && color == "Navy" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Blouse" && color == "Lightblue" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Blouse" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Blouse" && color == "Pink" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Blouse" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Dress" && color == "Black" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Dress" && color == "Gray" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Dress" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Dress" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Black" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Gray" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Pants" && color == "White" -> btnBtnSolid

                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Skirt" && color == "Black" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Skirt" && color == "Gray" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Skirt" && color == "Navy" -> btnBtnSolid
                    gender == "Women" && event == "Business" && subcategory == "Travel"  && type == "Skirt" && color == "White" -> btnBtnSolid

                    else -> null // Handle cases where none of the conditions are met
                }
                selectedPatternButton?.setBackgroundResource(R.drawable.solidbtnhighlight)
            }
            "Striped" -> {
                selectedPatternButton = when {
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Black" -> btnBtnStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Green" -> btnBtnStripedSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Gray" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Brown" -> btnBtnStripedCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Green" -> btnBtnStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Gray" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Black" -> btnBtnStripedSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Brown" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Black" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Brown" -> btnBtnStripedCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Gray" -> btnBtnStripedCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Green" -> btnBtnStripedCamouflageSolid

                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Chinos" && color == "Black" -> btnBtnStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Chinos" && color == "Gray" -> btnBtnStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Chinos" && color == "Navy" -> btnBtnStriped
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Chinos" && color == "White" -> btnBtnStriped

                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "Black" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Polo" && color == "Navy" -> btnBtnStripedSolid

                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "Black" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "Navy" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Casual"  && type == "Trousers" && color == "White" -> btnBtnStripedSolid

                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "Black" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "Navy" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Blouse" && color == "White" -> btnBtnStripedSolid

                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Skirt" && color == "Black" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Casual"  && type == "Skirt" && color == "Gray" -> btnBtnStripedSolid

                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "Black" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "Navy" -> btnBtnStripedSolid
                    gender == "Men" && event == "Business" && subcategory == "Formal"  && type == "Coats" && color == "White" -> btnBtnStripedSolid

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Blouse" && color == "Navy" -> btnBtnStripedSolid

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Jacket" && color == "Black" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Jacket" && color == "Gray" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Jacket" && color == "Navy" -> btnBtnStripedSolid

                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Skirt" && color == "Black" -> btnBtnStripedSolid
                    gender == "Women" && event == "Business" && subcategory == "Formal"  && type == "Skirt" && color == "Gray" -> btnBtnStripedSolid
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedPatternButton?.setBackgroundResource(R.drawable.stripedbtnhighlight)
            }
            "Camouflage" -> {
                selectedPatternButton = when {
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Gray" -> btnBtnCamouflageSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Black" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Gray" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Green" -> btnBtnCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Black" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Green" -> btnBtnCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Jackets" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Joggers" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Brown" -> btnBtnCamouflageStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Gray" -> btnBtnCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Shorts" && color == "Green" -> btnBtnCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Black" -> btnBtnCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Brown" -> btnBtnCamouflage
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tshirt" && color == "Gray" -> btnBtnCamouflage

                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Active"  && type == "Tanktops" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Black" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Gray" -> btnBtnCamouflageSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Green" -> btnBtnCamouflageSolid

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Black" -> btnBtnCamouflageSolidStriped

                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Men" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Brown" -> btnBtnCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Jackets" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Joggers" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Black" -> btnBtnCamouflageSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Shorts" && color == "Green" -> btnBtnCamouflageSolid

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Brown" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tanktops" && color == "Green" -> btnBtnCamouflageSolidStriped

                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Black" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Brown" -> btnBtnCamouflageStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Gray" -> btnBtnCamouflageSolidStriped
                    gender == "Women" && event == "Adventure" && subcategory == "Urban"  && type == "Tshirt" && color == "Green" -> btnBtnCamouflageSolidStriped
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedPatternButton?.setBackgroundResource(R.drawable.camouflagebtnhighlight)
            }
            "Floral" -> {
                selectedPatternButton = when {
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Black"  -> btnBtnFloralSolidGeometric
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Blue"  -> btnBtnFloralSolidGeometric
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Green"  -> btnBtnFloralSolidGeometric
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Orange"  -> btnBtnFloralSolidGeometric

                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Black"  -> btnBtnFloralSolidGeometric
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Blue"  -> btnBtnFloralSolidGeometric
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Green"  -> btnBtnFloralSolid
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Orange"  -> btnBtnFloralSolidGeometric
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedPatternButton?.setBackgroundResource(R.drawable.floralbtnhighlight)
            }
            "Geometric" -> {
                selectedPatternButton = when {
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Black"  -> btnBtnGeometricSolidTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Blue"  -> btnBtnGeometricSolidTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Green"  -> btnBtnGeometricSolidTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Orange"  -> btnBtnGeometricSolidTropical

                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Black"  -> btnBtnGeometricSolidTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Blue"  -> btnBtnGeometricSolidTropical
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Orange"  -> btnBtnGeometricSolidTropical

                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Black"  -> btnBtnGeometricSolidFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Blue"  -> btnBtnGeometricSolidFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Green"  -> btnBtnGeometricSolidFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Bikini" && color == "Orange"  -> btnBtnGeometricSolidFloral

                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Black"  -> btnBtnGeometricSolidFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Blue"  -> btnBtnGeometricSolidFloral
                    gender == "Women" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Orange"  -> btnBtnGeometricSolidFloral
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedPatternButton?.setBackgroundResource(R.drawable.geometricbtnhighlight)
            }
            "Tropical" -> {
                selectedPatternButton = when {
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Black"  -> btnBtnTropicalSolidGeometric
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Blue"  -> btnBtnTropicalSolidGeometric
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Green"  -> btnBtnTropicalSolidGeometric
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Boardshorts" && color == "Orange"  -> btnBtnTropicalSolidGeometric

                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Black"  -> btnBtnTropicalSolidGeometric
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Blue"  -> btnBtnTropicalSolidGeometric
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Green"  -> btnBtnTropicalSolid
                    gender == "Men" && event == "Adventure" && subcategory == "Water" && type == "Rashguard" && color == "Orange"  -> btnBtnTropicalSolidGeometric
                    else -> null // Handle cases where none of the conditions are met
                }
                selectedPatternButton?.setBackgroundResource(R.drawable.tropicalbtnhighlight)
            }
            else -> {
                // Handle the case if the selectedType doesn't match any condition
            }
        }
        updateNextButtonAppearance()
    }

    private fun updateNextButtonAppearance() {
        if (::selectedCategory.isInitialized && ::selectedGender.isInitialized && ::selectedSubCategory.isInitialized && ::selectedType.isInitialized && ::selectedColor.isInitialized && ::selectedPattern.isInitialized) {
            btnGetRecommendation.setBackgroundResource(R.drawable.getrecommendationbtnhighlight)
        } else {
            btnGetRecommendation.setBackgroundResource(R.drawable.getrecommendationbtn)
        }
    }

    private fun clearButtonSelectionPattern() {
        btnBtnSolidStripedCamouflage.setBackgroundResource(R.drawable.solidbtn)
        btnBtnStripedCamouflageSolid.setBackgroundResource(R.drawable.stripedbtn)
        btnBtnCamouflageSolidStriped.setBackgroundResource(R.drawable.camouflagebtn)

        btnBtnGeometricSolidTropical.setBackgroundResource(R.drawable.geometricbtn)
        btnBtnSolidGeometricTropical.setBackgroundResource(R.drawable.solidbtn)
        btnBtnTropicalSolidGeometric.setBackgroundResource(R.drawable.tropicalbtn)

        btnBtnGeometricSolidFloral.setBackgroundResource(R.drawable.geometricbtn)
        btnBtnSolidGeometricFloral.setBackgroundResource(R.drawable.solidbtn)
        btnBtnFloralSolidGeometric.setBackgroundResource(R.drawable.floralbtn)

        btnBtnSolidCamouflage.setBackgroundResource(R.drawable.solidbtn)
        btnBtnCamouflageSolid.setBackgroundResource(R.drawable.camouflagebtn)

        btnBtnStripedCamouflage.setBackgroundResource(R.drawable.stripedbtn)
        btnBtnCamouflageStriped.setBackgroundResource(R.drawable.camouflagebtn)

        btnBtnSolidStriped.setBackgroundResource(R.drawable.solidbtn)
        btnBtnStripedSolid.setBackgroundResource(R.drawable.stripedbtn)

        btnBtnSolidTropical.setBackgroundResource(R.drawable.tropicalbtn)
        btnBtnTropicalSolid.setBackgroundResource(R.drawable.camouflagebtn)

        btnBtnSolidFloral.setBackgroundResource(R.drawable.solidbtn)
        btnBtnFloralSolid.setBackgroundResource(R.drawable.floralbtn)

        btnBtnSolid.setBackgroundResource(R.drawable.solidbtn)
        btnBtnStriped.setBackgroundResource(R.drawable.stripedbtn)
        btnBtnCamouflage.setBackgroundResource(R.drawable.camouflagebtn)
    }

    private fun showHideButtons(event: String?, gender: String?, subcategory: String?, type: String?, color: String?, pattern: String?) {

        val btnBtnSolidStripedCamouflage: Button = findViewById(R.id.BtnSolidStripedCamouflage)
        val btnBtnStripedCamouflageSolid: Button = findViewById(R.id.BtnStripedCamouflageSolid)
        val btnBtnCamouflageSolidStriped: Button = findViewById(R.id.BtnCamouflageSolidStriped)

        val btnBtnGeometricSolidTropical: Button = findViewById(R.id.BtnGeometricSolidTropical)
        val btnBtnSolidGeometricTropical: Button = findViewById(R.id.BtnSolidGeometricTropical)
        val btnBtnTropicalSolidGeometric: Button = findViewById(R.id.BtnTropicalSolidGeometric)

        val btnBtnGeometricSolidFloral: Button = findViewById(R.id.BtnGeometricSolidFloral)
        val btnBtnSolidGeometricFloral: Button = findViewById(R.id.BtnSolidGeometricFloral)
        val btnBtnFloralSolidGeometric: Button = findViewById(R.id.BtnFloralSolidGeometric)

        val btnBtnSolidCamouflage: Button = findViewById(R.id.BtnSolidCamouflage)
        val btnBtnCamouflageSolid: Button = findViewById(R.id.BtnCamouflageSolid)

        val btnBtnStripedCamouflage: Button = findViewById(R.id.BtnStripedCamouflage)
        val btnBtnCamouflageStriped: Button = findViewById(R.id.BtnCamouflageStriped)

        val btnBtnSolidStriped: Button = findViewById(R.id.BtnSolidStriped)
        val btnBtnStripedSolid: Button = findViewById(R.id.BtnStripedSolid)

        val btnBtnSolidTropical: Button = findViewById(R.id.BtnSolidTropical)
        val btnBtnTropicalSolid: Button = findViewById(R.id.BtnTropicalSolid)

        val btnBtnSolidFloral: Button = findViewById(R.id.BtnSolidFloral)
        val btnBtnFloralSolid: Button = findViewById(R.id.BtnFloralSolid)

        val btnBtnSolid: Button = findViewById(R.id.BtnSolid)
        val btnBtnStriped: Button = findViewById(R.id.BtnStriped)
        val btnBtnCamouflage: Button = findViewById(R.id.BtnCamouflage)

        // Reset visibility for all buttons

        btnBtnSolidStripedCamouflage.visibility = View.GONE
        btnBtnStripedCamouflageSolid.visibility = View.GONE
        btnBtnCamouflageSolidStriped.visibility = View.GONE

        btnBtnGeometricSolidTropical.visibility = View.GONE
        btnBtnSolidGeometricTropical.visibility = View.GONE
        btnBtnTropicalSolidGeometric.visibility = View.GONE

        btnBtnGeometricSolidFloral.visibility = View.GONE
        btnBtnSolidGeometricFloral.visibility = View.GONE
        btnBtnFloralSolidGeometric.visibility = View.GONE

        btnBtnSolidCamouflage.visibility = View.GONE
        btnBtnCamouflageSolid.visibility = View.GONE

        btnBtnSolidStriped.visibility = View.GONE
        btnBtnStripedSolid.visibility = View.GONE

        btnBtnSolidTropical.visibility = View.GONE
        btnBtnTropicalSolid.visibility = View.GONE

        btnBtnSolidFloral.visibility = View.GONE
        btnBtnFloralSolid.visibility = View.GONE

        btnBtnSolid.visibility = View.GONE
        btnBtnStriped.visibility = View.GONE
        btnBtnCamouflage.visibility = View.GONE

//         Show buttons based on conditions
        if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Jackets" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Jackets" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Jackets" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Jackets" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Joggers" && color == "Black") {
            btnBtnStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Joggers" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Joggers" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Joggers" && color == "Green") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Shorts" && color == "Black") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Shorts" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Shorts" && color == "Gray") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Shorts" && color == "Green") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tshirt" && color == "Black") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tshirt" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tshirt" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tshirt" && color == "Green") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tanktops" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tanktops" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tanktops" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Active" && type == "Tanktops" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Jackets" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Jackets" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Jackets" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Jackets" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Joggers" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Joggers" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Joggers" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Joggers" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Shorts" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Shorts" && color == "Brown") {
            btnBtnStripedCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Shorts" && color == "Gray") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Shorts" && color == "Green") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women"  && subcategory == "Active"&& type == "Tshirt" && color == "Black") {
            btnBtnCamouflage.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tshirt" && color == "Brown") {
            btnBtnCamouflage.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tshirt" && color == "Gray") {
            btnBtnCamouflage.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tshirt" && color == "Green") {
            btnBtnSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tanktops" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tanktops" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tanktops" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Active" && type == "Tanktops" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }


        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Jackets" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Jackets" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Jackets" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Jackets" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Joggers" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Joggers" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Joggers" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Joggers" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Shorts" && color == "Black") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Shorts" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Shorts" && color == "Gray") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Shorts" && color == "Green") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tshirt" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tshirt" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tshirt" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tshirt" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tanktops" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tanktops" && color == "Brown") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tanktops" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Urban" && type == "Tanktops" && color == "Green") {
            btnBtnStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Jackets" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Jackets" && color == "Brown") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Jackets" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Jackets" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Joggers" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Joggers" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Joggers" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Joggers" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Shorts" && color == "Black") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Shorts" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Shorts" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Shorts" && color == "Green") {
            btnBtnSolidCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageSolid.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women"  && subcategory == "Urban"&& type == "Tshirt" && color == "Black") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tshirt" && color == "Brown") {
            btnBtnStripedCamouflage.visibility = View.VISIBLE
            btnBtnCamouflageStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tshirt" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tshirt" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tanktops" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tanktops" && color == "Brown") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tanktops" && color == "Gray") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Urban" && type == "Tanktops" && color == "Green") {
            btnBtnSolidStripedCamouflage.visibility = View.VISIBLE
            btnBtnStripedCamouflageSolid.visibility = View.VISIBLE
            btnBtnCamouflageSolidStriped.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Boardshorts" && color == "Black") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Boardshorts" && color == "Blue") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Boardshorts" && color == "Green") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Boardshorts" && color == "Orange") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Rashguard" && color == "Black") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Rashguard" && color == "Blue") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Rashguard" && color == "Green") {
            btnBtnSolidTropical.visibility = View.VISIBLE
            btnBtnTropicalSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Men" && subcategory == "Water" && type == "Rashguard" && color == "Orange") {
            btnBtnGeometricSolidTropical.visibility = View.VISIBLE
            btnBtnSolidGeometricTropical.visibility = View.VISIBLE
            btnBtnTropicalSolidGeometric.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Bikini" && color == "Black") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Bikini" && color == "Blue") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Bikini" && color == "Green") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Bikini" && color == "Orange") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }

        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Rashguard" && color == "Black") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Rashguard" && color == "Blue") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Rashguard" && color == "Green") {
            btnBtnSolidFloral.visibility = View.VISIBLE
            btnBtnFloralSolid.visibility = View.VISIBLE
        }
        else if (event == "Adventure" && gender == "Women" && subcategory == "Water" && type == "Rashguard" && color == "Orange") {
            btnBtnGeometricSolidFloral.visibility = View.VISIBLE
            btnBtnSolidGeometricFloral.visibility = View.VISIBLE
            btnBtnFloralSolidGeometric.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Chinos" && color == "Black") {
            btnBtnStriped.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Chinos" && color == "Gray") {
            btnBtnStriped.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Chinos" && color == "Navy") {
            btnBtnStriped.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Chinos" && color == "White") {
            btnBtnStriped.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Polo" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Polo" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Polo" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Polo" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Trousers" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Trousers" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Trousers" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Casual" && type == "Trousers" && color == "White") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "White") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Blouse" && color == "White") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Skirt" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Skirt" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Skirt" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Skirt" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Trouser" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Trouser" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Trouser" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Casual" && type == "Trouser" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Chinos" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Chinos" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Chinos" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Chinos" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Coats" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Coats" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Coats" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Coats" && color == "White") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Trousers" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Trousers" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Trousers" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Formal" && type == "Trousers" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Blouse" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Blouse" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Blouse" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Blouse" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Jacket" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Jacket" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Jacket" && color == "Navy") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Skirt" && color == "Black") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Skirt" && color == "Gray") {
            btnBtnSolidStriped.visibility = View.VISIBLE
            btnBtnStripedSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Skirt" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Skirt" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Trouser" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women"&& subcategory == "Formal" && type == "Trouser" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Trouser" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Formal" && type == "Trouser" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }

        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Longsleeve" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else  if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Longsleeve" && color == "Lightblue") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Longsleeve" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Longsleeve" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Pants" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Pants" && color == "Khaki") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Pants" && color == "Lightblue") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Pants" && color == "Taupe") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Polo" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Polo" && color == "Lightblue") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Polo" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Polo" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Suit" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Suit" && color == "Lightblue") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Men" && subcategory == "Travel" && type == "Suit" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Blouse" && color == "Lightblue") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Blouse" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Blouse" && color == "Pink") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Blouse" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Dress" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Dress" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Dress" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Dress" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Pants" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Pants" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Pants" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Pants" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Skirt" && color == "Black") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Skirt" && color == "Gray") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Skirt" && color == "Navy") {
            btnBtnSolid.visibility = View.VISIBLE
        }
        else if (event == "Business" && gender == "Women" && subcategory == "Travel" && type == "Skirt" && color == "White") {
            btnBtnSolid.visibility = View.VISIBLE
        }

        selectedCategory = event ?: ""
        selectedGender = gender ?: ""
        selectedSubCategory = subcategory ?: ""
        selectedType = type ?: ""
        selectedColor = color ?: ""
        selectedPattern = pattern ?: ""
    }

    private fun startActivityWithAnimation(intent: Intent, enterAnim: Int, exitAnim: Int) {
        startActivity(intent)
        overridePendingTransition(enterAnim, exitAnim)
    }

    private fun String.showToast() {
        Toast.makeText(this@ChoosePattern, this, Toast.LENGTH_SHORT).show()
    }
}