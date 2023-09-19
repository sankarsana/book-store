package feature.store.ui

import common.data.book.Book

fun List<Book>.toUi(): List<BookUiItem> {
    return map(::map)
}

private fun map(book: Book): BookUiItem {
    return BookUiItem(
        shortName = book.shortName,
        name = book.name,
        price = book.price,
    )
}
