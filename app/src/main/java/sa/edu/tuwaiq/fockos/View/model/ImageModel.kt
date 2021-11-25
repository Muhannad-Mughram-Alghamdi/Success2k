package sa.edu.tuwaiq.fockos.View.model


import com.google.gson.annotations.SerializedName
//@Abdullah Alfaraj, Abdulaziz Alrajeh

data class ImageModel(
    @SerializedName("photos")
    val photos: Photos,
    @SerializedName("stat")
    val stat: String
)