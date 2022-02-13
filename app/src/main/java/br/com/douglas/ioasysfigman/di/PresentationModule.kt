package br.com.douglas.ioasysfigman.di

import br.com.douglas.ioasysfigman.presentation.viewmodel.BookListViewModel
import br.com.douglas.ioasysfigman.presentation.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule =  module {
    viewModel{ LoginViewModel()}
    viewModel { BookListViewModel() }
}