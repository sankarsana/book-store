package common.data.remote

import retrofit2.http.GET

internal interface BookStoreApi {

    @GET("/books")
    suspend fun getAllBooks(): BookStoreResponse
}
