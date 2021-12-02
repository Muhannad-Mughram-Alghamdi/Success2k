package sa.edu.tuwaiq.fockos.View.model


import com.google.gson.annotations.SerializedName
import sa.edu.tuwaiq.fockos.model.Photo

//@Abdullah Alfaraj, Abdulaziz Alrajeh

data class Photos(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("perpage")
    val perpage: Int,
    @SerializedName("photo")
    val photo: List<Photo>,
    @SerializedName("total")
    val total: Int
)