package com.jobapply.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.*
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jobapply.myapplication.db.AppDatabase
import com.jobapply.myapplication.factories.NewsFactoryCls
import com.jobapply.myapplication.repositories.NewsRepository
import com.jobapply.myapplication.viewmodels.NewsViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

//
////        MyApplication.appComponent.inject(this)
//
//        // DB instance
////        val database = AppDatabase(context = this)
//        // Repository need DB instance
//
//            val repository = NewsRepository(database)
//        // Factory need Repository with DB inside it
//        val factory = NewsFactoryCls(repository)
//        // ViewModel
//        mViewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

    }

    @SuppressLint("WrongConstant")
    private fun hasInternetCheck(): Boolean {
        val connectivityManager = applicationContext.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasCapability(TRANSPORT_WIFI) -> true
                capabilities.hasCapability(TRANSPORT_CELLULAR) -> true
                capabilities.hasCapability(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {

        }
        return false
    }

}