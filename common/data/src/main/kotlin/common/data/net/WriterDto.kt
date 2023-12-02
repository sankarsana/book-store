package common.data.net

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class WriterDto(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,
)
