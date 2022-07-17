package com.example.myapplication.ui

import android.app.Application
import com.example.myapplication.Module.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.loadKoinModules

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            loadKoinModules(listOf(appModule))
        }

    }


}
