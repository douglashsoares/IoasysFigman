package br.com.douglas.ioasysfigman.domain.models

data class Book(
    val id: Int,
    val name: String,
    val author: String = "Tim Brown",
    val pages: String = "150 páginas",
    val editor: String = "Editora Loyola",
    val date: String = "Publicado em 2020",
    val originName: String = "Change by Design",
    val isbn10: String = "0062856626",
    val isbn13: String = "978-0062856623",
    val language: String = "Inglês",
    val review: String = "The subject of “design thinking” is the rage at business schools, throughout corporations, and increasingly in the popular press—due in large part to the work of IDEO, a leading design firm, and its celebrated CEO, Tim Brown, who uses this book to show how the techniques and strategies of design belong at every level."
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

        fun getMockListCount(count: Int): List<Book> {
            val mocklist = mutableListOf<Book>()

            for (id in 1..count) {
                mocklist.add(
                    Book(
                        id = id,
                        name = "Crossing the Charm"
                    )
                )
            }
            return mocklist
        }


    }

}
