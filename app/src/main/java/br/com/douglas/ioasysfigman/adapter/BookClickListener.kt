package br.com.douglas.ioasysfigman.adapter

import br.com.douglas.ioasysfigman.models.Book

interface BookClickListener {
    fun bookOnClickListener(book: Book)

}