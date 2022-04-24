package br.com.douglas.ioasysfigman.di

import br.com.douglas.ioasysfigman.data_local.utils.SharedPreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single {
        SharedPreferencesHelper(androidContext())
    }
}