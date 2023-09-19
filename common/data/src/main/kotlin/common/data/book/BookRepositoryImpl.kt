package common.data.book

internal class BookRepositoryImpl : BookRepository {

    override suspend fun getAll(): List<Book> {
        return listOf(
            Book(
                shortName = "БГ",
                name = "Бхагавад Гита",
                price = "350",
            ),
            Book(
                shortName = "СВСО",
                name = "Совершенные вопросы совершенные ответы",
                price = "70",
            ),
            Book(
                shortName = "ШИ",
                name = "Шри Ишопанишад",
                price = "100",
            ),
            Book(
                shortName = "НС",
                name = "Наука сомоосознания",
                price = "120",
            ),
        )
    }
}
