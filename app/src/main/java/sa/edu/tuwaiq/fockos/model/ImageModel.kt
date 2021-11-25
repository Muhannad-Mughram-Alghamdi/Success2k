package sa.edu.tuwaiq.fockos.model


import com.google.gson.annotations.SerializedName
//@Abdullah Alfaraj, Abdulaziz Alrajeh

data class ImageModel(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)