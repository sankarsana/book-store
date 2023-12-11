package feature.store.domain

import common.data.Book

internal class FilterBooksUseCase {

    operator fun invoke(books: List<Book>, query: String): List<Book> {
        if (query.isEmpty()) return books
        return books.filter { book ->
            val matchName = book.name.split(" ").any { word ->
                word.startsWith(query, ignoreCase = true)
            }
            val matchShortName = book.shortName?.startsWith(query, ignoreCase = true) == true
            matchName || matchShortName
        }
    }
}
