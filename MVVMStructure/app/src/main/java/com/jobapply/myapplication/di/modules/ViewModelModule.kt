package com.jobapply.myapplication.di.modules

import com.jobapply.myapplication.FirstFragment
import com.jobapply.myapplication.di.annotation.ViewModelKey
import com.jobapply.myapplication.viewmodels.NewsViewModel
import dagger.Binds
import dagger.multibindings.IntoMap

abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(NewsViewModel::class)
//    internal abstract fun bindFirstFragment(firstFragment: FirstFragment): ViewModelKey
}