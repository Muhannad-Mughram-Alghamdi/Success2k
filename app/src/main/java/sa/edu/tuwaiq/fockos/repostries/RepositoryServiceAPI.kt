package sa.edu.tuwaiq.fockos.repostries

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sa.edu.tuwaiq.fockos.api.ImageAPI

//@Abdullah Alfaraj, Abdulaziz Alrajeh

private val constanceBaseUrl = "https://api.flickr.com"

class RepositoryServiceAPI() {
    private val retrofitService = Retrofit.Builder()
        .baseUrl(constanceBaseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
    private val retrofitApi = retrofitService.create(ImageAPI::class.java)

    suspend fun getUserInfo(lat:Double,lon:Double) = retrofitApi.fetchPhotos(lat,lon )


}