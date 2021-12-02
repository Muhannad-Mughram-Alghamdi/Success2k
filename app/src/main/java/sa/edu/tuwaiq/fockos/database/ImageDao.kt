package sa.edu.tuwaiq.fockos.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sa.edu.tuwaiq.fockos.model.Photo

//@Abdullah Alfaraj, Abdulaziz Alrajeh

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<Photo>)

    @Query("SELECT * FROM photo ")
    suspend fun getImages(): List<Photo>


    @Query("SELECT * FROM Photo WHERE isFavorite")
    suspend fun getFavoriteImages(): List<Photo>



}