package common.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class WriterRemote(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,
)
