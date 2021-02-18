package com.jobapply.myapplication.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jobapply.myapplication.repositories.NewsRepository
import com.jobapply.myapplication.viewmodels.NewsViewModel

class NewsFactoryCls(
    private val newsRepository: NewsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}