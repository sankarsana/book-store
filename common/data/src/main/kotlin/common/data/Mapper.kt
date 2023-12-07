package common.data

import common.data.local.BookLocal
import common.data.local.WriterLocal
import common.data.remote.BookRemote
import common.data.remote.WriterRemote

internal fun List<BookRemote>.toBooksLocal(): List<BookLocal> = map { it.toBookLocal() }

internal fun BookRemote.toBookLocal() = BookLocal(
    id = id,
    name = name,
    shortName = shortName,
    writerId = writerId,
    price = price,
    quantity = quantity,
)

internal fun List<WriterRemote>.toWritersLocal(): List<WriterLocal> = map { it.toWriterLocal() }

internal fun WriterRemote.toWriterLocal() = WriterLocal(
    id = id,
    name = name,
)

internal fun List<BookLocal>.toBooks() = map { book ->
    Book(
        name = book.name,
        shortName = book.shortName,
        price = book.price,
    )
}
