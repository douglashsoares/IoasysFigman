package br.com.douglas.ioasysfigman.data.datasource

import br.com.douglas.ioasysfigman.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BooksDatasource {

    fun getBooks(accessToken: String, query: String?): Flow<List<Book>>
}