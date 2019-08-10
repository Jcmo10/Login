package com.jcmo.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registro.*

class LoginActivity : AppCompatActivity() {

     var email : String = ""
     var pass : String  = ""

     //var emailM : String = ""
   // var passM : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var emaill : String
        var passl : String


        val etcorreo = findViewById<EditText>(R.id.etEmaill)
        val etpass = findViewById<EditText>(R.id.etPassl)
        //var intent2 = Intent(this, MainActivity::class.java)
        email = intent.extras?.getString("correo").toString()
        pass = intent.extras?.getString("pass").toString()
       /*var datosRecibidos = intent.extras
        var emailM = datosRecibidos!!.getString("correo").toString()
        var passM =  datosRecibidos!!.getString("pass").toString()
        */
        btnLogin.setOnClickListener {
            //email = intent.getStringArrayExtra("correo").toString()
            //pass = intent.getStringArrayExtra("pass").toString()
            emaill = etcorreo.text.toString()
            passl = etpass.text.toString()



            if(emaill == "" || passl == ""){
                Toast.makeText(this,"Campos Vacios",Toast.LENGTH_SHORT).show()
            }else if(emaill != email || passl != pass ){
                Toast.makeText(this,"Correo o Contraseña no coinciden",Toast.LENGTH_SHORT).show()
            }/*else if( emailM != email || passM != pass){
                Toast.makeText(this,"Correo o Contraseña no coinciden2",Toast.LENGTH_SHORT).show()
            }*/
            else{
                if( email == null &&  pass == null) {
                    Toast.makeText(this,"Correo o Contraseña no coinciden222",Toast.LENGTH_SHORT).show()
                }else{
                    intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("correo", email)
                    intent.putExtra("pass", pass)
                    startActivity(intent)
                    finish()
                }
                //if(emaill == email && passl == pass) {


                /*}else if(emailM == email && passM == pass){
                    var intent2 = Intent(this,MainActivity::class.java)
                    intent2.putExtra("correo",emailM)
                    intent2.putExtra("pass",passM)
                    startActivity(intent2)
                    finish()
                *///}

            }

        }

        tvsignup.setOnClickListener{
            var intent = Intent(this,RegistroActivity::class.java)
            startActivityForResult(intent,1234) //llama una actividad
        }


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1234 && resultCode== Activity.RESULT_OK){
            email = data!!.extras!!.getString("username").toString()
            pass = data!!.extras!!.getString("password").toString()

        }
    }

}
