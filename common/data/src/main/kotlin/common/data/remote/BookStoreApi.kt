package common.data.remote

import retrofit2.http.GET

internal interface BookStoreApi {

    @GET("/books")
    suspend fun getAll(): BookStoreResponse

    companion object {
        const val BASE_URL = "http://10.0.2.2:8080"
    }
}
