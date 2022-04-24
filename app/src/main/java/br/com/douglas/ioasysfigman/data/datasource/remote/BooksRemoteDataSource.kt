package br.com.douglas.ioasysfigman.data.datasource.remote

import br.com.douglas.ioasysfigman.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksRemoteDataSource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}