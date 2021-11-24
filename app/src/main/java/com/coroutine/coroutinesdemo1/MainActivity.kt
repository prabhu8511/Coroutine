package com.coroutine.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutinesdemo1.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {
            tvCount.text = count++.toString()
        }
        btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.Main).launch {
                //tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
                tvUserMessage.text = UserDataManager2().getTotalUserCount().toString()
                 //downloadUserData()
                Log.i("MyTag", "Downloading user  in ${Thread.currentThread().name}")

            }

            CoroutineScope(Dispatchers.IO).launch {
                // downloadUserData()
                Log.i("MyTag", "Downloading user  in ${Thread.currentThread().name}")
            }


        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..2000) {
            //to switch between threads
            withContext(Dispatchers.Main){
                tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
           // Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }

    }
}

