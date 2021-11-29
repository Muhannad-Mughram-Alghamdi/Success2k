package sa.edu.tuwaiq.fockos.View

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

private const val TAG = "MainViewModel"

class MainViewModel:ViewModel() {
    private val RepositoryApi = RepositoryServiceAPI.get()
    private val RoomdatabaseRep = RoomServiceRepository.get()
    val imagesLiveData = MutableLiveData<List<Photo>>()
    val imagesErrorLiveData = MutableLiveData<String?>()


    fun call(lat:Double, lon:Double){
    viewModelScope.launch(Dispatchers.IO) {

        try{
            val response = RepositoryApi.getImages(lat,lon)
            if(response.isSuccessful){

                response.body()?.run {
                    Log.d(TAG,this.toString())
                    imagesLiveData.postValue(this.photos.photo)
                    RoomdatabaseRep.insertImages(this.photos.photo)
                    RoomdatabaseRep.getFavorite()

                }
            }else{
                imagesErrorLiveData.postValue(response.message())
                imagesLiveData.postValue(RoomdatabaseRep.getImages())
            }
        }catch (e:Exception){
            Log.d(TAG,e.message.toString())
            imagesErrorLiveData.postValue(e.message.toString())
            imagesLiveData.postValue(RoomdatabaseRep.getImages())


        }


    }
    }





}
