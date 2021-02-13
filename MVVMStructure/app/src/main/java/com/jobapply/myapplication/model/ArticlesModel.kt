package com.jobapply.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "articles"
)
data class ArticlesModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)