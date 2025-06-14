package software_engineering.dataclass

import android.graphics.Bitmap

data class ResultData(
    val id: String? = null,
    val resultText: String,
    val imageUrl: String? = null,
    val resultImage: Bitmap? = null
)
