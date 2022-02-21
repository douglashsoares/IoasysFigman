package br.com.douglas.ioasysfigman.data_remote.datasource

import br.com.douglas.ioasysfigman.data.datasource.BooksDatasource
import br.com.douglas.ioasysfigman.data_remote.mappers.toDomain
import br.com.douglas.ioasysfigman.data_remote.service.BookService
import br.com.douglas.ioasysfigman.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksDatasourceImpl(
    private val bookService: BookService
) : BooksDatasource {

    override fun getBooks(accessToken: String, query: String?): Flow<List<Book>> = flow {

        val responce = bookService.getBooks(accessToken = "Bearer $accessToken", page = 1, category = "")
        if (responce.isSuccessful){

            responce.body()?.data?.let {bookList ->
                query?.let {
                    emit(bookList.filter { book ->
                        book.name?.trim()?.contains(it, ignoreCase = true)?: false
                    }.toDomain())
                } ?: run {
                    emit(bookList.toDomain())
                }
            }
            }




    }
}