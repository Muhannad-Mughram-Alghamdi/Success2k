package sa.edu.tuwaiq.fockos.repostries

import android.annotation.SuppressLint
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.tuwaiq.fockos.api.ImageAPI
import java.lang.Exception

//@Abdullah Alfaraj, Abdulaziz Alrajeh
/**
 * This class is the Api Repository class
 */


/*the val below is to hold the base Url*/
private val constanceBaseUrl = "https://api.flickr.com"


class RepositoryServiceAPI(val context: Context) {
    /**
     * here below we build our api database using the Retrofit
     */
    private val retrofitService = Retrofit.Builder()
        .baseUrl(constanceBaseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val retrofitApi = retrofitService.create(ImageAPI::class.java)

    /**
     * here below we created a function that passed lat for latitude and lon for longitude to
     * get the images based on the latitude and  longitude.
     */

    suspend fun getImages(lat:Double, lon:Double) = retrofitApi.fetchPhotos(lat,lon )

    /**
     * here below we created a  here below we created companion object to initialized our
     * Api Database  anywhere in the program.
     */


    companion object{
        @SuppressLint("StaticFieldLeak")
        private var instance:RepositoryServiceAPI?=null

        fun init(context: Context){
            if(instance==null){
                instance = RepositoryServiceAPI(context)
            }
        }
        fun get():RepositoryServiceAPI{
            return instance?:throw Exception("Api must be initialized")

        }
    }

}