package br.com.douglas.ioasysfigman.data.repositories

import br.com.douglas.ioasysfigman.data.datasource.BooksDatasource
import br.com.douglas.ioasysfigman.domain.model.Book
import br.com.douglas.ioasysfigman.domain.repositories.BooksRepository
import kotlinx.coroutines.flow.Flow

class BooksRepositoryImpl(
    private val booksDatasource: BooksDatasource
) : BooksRepository {
    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> =
        booksDatasource.getBooks(accessToken, query)


}