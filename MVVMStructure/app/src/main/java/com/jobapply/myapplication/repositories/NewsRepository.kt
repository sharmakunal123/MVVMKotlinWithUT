package com.jobapply.myapplication.repositories

import com.jobapply.myapplication.db.AppDatabase
import com.jobapply.myapplication.model.Article
import com.jobapply.myapplication.networkpack.RetrofitInstance
import com.jobapply.myapplication.utils.Consts

class NewsRepository(val database: AppDatabase) {

    suspend fun getBreakingNews(query: String) =
            RetrofitInstance.api.getArticles(
                    query,
                    "2021-03-01",
                    "publishedAt",
                    Consts.NEW_API_KEY
            )

    suspend fun searchNews(query: String) =
            RetrofitInstance.api.getArticles(
                    query,
                    "2021-03-13",
                    "publishedAt",
                    Consts.NEW_API_KEY
            )

    suspend fun insertArticle(article: Article) = database.getArticleDao().insertArticle(article)

    // Use of Flow
    suspend fun getSavedArticles() = database.getArticleDao().getAllArticlesThroughFlow()
}