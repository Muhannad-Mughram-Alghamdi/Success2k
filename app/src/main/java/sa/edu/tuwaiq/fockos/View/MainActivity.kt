package sa.edu.tuwaiq.fockos.View

/**
 * This class is our mainActivity class which contains OnCreate function and
 * locationPermission function, locationPermission function
 */
import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import sa.edu.tuwaiq.fockos.R
import sa.edu.tuwaiq.fockos.database.RoomServiceRepository
import sa.edu.tuwaiq.fockos.repostries.RepositoryServiceAPI
/*The variable LOCATION_PERMISSION_REQ_CODE below is created as global to get request permission
* anywhere needed in the class
*  */
val LOCATION_PERMISSION_REQ_CODE = 1000
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * here below we Initialized the room Repository and the api Repository
         */

        setContentView(R.layout.activity_main)
        RepositoryServiceAPI.init(this)
        RoomServiceRepository.init(this)
        // locationPermission()

    }

    /**
     * the function below is to get the location permission
     */
    fun locationPermission(){

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE)
        }
    }


}