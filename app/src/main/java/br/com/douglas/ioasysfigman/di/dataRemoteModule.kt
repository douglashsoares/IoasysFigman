package br.com.douglas.ioasysfigman.di

import br.com.douglas.ioasysfigman.data.datasource.remote.BooksRemoteDataSource
import br.com.douglas.ioasysfigman.data.datasource.remote.LoginRemoteDatasource
import br.com.douglas.ioasysfigman.data_remote.datasource.BooksRemoteDataSourceImpl
import br.com.douglas.ioasysfigman.data_remote.datasource.LoginRemoteDatasourceImpl
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

    single<BooksRemoteDataSource> {
        BooksRemoteDataSourceImpl(get())
    }

    single<LoginRemoteDatasource> {
        LoginRemoteDatasourceImpl(get())
    }
}