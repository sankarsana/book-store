package common.data.exception

class RemoteServerException @JvmOverloads constructor(
    message: String? = null,
    cause: Throwable? = null,
) : RuntimeException(message, cause)
