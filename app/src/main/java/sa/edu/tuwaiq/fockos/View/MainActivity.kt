package sa.edu.tuwaiq.fockos.View

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import sa.edu.tuwaiq.fockos.R
import sa.edu.tuwaiq.fockos.database.RoomServiceRepository
import sa.edu.tuwaiq.fockos.repostries.RepositoryServiceAPI

val LOCATION_PERMISSION_REQ_CODE = 1000
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        locationPermission()

    }


    fun locationPermission(){

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE)
        }
    }


}