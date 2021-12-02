package sa.edu.tuwaiq.fockos.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sa.edu.tuwaiq.fockos.model.ImageModel
//@Abdullah Alfaraj, Abdulaziz Alrajeh

/**
 * This is our API class where we pass it the link we tested using postman. Also, we created as a
 * function that fetches the photos and passed the Latitude and Longitude to get photos base on the
 * location of the device
 */
interface ImageAPI {
    @GET("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3d70efd66148a45af867f6a64e0d4a6e&format=json&extras=url_s&nojsoncallback=1")
    suspend fun fetchPhotos(
    @Query("lat")lat:Double,
    @Query("lon")lon:Double
    ): Response<ImageModel>
}