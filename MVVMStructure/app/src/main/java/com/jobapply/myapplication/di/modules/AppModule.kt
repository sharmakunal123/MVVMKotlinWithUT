package com.jobapply.myapplication.di.modules

import com.jobapply.myapplication.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: MyApplication) {

    @Provides
    @Singleton
    fun providesApplication() = application
}