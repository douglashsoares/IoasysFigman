package br.com.douglas.ioasysfigman.di

import br.com.douglas.ioasysfigman.data.datasource.BooksDatasource
import br.com.douglas.ioasysfigman.data.datasource.LoginDatasource
import br.com.douglas.ioasysfigman.data_remote.datasource.BooksDatasourceImpl
import br.com.douglas.ioasysfigman.data_remote.datasource.LoginDatasourceImpl
import br.com.douglas.ioasysfigman.data_remote.service.AuthService
import br.com.douglas.ioasysfigman.data_remote.service.BookService
import br.com.douglas.ioasysfigman.data_remote.utils.ApiConstants
import br.com.douglas.ioasysfigman.data_remote.utils.WebServicesFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServicesFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }
    single<BookService> {
        WebServicesFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single {
        WebServicesFactory.providerOkHttpClient()
    }

    single<BooksDatasource> {
        BooksDatasourceImpl(get())
    }

    single<LoginDatasource> {
        LoginDatasourceImpl(get())
    }
}