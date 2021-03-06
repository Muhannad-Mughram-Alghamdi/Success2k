package sa.edu.tuwaiq.fockos.View
//@Abdullah Alfaraj, Abdulaziz Alrajeh

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sa.edu.tuwaiq.fockos.database.RoomServiceRepository

import sa.edu.tuwaiq.fockos.model.Photo
import sa.edu.tuwaiq.fockos.repostries.RepositoryServiceAPI
import java.lang.Exception

/**
 * This class is the main viewModel class which contains the call function
 */
private const val TAG = "MainViewModel"

class MainViewModel() :ViewModel() {

    private val RepositoryApi = RepositoryServiceAPI.get()
    private val RoomdatabaseRep = RoomServiceRepository.get()
    val imagesLiveData = MutableLiveData<List<Photo>>()
    val imagesErrorLiveData = MutableLiveData<String?>()

    /**
     * The call function  job is to post the response  in the liveData as well as the
     * roomData. The reason for posting the values in the Room Data base(local database) is to make
     * sure that the user could get back to the last images he or she was viewing in case of
     * internet disconnection .
     */

    fun call(lat:Double, lon:Double){
    viewModelScope.launch(Dispatchers.IO) {

        try{
            val response = RepositoryApi.getImages(lat,lon)
            if(response.isSuccessful){

                response.body()?.run {
                    Log.d(TAG,this.toString())
                    imagesLiveData.postValue(this.photos.photo)
                    RoomdatabaseRep.insertImages(this.photos.photo)

                }
            }else{
                imagesErrorLiveData.postValue(response.message())
                imagesLiveData.postValue(RoomdatabaseRep.getImages())
            }
        }catch (e:Exception){
            Log.d(TAG,e.message.toString())
            imagesErrorLiveData.postValue(e.message.toString())
            Log.d(TAG,"myRoom")
            imagesLiveData.postValue(RoomdatabaseRep.getImages())


        }


    }
    }





}
