package com.example.ketrix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var ketrix: Ketrix

    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainContentLayout.post {
            ketrix = Ketrix(this, mainContentLayout)

            mainContentLayout.addView(ketrix)

            mainContentLayout.setOnClickListener{
                startGameLoop()
            }

        }
    }

    fun startGameLoop(){
        val runAsyncTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    ketrix.loop()
                }
            }
        }
        timer.schedule(runAsyncTask, 0,20)
    }

    fun stopGameLoop(){
        timer.cancel()
    }

    override fun onDestroy(){
        super.onDestroy()
    }
}
