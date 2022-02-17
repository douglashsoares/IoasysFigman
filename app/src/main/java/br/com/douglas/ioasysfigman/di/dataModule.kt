package br.com.douglas.ioasysfigman.di

import br.com.douglas.ioasysfigman.data.repositories.BooksRepositoryImpl
import br.com.douglas.ioasysfigman.data.repositories.LoginRepositoryImpl
import br.com.douglas.ioasysfigman.domain.repositories.BooksRepository
import br.com.douglas.ioasysfigman.domain.repositories.LoginRepository
import org.koin.dsl.module

val dataModule =  module {
    single<BooksRepository> {
        BooksRepositoryImpl( get() )
    }

    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }
}