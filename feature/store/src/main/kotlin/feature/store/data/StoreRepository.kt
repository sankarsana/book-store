package feature.store.data

import feature.store.ui.BookUiItem

/**
 * @author s.a.demyanov
 */
internal object StoreRepository {

    fun getBooks() = listOf(
        BookUiItem(
            shortName = "БГ",
            name = "Бхагавад Гита",
            price = "350",
        ),
        BookUiItem(
            shortName = "СВСО",
            name = "Совершенные вопросы совершенные ответы",
            price = "70",
        ),
        BookUiItem(
            shortName = "ШИ",
            name = "Шри Ишопанишад",
            price = "100",
        ),
        BookUiItem(
            shortName = "НС",
            name = "Наука сомоосознания",
            price = "120",
        ),
    )
}
