package software_engineering.dataclass

data class DynamicContent(
    val event: String,
    val gender: String,
    val subcategory: List<String>,
    val types: List<String>,
    val colors: List<String>,
    val patterns: List<String>
)
