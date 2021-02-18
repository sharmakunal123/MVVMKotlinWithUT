package com.jobapply.myapplication.di.modules

import com.jobapply.myapplication.MyApplication
import com.jobapply.myapplication.db.AppDatabase
import com.jobapply.myapplication.repositories.NewsRepository
import dagger.Module
import dagger.Provides

// private val application: Application
@Module
class DatabaseModule(val application: MyApplication) {
    // application: Application
    @Provides
    fun provideAppDatabase() = AppDatabase.invoke(application)

    @Provides
    fun provideNewsRepository(database: AppDatabase) = NewsRepository(database)
}