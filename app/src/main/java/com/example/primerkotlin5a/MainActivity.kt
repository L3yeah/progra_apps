package com.example.primerkotlin5a

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.primerkotlin5a.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Vincular vistas con MainActivity

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            val texto1: String = binding.eTxtNombre.text.toString()
            binding.txtMensaje.text=texto1
            Toast.makeText(this, "Me diste click", Toast.LENGTH_LONG).show()

            val a = "Bienvenido"
            val c = " programador de apps."
            val resultado = "$a $texto1 $c"
            binding.txtMensaje.text=resultado
        }
    }
}
