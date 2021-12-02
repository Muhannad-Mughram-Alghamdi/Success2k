package sa.edu.tuwaiq.fockos.View

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.activityViewModels
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import sa.edu.tuwaiq.fockos.databinding.FragmentMainBinding
import sa.edu.tuwaiq.fockos.model.Photo

/**
 * This the main fragment class which contains the following functions: onCreate,onCreateView,
 * observers,getCurrentLocation,onRequestPermissionsResult
 */
//@Abdullah Alfaraj, Abdulaziz Alrajeh

private const val TAG = "MainFragment"

private  var latitude: Double = 0.0
private  var longitude: Double =0.0
class MainFragment : Fragment() {
    private val ImageViewModel:MainViewModel by activityViewModels()

//@hassan
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var images = listOf<Photo>()

    private lateinit var ImageAdapter :ImageRecyclerViewAdapter

    private lateinit var binding:FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root

    }

    /**
     * The function below is to create the view where we connect recyclerView to the adapter ,
     * observe the data, and get current location
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ImageAdapter = ImageRecyclerViewAdapter(ImageViewModel,requireContext())
        binding.MainViewRecyclerView.adapter = ImageAdapter
        observers()

        getCurrentLocation()

    }

    /**
     * The function below is to observe the live data
     */
    fun observers () {
        ImageViewModel.imagesLiveData.observe(viewLifecycleOwner, {
            ImageAdapter.submitList(it)
           // images = it
            Log.d(TAG, it.toString())
        })
    }

    /**
     * the function below is to get the current location of the user
     */
    private fun getCurrentLocation() {
        Log.d("value current lan","${latitude}")
        Log.d("result current lon","${longitude}")
        // checking location permission
        if (ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                // getting the last known or current location
                latitude = location.latitude
                longitude = location.longitude
                ImageViewModel.call(latitude, longitude)
                Log.d("return for location lan","${location.latitude}")
                Log.d("result for location lon","${location.longitude}")

                Log.d("return for lan","${latitude}")
                Log.d("result for lon","${longitude}")

            }
                .addOnFailureListener {
                    Toast.makeText(requireContext(), "Failed on getting current location",
                        Toast.LENGTH_SHORT).show()
                }

        } else
        {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), LOCATION_PERMISSION_REQ_CODE)
        }

    }

    /**
     * the function below is to request permission
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d(TAG,"onRequestPermissionsResult")
        getCurrentLocation()
    }
}