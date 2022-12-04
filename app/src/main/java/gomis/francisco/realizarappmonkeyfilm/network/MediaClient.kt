package  gomis.francisco.realizarappmonkeyfilm.network

import gomis.francisco.realizarappmonkeyfilm.network.response.MediaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MediaClient {

    //https://run.mocky.io/v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9
    //@GET("v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9")
    @GET("https://run.mocky.io/v3/ba19d40a-9750-4413-bd70-9c6e703cc9e9")
    suspend fun getMedia(filter: String): Response<MediaResponse>
}