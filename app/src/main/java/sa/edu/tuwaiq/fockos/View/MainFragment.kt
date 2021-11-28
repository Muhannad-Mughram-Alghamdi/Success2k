package sa.edu.tuwaiq.fockos.View

import android.Manifest
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
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import sa.edu.tuwaiq.fockos.R
import sa.edu.tuwaiq.fockos.databinding.FragmentMainBinding
import sa.edu.tuwaiq.fockos.model.Photo
import sa.edu.tuwaiq.fockos.R

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
        Log.d(TAG, binding.root.toString())


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ImageAdapter = ImageRecyclerViewAdapter(ImageViewModel,requireContext())
        binding.MainViewRecyclerView.adapter = ImageAdapter
        getCurrentLocation()
        observers()
        Log.d(TAG, observers().toString())

    }
https://github.com/Muhannad-Mughram-Alghamdi/Success2k/pulls
    fun observers () {
        ImageViewModel.imagesLiveData.observe(viewLifecycleOwner, {
            ImageAdapter.submitList(this.images)
            Log.d(TAG, ImageAdapter.submitList(this.images).toString())
            images = it
            Log.d(TAG, it.toString())



        })
    }
    private fun getCurrentLocation() {
        Log.d("value current lan","${latitude}")
        Log.d("result current lon","${longitude}")
        // checking location permission
        if (ActivityCompat.checkSelfPermission(requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // request permission
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQ_CODE)
        }
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
    }
}