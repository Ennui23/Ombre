package software_engineering.dataclass

data class Recommendation(
    val event: String,
    val gender: String,
    val subcategory: String,
    val type: String,
    val color: String,
    val pattern: String,
    val imageUrl: String
)
