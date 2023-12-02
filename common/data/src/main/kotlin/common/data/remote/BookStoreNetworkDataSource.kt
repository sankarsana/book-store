package common.data.remote

internal class BookStoreNetworkDataSource(
    private val api: BookStoreApi,
) {
    suspend fun getAll(): BookStoreResponse {
        return api.getAll()
    }
}
