package sa.edu.tuwaiq.fockos.until

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
//@Abdullah Alfaraj

class DateUtil {

    /**
     * This class is Data until  which was created for unit testing. This class contains three
     * functions: convertTimeStampYYMMDD, convertTimeStampEEEMMYYYY, and convertDataUsing_YY_MM_dd_
     *
     */
    @RequiresApi(Build.VERSION_CODES.O)
            /**
             * The function below is to convert time in Milliseconds to yyyy/MM/dd format
             */
    fun convertTimeStampYYMMDD(time: String): String? {
        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd")

        return simpleDateFormat.format(time.toLong()).toString()
    }
    /**
     * The function below is to convert time in Milliseconds to EEEMMYYYY format
     */
    @RequiresApi(Build.VERSION_CODES.N)
    fun convertTimeStampEEEMMYYYY(time: String): String? {
        val simpleDateFormat = SimpleDateFormat("EEE,dd,yyyy")
        return simpleDateFormat.format(time.toLong())
    }
    /**
     * The function below is to convert time in YY-MM-dd to yyyy/MM/dd format
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun convertDataUsing_YY_MM_dd_(time: String): String {
        return time.replace('-', '/')

    }


}