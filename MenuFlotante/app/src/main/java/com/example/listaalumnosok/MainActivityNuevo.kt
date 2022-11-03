package com.example.listaalumnosok

import android.content.Intent
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

        //llamo las condiciones para editar los alumnos
        val parExtra = intent.extras
        val msje = parExtra?.getString("mensaje")

        if (msje=="edit"){
            val nombre = parExtra?.getString("nombre")
            val cuenta = parExtra?.getString("cuenta")
            val correo = parExtra?.getString("correo")
            val image = parExtra?.getString("image")

            //Pasamos a los elementos del layout los valores para cargarlos
            binding.txtNombre.setText(nombre)
            binding.txtCuenta.setText(cuenta)
            binding.txtCorreo.setText(correo)
            binding.txtImage.setText(image)
        }


        //val idAlum = parExtra?.getInt("idA")

        binding.btnGuardar.setOnClickListener {
            val txtNom = binding.txtNombre.text
            val txtCue = binding.txtCuenta.text
            val txtCorr = binding.txtCorreo.text
            val txtImg = binding.txtImage.text


            val intento2 = Intent(this,MainActivity::class.java)
            intento2.putExtra("mensaje","nuevo")
            intento2.putExtra("nombre","${txtNom}")
            intento2.putExtra("cuenta","${txtCue}")
            intento2.putExtra("correo","${txtCorr}")
            intento2.putExtra("image","${txtImg}")
            //intento2.putExtra("idA","${idAlum}")
            startActivity(intento2)


        }

    }
}