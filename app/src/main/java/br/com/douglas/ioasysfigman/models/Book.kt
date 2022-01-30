package br.com.douglas.ioasysfigman.models

import android.icu.number.IntegerWidth

data class Book(
    val id: Int,
    val name: String,
    val author: String = "Tim Brown",
    val pages: String = "150 páginas",
    val editor: String = "Editora Loyola",
    val date: String = "Publicado em 2020"

) {

    companion object {

        fun getMockList() = listOf(
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


    }

}
