package com.example.listaalumnosok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.listaalumnosok.databinding.ActivityMainNuevoBinding

class MainActivityNuevo : AppCompatActivity() {
    //Vincular las vistas con MainActivity
    private lateinit var binding: ActivityMainNuevoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNuevoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parExtra = intent.extras
        //var miVar = parExtra?.getString("valor1")

        //binding.txtDato.text= miVar.toString()

    }
}