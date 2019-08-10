package com.jcmo.login

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        var email : String
        var pass : String
        var conpass : String

        val etcorreo = findViewById<EditText>(R.id.etCorreo)
        val etpass = findViewById<EditText>(R.id.etPass)
        val etconpass = findViewById<EditText>(R.id.etcCnfirPass)

        var datosRecibidos =intent.extras

        btnsignup.setOnClickListener {
            email = etcorreo.text.toString()
            pass = etpass.text.toString()
            conpass = etconpass.text.toString()

            if(email == "" || pass == "" || conpass == ""){
                Toast.makeText(this,"Campos Vacios",Toast.LENGTH_SHORT).show()
            }else if(pass != conpass){
                Toast.makeText(this,"Constraseñas Diferentes",Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra("username",email )
                intent.putExtra("password",pass)
                setResult(Activity.RESULT_OK, intent)//llama actividad
                finish()//destruyr actividad
            }
        }

    }
}
