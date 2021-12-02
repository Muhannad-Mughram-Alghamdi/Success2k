package sa.edu.tuwaiq.fockos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.tuwaiq.fockos.model.Photo

//@Abdullah Alfaraj, Abdulaziz Alrajeh
/**
 * Here is the database class where we pass it the entity as well as created as suspend function
 * for the Dao to connect it to the DataBase
 */


@Database(entities = [Photo::class],version = 2)

abstract class ImageDatabase:RoomDatabase() {

    abstract fun imageDao():ImageDao

}