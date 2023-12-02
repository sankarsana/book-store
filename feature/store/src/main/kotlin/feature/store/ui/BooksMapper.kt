package feature.store.ui

import common.data.Book

internal object BooksMapper {

    fun toUi(book: Book) = BookItemState(
        shortName = book.shortName,
        name = book.name,
        price = book.price,
    )
}
