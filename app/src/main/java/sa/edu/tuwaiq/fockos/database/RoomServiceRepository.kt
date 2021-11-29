package sa.edu.tuwaiq.fockos.database

import android.content.Context
import androidx.room.Room
import sa.edu.tuwaiq.fockos.model.Photo

private const val TAG = "RoomServiceRepository"
private const val DATABASE_NAME = "Images-database"
class RoomServiceRepository(context: Context) {

    private val database = Room.databaseBuilder(
        context,
        ImageDatabase::class.java,
        DATABASE_NAME
    ).fallbackToDestructiveMigration().build()

    private val ImageDao = database.imageDao()
    suspend fun insertImages(photos: List<Photo>) =
        ImageDao.insertImages(photos)

    suspend fun getImages() = ImageDao.getImages()

    suspend fun getFavorite() = ImageDao.getFavoriteImages()

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