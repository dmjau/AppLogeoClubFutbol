package com.cursoandroid.logeosociospenarol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 3000 // 1 seg

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}
