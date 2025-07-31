@file:Suppress("DEPRECATION")

package software_engineering.project.ombre

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import software_engineering.project.ombre.R.id
import com.google.firebase.FirebaseApp
import software_engineering.PickCategory

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_camera)

        FirebaseApp.initializeApp(this)

        bottomNavigationView = findViewById(id.bottomnavigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            // Start the default activity (ClassifyActivity in this case)
            startActivity(Intent(this, Classify::class.java))
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val currentItemId = bottomNavigationView.selectedItemId
        val selectedItem = item.itemId

        if (currentItemId == selectedItem) {
            // Handle the case where the user taps on the currently selected item
            // You can choose to do nothing or handle it differently
            return true
        }

        when (selectedItem) {
            id.action_home -> {
                startActivity(Intent(this, PickCategory::class.java))
                return true
            }
            id.action_event -> {
                startActivity(Intent(this, Event::class.java))
                return true
            }
            id.action_recommendation -> {
                startActivity(Intent(this, Recommendations::class.java))
                return true
            }
        }

        return false
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        if (supportFragmentManager.backStackEntryCount > 0) {
            // If there are fragments in the back stack, pop the fragment
            supportFragmentManager.popBackStack()
        } else {
            // If there are no fragments in the back stack, show the exit confirmation dialog
            doubleBackToExitPressedOnce = true
            showExitConfirmationDialog()
        }
    }

    private fun showExitConfirmationDialog() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit? Press again if you want.")
            .setPositiveButton("Yes") { _, _ ->
                // User confirmed to exit, close the app
                super.onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
                // User canceled exit, reset the flag
                doubleBackToExitPressedOnce = false
            }
            .setOnCancelListener {
                // Handle the case where the dialog is canceled, reset the flag
                doubleBackToExitPressedOnce = false
            }
            .show()
    }
}
