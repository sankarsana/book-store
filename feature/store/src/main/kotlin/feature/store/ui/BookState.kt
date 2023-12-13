package feature.store.ui

internal class BookState(
    val name: String,
    val shortName: String?,
    val price: String,
)

@Suppress("FunctionName")
internal fun BookStatePreviewData() = BookState(
    name = "Бхагавад Гита",
    shortName = "БГ",
    price = "350",
)
