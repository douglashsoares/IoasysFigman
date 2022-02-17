package br.com.douglas.ioasysfigman.data_remote.datasource

import br.com.douglas.ioasysfigman.data.datasource.BooksDatasource
import br.com.douglas.ioasysfigman.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDatasourceImpl : BooksDatasource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {
        val books: List<Book> = listOf(
            Book(
                id = 1,
                name = "Crossing the chase"
            ),
            Book(
                id = 2,
                name = "Change By Design"
            ), Book(
                id = 3,
                name = "The Making of a Manager"
            ),
            Book(
                id = 4,
                name = "Don't Make me Think"
            ),
            Book(
                id = 5,
                name = "Web Design 181"
            )
        )
        emit(books)

        query?.let {
            emit(books.filter { book ->
                book.name.trim().contains(it, ignoreCase = true)
            })
        } ?: run {
            emit(books)
        }

    }
}