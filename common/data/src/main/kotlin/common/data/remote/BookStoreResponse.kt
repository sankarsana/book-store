package common.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class BookStoreResponse(

    @SerialName("databaseVersion")
    val databaseVersion: Int,

    @SerialName("books")
    val books: List<BookRemote>,

    @SerialName("writers")
    val writers: List<WriterRemote>,
)
