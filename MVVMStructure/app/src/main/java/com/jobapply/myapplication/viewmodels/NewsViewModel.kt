package com.jobapply.myapplication.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobapply.myapplication.model.Article
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
    val dbBreakingNewsResp: MutableLiveData<Resource<List<Article>>> = MutableLiveData()

    val testingDbGetArticle: MutableLiveData<List<Article>> = MutableLiveData()

    val inputDetail = MutableLiveData<String>()
    val btnHandling = MutableLiveData<String>()

    val mutableBreakingNews: MutableLiveData<Resource<ArticlesModel>>
        get() = breakingNews
    val mutableDbBreakingNewsResp: MutableLiveData<Resource<List<Article>>>
        get() = dbBreakingNewsResp


    init {
        // getBreakingNews("tesla")
        handleDbBreakingNewsResponse("tesla")
        btnHandling.value = "Search"
    }

    fun getBreakingNews(query: String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = repository.getBreakingNews(query)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<ArticlesModel>): Resource<ArticlesModel> {
        Log.e("editField", "" + response.body())
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun search(search: String) {
        getBreakingNews(search)
    }

    fun displayUsingFlow() {
        viewModelScope.launch {
//            repository.getSavedArticles().collect {
//                // Update MutableViewModel
//                Log.e("displayData", "" + it.size)
//            }
        }
    }

    fun handleDbBreakingNewsResponse(query: String) = viewModelScope.launch {
        dbBreakingNewsResp.postValue(Resource.Loading())
        val result = repository.getBreakingNews(query)
        val dbResp = parseDbResponse(result)
        dbResp.data?.let {
            dbBreakingNewsResp.postValue(Resource.Success(dbResp.data))
        }

    }

    private fun parseDbResponse(result: Response<ArticlesModel>): Resource<List<Article>> {
        if (result.isSuccessful) {
            val serverResp = result.body() as ArticlesModel
            return Resource.Success(serverResp.articles)
        }
        return Resource.Error(result.message())
    }


    /**
     * Button Click Handling
     */
    fun handleClick() {
        val str = inputDetail.value.toString()
        handleDbBreakingNewsResponse(str)
    }

    fun getResult(value: Int): Int {
        return 10 + value
    }


    fun insertArticle(article: Article) = viewModelScope.launch {
        repository.insertArticle(article)
    }

    fun getArticle() = viewModelScope.launch {
        testingDbGetArticle.value = repository.getSavedArticles()
    }

}