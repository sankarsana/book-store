package common.data.net

internal class BookStoreNetworkDataSource(
    private val api: BookStoreApi,
) {
    suspend fun getAll(): BookStoreResponse {
        return api.getAll()
    }
}
