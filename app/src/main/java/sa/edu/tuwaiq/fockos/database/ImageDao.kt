package sa.edu.tuwaiq.fockos.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sa.edu.tuwaiq.fockos.model.Photo

//@Abdullah Alfaraj, Abdulaziz Alrajeh
/**
 * This the Dao class where we added the functions or operations we want to perform in our dataBase
 */
@Dao
interface ImageDao {
    /**
     * The function below is to insert Images in the dataBase
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<Photo>)

    /**
     * here below a function that gets the images from the dataBase
     */
    @Query("SELECT * FROM photo ")
    suspend fun getImages(): List<Photo>





}