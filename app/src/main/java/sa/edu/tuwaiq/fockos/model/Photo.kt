package sa.edu.tuwaiq.fockos.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
//@Abdullah Alfaraj, Abdulaziz Alrajeh
/**
 * This a data class where we created our entity for the database
 */
@Entity
data class Photo(
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("height_s")
    val heightS: Int,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("isfamily")
    val isfamily: Int,
    @SerializedName("isfriend")
    val isfriend: Int,
    @SerializedName("ispublic")
    val ispublic: Int,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url_s")
    val urlS: String,
    @SerializedName("width_s")
    val widthS: Int,

    val isFavorite:Boolean = false

)