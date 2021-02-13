package com.jobapply.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jobapply.myapplication.db.AppDatabase
import com.jobapply.myapplication.factories.NewsFactoryCls
import com.jobapply.myapplication.repositories.NewsRepository
import com.jobapply.myapplication.viewmodels.NewsViewModel

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        // DB instance
        val database = AppDatabase(context = this)
        // Repository need DB instance
        val repository = NewsRepository(database)
        // Factory need Repository with DB inside it
        val factory = NewsFactoryCls(repository)
        // ViewModel
        mViewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

    }
}