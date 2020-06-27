package com.cursoandroid.logeosociospenarol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login_ok.*
import kotlin.random.Random

class loginOkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_ok)

        textView_membernumber_loginok.text = numberMember().toString()

        val member_user = intent.getStringExtra(EXTRA_KEY_USER)
        textView_memberuser_loginok.text = member_user
    }

    fun numberMember(): Int{
        return Random.nextInt(1, Int.MAX_VALUE)
    }

    companion object{
        val EXTRA_KEY_USER = "com.cursoandroid.logeosociospenarol.EXTRA_KEY_USER"
    }

}
