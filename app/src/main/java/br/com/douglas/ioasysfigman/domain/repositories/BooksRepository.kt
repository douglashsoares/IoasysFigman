package br.com.douglas.ioasysfigman.domain.repositories

import br.com.douglas.ioasysfigman.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRepository {
    fun getBooks (accessToken: String, query: String?): Flow<List<Book>>
}