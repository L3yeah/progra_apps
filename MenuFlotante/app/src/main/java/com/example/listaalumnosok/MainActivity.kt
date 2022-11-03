package com.example.listaalumnosok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaalumnosok.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //Vincular las vistas con MainActivity
    private lateinit var binding: ActivityMainBinding
    // ArrayList of class ItemsViewModel
    val data = ArrayList<Alumno>()
    //This will pass the ArrayList to our Adapter
    private lateinit var adapter : AlumnoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Agregar elementos a la lista
        data.add(Alumno("Paulina","20207941","pau1@ucol.mx","https://static.wikia.nocookie.net/dannyelfantasma/images/5/5d/Paulina.jpg/revision/latest?cb=20120808163356&path-prefix=es"))
        data.add(Alumno("Danny","20207942","danny2@ucol.mx","https://siachenstudios.com/wp-content/uploads/2021/11/danny.jpg"))
        data.add(Alumno("Sam","20207943","sam3@ucol.mx","https://www.geekmi.news/__export/1662077738761/sites/debate/img/2022/09/01/sam.jpg_1606427789.jpg"))
        data.add(Alumno("Dash","20207944","dash4@ucol.mx","https://static.wikia.nocookie.net/dannyelfantasma/images/0/00/Dash_1.jpg/revision/latest/smart/width/250/height/250?cb=20130423022105&path-prefix=es"))
        data.add(Alumno("Tucker","20207945","tucker5@ucol.mx","https://img.sharetv.com/shows/characters/large/danny_phantom.tucker_foley.jpg"))


        // This will pass the ArrayList to our Adapter
        adapter = AlumnoAdapter(this,data)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : AlumnoAdapter.ClickListener{
            override fun onItemClick(view: View, position: Int) {
                //Toast.makeText(this@MainActivity,"Click en el item: ${position}",Toast.LENGTH_LONG).show()
                itemOptionsMenu(position)
            }
        })

        //Variable para recibir extras
        val parExtra = intent.extras
        val msje = parExtra?.getString("mensaje")
        val nombre = parExtra?.getString("nombre")
        val cuenta = parExtra?.getString("cuenta")
        val correo = parExtra?.getString("correo")
        val image = parExtra?.getString("image")

        if (msje=="nuevo"){
            val insertIndex: Int = data.count()
            data.add(insertIndex,
                Alumno(
                    "${nombre}",
                    "${cuenta}",
                    "${correo}",
                    "${image}"
                )
            )
            adapter.notifyItemInserted(insertIndex)
        }else if(msje=="editar"){

        }

        //Click en el faButton
        binding.faButton.setOnClickListener {
            val intento1 = Intent(this,MainActivityNuevo::class.java)
            //intento1.putExtra("valor1","Hola mundo")
            startActivity(intento1)
        }
    }

    private fun itemOptionsMenu(position: Int) {
        val popupMenu = PopupMenu(this,binding.recyclerview[position].findViewById(R.id.textViewOptions))
        popupMenu.inflate(R.menu.options_menu)
        //Para cambiarnos de activity
        val intento2 = Intent(this,MainActivityNuevo::class.java)
        //Implementar el click en el item
        popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.borrar -> {
                        val tmpAlum = data[position]
                        data.remove(tmpAlum)
                        adapter.notifyDataSetChanged()
                        return true
                    }
                    R.id.editar ->{
                        //Tomamos los datos del alumno, en la posición de la lista donde hicieron click
                        val nombre = data[position].nombre
                        val cuenta = data[position].cuenta
                        val correo = data[position].correo
                        val image = data[position].imagen
                        //En position tengo el indice del elemento en la lista
                        val idAlum: Int = position
                        intento2.putExtra("mensaje","edit")
                        intento2.putExtra("nombre","${nombre}")
                        intento2.putExtra("cuenta","${cuenta}")
                        intento2.putExtra("correo","${correo}")
                        intento2.putExtra("image","${image}")
                        //Pasamos por extras el idAlum para poder saber cual editar de la lista (ArrayList)
                        intento2.putExtra("idA",idAlum)
                        startActivity(intento2)
                        return true
                    }
                }
                return false
            }
        })
        popupMenu.show()
    }


}
