package sa.edu.tuwaiq.fockos.database
//@Abdullah Alfaraj, Abdulaziz Alrajeh

import android.content.Context
import androidx.room.Room
import sa.edu.tuwaiq.fockos.model.Photo

private const val TAG = "RoomServiceRepository"
private const val DATABASE_NAME = "Images_database"
class RoomServiceRepository(context: Context) {

    private val database = Room.databaseBuilder(
        context,
        ImageDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    private val imageDao = database.imageDao()
    suspend fun insertImages(photos: List<Photo>) =
        imageDao.insertImages(photos)

    suspend fun getImages() = imageDao.getImages()

    suspend fun getFavorite() = imageDao.getFavoriteImages()

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