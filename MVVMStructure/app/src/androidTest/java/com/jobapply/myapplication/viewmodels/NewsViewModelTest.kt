package com.jobapply.myapplication.viewmodels

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jobapply.myapplication.db.AppDatabase
import com.jobapply.myapplication.model.Article
import com.jobapply.myapplication.model.Source
import com.jobapply.myapplication.repositories.NewsRepository
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NewsViewModelTest {

    private lateinit var viewModel: NewsViewModel
    private lateinit var spendsDatabase: AppDatabase

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        spendsDatabase =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()

        val repository = NewsRepository(spendsDatabase)
        viewModel = NewsViewModel(repository)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        spendsDatabase.close()
    }

    @Test
    fun Firsttesting() {
        assertTrue(true)
    }

    @Test
    fun testAddingSpend() {
        val article = Article(
            0, "auther", "content",
            "description", "publishAt",
            Source("id", "sourceName"), "title", "url", "urlToImage"
        )

        viewModel.insertArticle(article)
        viewModel.getArticle()

        val result = viewModel.testingDbGetArticle.getOrAwaitValue().find {
            it.author == "auther" && it.description == "description"
        }

        assertNotNull(result)
    }

}