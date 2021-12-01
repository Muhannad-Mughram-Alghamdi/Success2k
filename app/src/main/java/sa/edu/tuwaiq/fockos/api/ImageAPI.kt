package sa.edu.tuwaiq.fockos.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sa.edu.tuwaiq.fockos.model.ImageModel
//@Abdullah Alfaraj, Abdulaziz Alrajeh

interface ImageAPI {
//https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3d70efd66148a45af867f6a64e0d4a6e&format=json&extras=url_s&nojsoncallback=1&extras=date_upload,date_taken,last_update,&=&=last_update
    @GET("//https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=3d70efd66148a45af867f6a64e0d4a6e&format=json&extras=url_s&nojsoncallback=1&extras=date_upload,date_taken,last_update,&=&=last_update")
    suspend fun fetchPhotos(
    @Query("lat")lat:Double,
    @Query("lon")lon:Double
    ): Response<ImageModel>
}