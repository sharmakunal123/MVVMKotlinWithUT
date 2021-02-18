package com.jobapply.myapplication.di.components

import android.app.Application
import com.jobapply.myapplication.FirstFragment
import com.jobapply.myapplication.MainActivity
import com.jobapply.myapplication.MyApplication
import com.jobapply.myapplication.di.modules.AppModule
import com.jobapply.myapplication.di.modules.DatabaseModule
import com.jobapply.myapplication.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, AppModule::class])
interface AppComponent {
    fun inject(application: MyApplication)
//    fun inject(application: Application)
    fun inject(firstFragment: FirstFragment)

//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: Application)
//        fun build(): AppComponent
//    }
}