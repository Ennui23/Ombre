package software_engineering

import android.app.Application
import com.google.firebase.FirebaseApp
import software_engineering.project.ombre.GlideApp

class OmbreApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize Glide with Firebase
        FirebaseApp.initializeApp(this)
        GlideApp.with(this)
    }
}