package sa.edu.tuwaiq.fockos.database
//@Abdullah Alfaraj, Abdulaziz Alrajeh
/**
 * This is our API database
 */
import android.content.Context
import androidx.room.Room
import sa.edu.tuwaiq.fockos.model.Photo
/*here we below used TAG for debugging in conceal */
private const val TAG = "RoomServiceRepository"
/*below we created a val to hold the name of the data base*/
private const val DATABASE_NAME = "Images_database"
class RoomServiceRepository(context: Context) {

    /**
     * here below we build our room database
     */
    private val database = Room.databaseBuilder(
        context,
        ImageDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    /*Here below we created a val named imageDao and passed it our database*/
    private val imageDao = database.imageDao()
    /**
     * here below we created a function to get the function we created in the Dao to Insert the
     * images
     */
    suspend fun insertImages(photos: List<Photo>) =
        imageDao.insertImages(photos)

    /**
    here below we created a function to get the function we created in the Dao to get the images
     */
    suspend fun getImages() = imageDao.getImages()

    /**
     * here below we created companion object to initialized our Room data base anywhere in the
     * program.
     */
    companion object {
        private var instance: RoomServiceRepository? = null

        fun init(context: Context) {
            if (instance == null)
                instance = RoomServiceRepository(context)
        }

        fun get(): RoomServiceRepository {
            return instance ?: throw Exception("Room Service Repository must be initialized")
        }
    }


}