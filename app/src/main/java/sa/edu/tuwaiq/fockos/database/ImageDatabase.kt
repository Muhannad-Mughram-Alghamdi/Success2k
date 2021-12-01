package sa.edu.tuwaiq.fockos.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sa.edu.tuwaiq.fockos.model.Photo

//@Abdullah Alfaraj, Abdulaziz Alrajeh

@Database(entities = [Photo::class],version = 2)

abstract class ImageDatabase:RoomDatabase() {
    abstract fun imageDao():ImageDao

}