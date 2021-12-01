package sa.edu.tuwaiq.fockos.until

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
//@Abdullah Alfaraj, Abdulaziz Alrajeh

class DateUtil {


    @RequiresApi(Build.VERSION_CODES.O)
    fun convertTimeStampYYMMDD(time: String): String? {
        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd")

        return simpleDateFormat.format(time.toLong()).toString()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun convertTimeStampEEEMMYYYY(time: String): String? {
        val simpleDateFormat = SimpleDateFormat("EEE,dd,yyyy")
        return simpleDateFormat.format(time.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertDataUsing_YY_MM_dd_(time: String): String {
        return time.replace('-', '/')
//        val current = LocalDateTime.now()
//        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
//        return current.format(formatter)
    }


}