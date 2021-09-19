package com.example.emptyactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

lateinit var txt_results: TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}