package br.com.douglas.ioasysfigman.data_remote.service

import br.com.douglas.ioasysfigman.data_remote.model.BooksListResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookService {

    @GET("books")
    suspend fun getBooks(
        @Header("Authorization") accessToken: String,
        @Query("page") page: Int,
        @Query("category") category: String
    ):
            Response<BooksListResponce>
}