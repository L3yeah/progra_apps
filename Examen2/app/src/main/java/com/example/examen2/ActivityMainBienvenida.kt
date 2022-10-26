package com.example.examen2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examen2.databinding.ActivityMainBienvenidaBinding
import com.example.examen2.databinding.ActivityMainBinding

class ActivityMainBienvenida : AppCompatActivity() {

    private lateinit var binding: ActivityMainBienvenidaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //dependencias para Binding //para que el binding funcione en lugar del recycler viewer
        binding = ActivityMainBienvenidaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setContentView(R.layout.activity_main_bienvenida) //funciones para utilizar el Recycler View, cambiarlas a binding

        //variable para recibir
        val extra = intent.extras
        //variable para recibir el dato -> nombre
        val nombre = extra?.getString("key")
        binding.textView3.text=nombre.toString()


        //funcionalidad al boton
        binding.button2.setOnClickListener(){

            //variables para los plain text
            val activity = Intent(this,MainActivity::class.java)

            startActivity(activity)

        }

    }
}

