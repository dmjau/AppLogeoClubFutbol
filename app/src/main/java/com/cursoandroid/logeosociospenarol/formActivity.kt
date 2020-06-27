package com.cursoandroid.logeosociospenarol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_form.textView_pass_input_form
import kotlinx.android.synthetic.main.activity_main.*

class formActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        button_register_form.setOnClickListener{
            if(verify()){
                buttonSendLoginOkFromForm()
            }
        }
    }
    fun verify():Boolean{
        if(textView_user_input_form.text.isEmpty()||textView_pass_input_form.text.isEmpty()||textView_password_input_confirm_form.text.isEmpty()){
            Toast.makeText(this, "DEBE COMPLETAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show()
        } else{
            return passVerify()
        }
        return false
    }


    private fun passVerify(): Boolean{
        if(textView_pass_input_form.text.length <= 7){
            Toast.makeText(this, "La contraseña debe tener más de 8 caracteres", Toast.LENGTH_LONG).show()
        } else {
            return comparePasswords()
        }
        return false
    }

    fun comparePasswords(): Boolean{
        if(textView_pass_input_form.text.toString() == textView_password_input_confirm_form.text.toString()){
            return true
        } else {
            Toast.makeText(this, "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_LONG).show()
        }
        return false
    }

    fun buttonSendLoginOkFromForm(){
        val user = textView_user_input_form.text.toString()
        val intent: Intent = Intent(this, loginOkActivity::class.java).apply {
            putExtra(loginOkActivity.EXTRA_KEY_USER, user)
        }
        startActivity(intent)
    }
}
