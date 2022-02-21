package br.com.douglas.ioasysfigman.data_remote.model

import com.google.gson.annotations.SerializedName

data class BooksListResponce(
    @SerializedName("data")
    val data: List<BookResponse>
)
