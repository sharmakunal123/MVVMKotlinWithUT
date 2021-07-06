package com.jobapply.myapplication

import android.app.Application
import com.jobapply.myapplication.di.components.AppComponent
import com.jobapply.myapplication.di.components.DaggerAppComponent
import com.jobapply.myapplication.di.modules.AppModule
import com.jobapply.myapplication.di.modules.DatabaseModule

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
                .builder()
                .databaseModule(DatabaseModule(this))
                .appModule(AppModule(this))
                .build()

    }
}