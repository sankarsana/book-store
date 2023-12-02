package common.data.net

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class BookStoreResponse(

    @SerialName("databaseVersion")
    val databaseVersion: Int,

    @SerialName("books")
    val books: List<BookDto>,

    @SerialName("writers")
    val writers: List<WriterDto>,
)
