package me.dio.githubportfolio

import android.app.Application
import me.dio.githubportfolio.data.di.DataModule
import me.dio.githubportfolio.domain.di.DomainModule
import me.dio.githubportfolio.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}