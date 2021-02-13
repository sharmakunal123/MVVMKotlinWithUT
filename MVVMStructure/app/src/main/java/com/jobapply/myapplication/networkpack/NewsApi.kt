package com.jobapply.myapplication.networkpack

import com.jobapply.myapplication.model.ArticlesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    // ?q=tesla&from=2021-01-13&sortBy=publishedAt&apiKey=db010d13d4654541a0498ce7abdabc14
    @GET("v2/everything")
    suspend fun getArticles(
        @Query("q") query: String,
        @Query("from") fromDate: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): Response<ArticlesModel>

}