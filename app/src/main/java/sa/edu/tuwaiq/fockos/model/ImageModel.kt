package sa.edu.tuwaiq.fockos.model

/**
 * This is the Image Model or our data class
 */
import com.google.gson.annotations.SerializedName
//@Abdullah Alfaraj, Abdulaziz Alrajeh

data class ImageModel(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)