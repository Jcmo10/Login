package com.jcmo.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var emailM: String? = null
    private var passM: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var datosRecibidos = intent.extras
        emailM = datosRecibidos?.getString("correo").toString()
        passM =  datosRecibidos?.getString("pass").toString()

        tvCorreoM.text = emailM
        tvContraseñaM.text = passM

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_overflow,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.mlogout -> {
                 intent = Intent(this,LoginActivity::class.java)
                intent.putExtra("correo",emailM)
                intent.putExtra("pass",passM)
                startActivity(intent)
                finish()

            }

        }
        return super.onOptionsItemSelected(item)
    }

}
