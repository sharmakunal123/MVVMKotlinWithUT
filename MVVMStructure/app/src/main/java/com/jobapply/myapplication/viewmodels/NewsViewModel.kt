package com.jobapply.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobapply.myapplication.model.ArticlesModel
import com.jobapply.myapplication.repositories.NewsRepository
import com.jobapply.myapplication.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response

// https://www.youtube.com/watch?v=v2yocpEcE_g&t=401s
// https://www.youtube.com/watch?v=RkRX446RSPk
// All from  :- https://www.youtube.com/watch?v=hMpP6N9LGFA&list=PLQkwcJG4YTCRF8XiCRESq1IFFW8COlxYJ&index=11
class NewsViewModel(val repository: NewsRepository) : ViewModel() {

    val breakingNews: MutableLiveData<Resource<ArticlesModel>> = MutableLiveData()
    //    val searchNews: MutableLiveData<Resource<ArticlesModel>> = MutableLiveData()

    var breakingNewsPage = 1

    init {
        getBreakingNews("tesla")
    }

    fun getBreakingNews(query: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = repository.getBreakingNews(query)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }


    private fun handleBreakingNewsResponse(response: Response<ArticlesModel>): Resource<ArticlesModel> {
        if (response.isSuccessful) {
            response.body()?.let { resuleResponse ->
                return Resource.Success(resuleResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun search(search: String) {
        getBreakingNews(search)
    }

    fun displayUsingFlow() {
        viewModelScope.launch {
            repository.getSavedArticles().collect {
                // Update MutableViewModel
                Log.e("displayData", "" + it.size)
            }
        }
    }


}