package com.jobapply.myapplication.model

data class ArticlesModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)