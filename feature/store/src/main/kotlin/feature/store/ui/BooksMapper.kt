package feature.store.ui

import common.data.book.Book

internal fun List<Book>.toUi(): List<BookItemState> {
    return map(::map)
}

private fun map(book: Book): BookItemState {
    return BookItemState(
        shortName = book.shortName,
        name = book.name,
        price = book.price,
    )
}
