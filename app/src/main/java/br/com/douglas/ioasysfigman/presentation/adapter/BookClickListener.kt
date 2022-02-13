package br.com.douglas.ioasysfigman.presentation.adapter

import br.com.douglas.ioasysfigman.domain.models.Book

interface BookClickListener {
    fun bookOnClickListener(book: Book)

}