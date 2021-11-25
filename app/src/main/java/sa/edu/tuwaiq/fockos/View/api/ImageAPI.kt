package sa.edu.tuwaiq.fockos.View.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sa.edu.tuwaiq.fockos.View.model.ImageModel
//@Abdullah Alfaraj, Abdulaziz Alrajeh

interface ImageAPI {

    @GET("/services/rest/?method=flickr.photos.search&api_key=3d70efd66148a45af867f6a64e0d4a6e&format=json&extras=url_s&nojsoncallback=1")
    suspend fun fetchPhotos(
    @Query("lat")lat:Double,
    @Query("lon")lon:Double
    ): Response<ImageModel>
}