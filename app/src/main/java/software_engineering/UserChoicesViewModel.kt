package software_engineering

import androidx.lifecycle.ViewModel
import software_engineering.dataclass.UserChoices

class UserChoicesViewModel : ViewModel() {
    var userChoices: UserChoices = UserChoices("", "", "", "", "", "")

    fun updateUserChoices(event: String, gender: String, subcategory: String, type: String, color: String, pattern: String) {
        userChoices = UserChoices(event, gender, subcategory, type, color, pattern)
    }
}