package com.example.listaalumnosok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Alumno>()

        // Agregar elementos a la lista

        data.add(Alumno("Paulina","20207941","pau1@ucol.mx","https://static.wikia.nocookie.net/dannyelfantasma/images/5/5d/Paulina.jpg/revision/latest?cb=20120808163356&path-prefix=es"))
        data.add(Alumno("Danny","20207942","danny2@ucol.mx","https://siachenstudios.com/wp-content/uploads/2021/11/danny.jpg"))
        data.add(Alumno("Sam","20207943","sam3@ucol.mx","https://www.geekmi.news/__export/1662077738761/sites/debate/img/2022/09/01/sam.jpg_1606427789.jpg"))
        data.add(Alumno("Dash","20207944","dash4@ucol.mx","https://static.wikia.nocookie.net/dannyelfantasma/images/0/00/Dash_1.jpg/revision/latest/smart/width/250/height/250?cb=20130423022105&path-prefix=es"))
        data.add(Alumno("Tucker","20207945","tucker5@ucol.mx","https://img.sharetv.com/shows/characters/large/danny_phantom.tucker_foley.jpg"))


        // This will pass the ArrayList to our Adapter
        val adapter = AlumnoAdapter(this,data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}