package com.jobapply.myapplication.db

import androidx.room.*
import com.jobapply.myapplication.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articlesModel: Article): Long

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<Article>

    @Query("SELECT * FROM articles")
    suspend fun getAllArticlesThroughFlow(): List<Article>

//    @Query("SELECT * FROM articles")
//    fun getAllArticlesThroughFlow(): Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(articlesModel: Article)

//    @Query("SELECT * FROM articles")
//    suspend fun getAllArticles(): LiveData<ArticlesModel>
}