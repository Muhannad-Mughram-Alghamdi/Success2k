package sa.edu.tuwaiq.fockos.repostries

import android.annotation.SuppressLint
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.tuwaiq.fockos.api.ImageAPI
import java.lang.Exception

//@Abdullah Alfaraj, Abdulaziz Alrajeh

private val constanceBaseUrl = "https://api.flickr.com"

class RepositoryServiceAPI(val context: Context) {
    private val retrofitService = Retrofit.Builder()
        .baseUrl(constanceBaseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val retrofitApi = retrofitService.create(ImageAPI::class.java)

    suspend fun getImages(lat:Double, lon:Double) = retrofitApi.fetchPhotos(lat,lon )


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