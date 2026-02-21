package com.example.lab6dev.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab6dev.MainActivity
import com.example.lab6dev.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val thread = Thread {
            try {
                Thread.sleep(2000)
            } catch (ignored: InterruptedException) {
            }
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
        thread.start()
    }
}