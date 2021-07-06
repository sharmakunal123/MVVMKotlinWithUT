package com.jobapply.myapplication

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// Working on Below
// https://www.youtube.com/watch?v=zJuFYqnBcgQ&list=PLgCYzUzKIBE_ZuZzgts135GuLQNX5eEPk&index=4
class LearnMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_main)
        findViewById<Button>(R.id.button_next_activity).setOnClickListener {
            val intent = Intent(this, LearnSecondMainActivity::class.java)
            startActivity(intent)
        }
    }
}