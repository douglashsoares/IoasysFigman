package br.com.douglas.ioasysfigman.presentation.adapter

import br.com.douglas.ioasysfigman.domain.model.Book

interface BookClickListener {
    fun bookOnClickListener(book: Book)

}