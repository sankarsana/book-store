package common.data.net

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BookDto(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("shortName")
    val shortName: String?,

    @SerialName("writerId")
    val writerId: Int,

    @SerialName("price")
    val price: Int,

    @SerialName("quantity")
    val quantity: Int,
)
