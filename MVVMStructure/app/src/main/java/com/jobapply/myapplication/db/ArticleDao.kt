package com.jobapply.myapplication.db

import androidx.room.*
import com.jobapply.myapplication.model.ArticlesModel

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articlesModel: ArticlesModel): Long

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<ArticlesModel>

    @Delete
    suspend fun deleteArticle(articlesModel: ArticlesModel): Long

//    @Query("SELECT * FROM articles")
//    suspend fun getAllArticles(): LiveData<ArticlesModel>
}