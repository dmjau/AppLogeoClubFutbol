package com.cursoandroid.logeosociospenarol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.textView_pass_input_form

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_login_main.setOnClickListener{
            if (loginVerify()){
                sendButtonLogin()
            }
        }
        button_register_main.setOnClickListener{
            sendButtonRegister()
        }
    }

    private fun loginVerify(): Boolean{
        if (textView_user_input_main.text.isEmpty() || textView_pass_input_form.text.isEmpty()){
            Toast.makeText(this, "INGRESE USUARIO y CONTRASEÑA", Toast.LENGTH_LONG).show()
        } else {
            return passVerify()
        }
        return false
    }



    private fun passVerify(): Boolean{
        if(textView_pass_input_form.text.length <= 7){
            Toast.makeText(this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_LONG).show()
        } else {
            return true
        }
        return false
    }

    private fun sendButtonLogin (){
        val user = textView_user_input_main.text.toString()
        val intent: Intent = Intent(this, loginOkActivity::class.java).apply {
            putExtra(loginOkActivity.EXTRA_KEY_USER, user)
        }
        startActivity(intent)
    }

    fun sendButtonRegister(){
        val intent: Intent = Intent(this, formActivity::class.java)
        startActivity(intent)
    }







}
