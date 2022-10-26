package com.example.examen2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examen2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //dependencias para Binding //para que el binding funcione en lugar del recycler viewer
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //variables para los plain text
        val activity = Intent(this,ActivityMainBienvenida::class.java)

        //variable para llamar la clase Persona
        val persona = ArrayList <Persona>()
        persona.add(Persona("Lilia Sarahi Trujillo Rivera")) //pasar este dato al main_Bienvenida

        //funcionalidad al boton
        binding.button.setOnClickListener(){

            val user = binding.editTextTextPersonName.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            //validar user y password
            if (user == "lilia" && password == "1997"){

                val nombre = persona [0].nombre
                activity.putExtra("key", "$nombre")

                startActivity(activity)
            }
            else {
                Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }
}