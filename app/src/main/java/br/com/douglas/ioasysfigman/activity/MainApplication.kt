package br.com.douglas.ioasysfigman.activity

import android.app.Application
import br.com.douglas.ioasysfigman.di.dataModule
import br.com.douglas.ioasysfigman.di.dataRemoteModule
import br.com.douglas.ioasysfigman.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule
            ).androidContext(applicationContext)
        }


    }


}