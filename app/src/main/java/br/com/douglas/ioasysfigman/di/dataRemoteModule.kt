package br.com.douglas.ioasysfigman.di

import br.com.douglas.ioasysfigman.data.datasource.BooksDatasource
import br.com.douglas.ioasysfigman.data.datasource.LoginDatasource
import br.com.douglas.ioasysfigman.data_remote.datasource.BooksDatasourceImpl
import br.com.douglas.ioasysfigman.data_remote.datasource.LoginDatasourceImpl
import org.koin.dsl.module

val dataRemoteModule = module {

    single<BooksDatasource> {
        BooksDatasourceImpl()
    }

    single <LoginDatasource>{
        LoginDatasourceImpl()
    }
}