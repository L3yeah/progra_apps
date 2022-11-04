package com.example.listaalumnosok

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        val idAlumno = parExtra?.getInt("idA")

        Toast.makeText(this,"idAlumno = $idAlumno",Toast.LENGTH_LONG).show()

        //Abrimos la conexion
        val dbconx = DBHelperAlumno(this)

        if(idAlumno!=null){
            binding.txtDato.text="Modificar alumno"
            val db = dbconx.readableDatabase

            val cursor = db.rawQuery("SELECT * FROM alumnos WHERE id=$idAlumno",null)

            if(cursor.moveToFirst()){
                var itemNom = cursor.getString(1)
                var itemCue = cursor.getString(2)
                var itemCorr = cursor.getString(3)
                var itemImg = cursor.getString(4)
                binding.txtNombre?.setText("$itemNom")
                binding.txtCuenta?.setText("$itemCue")
                binding.txtCorreo?.setText("$itemCorr")
                binding.txtImage?.setText("$itemImg")
            }
            db.close()
            cursor.close()
        }

        val intento2 = Intent(this,MainActivity::class.java)

        binding.btnGuardar.setOnClickListener {
            //Abrimos la base de datos para escribir
            val db = dbconx.writableDatabase

            val txtNom = binding.txtNombre.text.toString()
            val txtCue = binding.txtCuenta.text.toString()
            val txtCorr = binding.txtCorreo.text.toString()
            val txtImg = binding.txtImage.text.toString()

            /*
        //Alternativa 1 de insert , no se recomienda
        val sql = "INSERT INTO alumnos (nombre, cuenta, correo, imagen) VALUES ('$txtNom','$txtCue','$txtCorr','$txtImg')"
        val res = db.execSQL(sql)
         */

            //Alternativa 2 de insert
            val newReg = ContentValues()
            newReg.put("nombre", txtNom)
            newReg.put("cuenta", txtCue)
            newReg.put("correo", txtCorr)
            newReg.put("imagen", txtImg)

            if (idAlumno!=null){
                val campollave = "id=?"
                val res = db.update("alumnos",newReg,campollave, arrayOf(idAlumno.toString()))

                if (res.toInt() == -1) {
                    Toast.makeText(this, "Error al modificar", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Registro modificado con exito", Toast.LENGTH_LONG).show()
                    startActivity(intento2)
                }

            }else {

                //empujamos los valores anteriores a la base
                val res = db.insert("alumnos", null, newReg)

                if (res.toInt() == -1) {
                    Toast.makeText(this, "Error al insertar", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Registro insertado con exito", Toast.LENGTH_LONG).show()
                    startActivity(intento2)
                }
            }
        }

        /*
        //Variable para recibir los valores que vienen de otra activity "extras"
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
         */
    }
}