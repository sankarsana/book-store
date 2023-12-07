package common.data.remote

internal class RemoteDataSource(
    private val api: BookStoreApi,
) {
    suspend fun getAllBooks(): BookStoreResponse {
        return api.getAllBooks()
    }
}
