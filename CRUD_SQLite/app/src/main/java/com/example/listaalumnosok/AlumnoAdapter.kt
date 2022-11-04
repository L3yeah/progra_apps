package com.example.listaalumnosok

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnoAdapter(private val context: Context, val listAlumno: List<Alumno>) : RecyclerView.Adapter<AlumnoAdapter.ViewHolder>() {
    private var clickListener: ClickListener? = null

    interface ClickListener {
        fun onItemClick(view: View,position: Int)
    }

    //create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflates the card_view_design view
        //that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    //binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = listAlumno[position]
        // sets the image to the imageview from our itemHolder class
        //holder.imageView.setImageResource(ItemsViewModel.imagen)
        Glide.with(context).load(ItemsViewModel.imagen).into(holder.imagenAlumno)

        // sets the text to the textview from our itemHolder class
        holder.txtNombre.text = ItemsViewModel.nombre
        holder.txtCuenta.text = ItemsViewModel.cuenta
    }

    override fun getItemCount(): Int {
        return listAlumno.size
    }

    fun setOnItemClickListener(clickListener: ClickListener){
        this.clickListener = clickListener
    }

    //Holds the views for adding it to image and text
    inner class ViewHolder(itView: View) : RecyclerView.ViewHolder(itView), View.OnClickListener {
        val imagenAlumno: ImageView = itemView.findViewById(R.id.imgAlumno)
        val txtNombre: TextView = itemView.findViewById(R.id.nombre)
        val txtCuenta: TextView = itemView.findViewById(R.id.cuenta)

        init {
            if (clickListener != null){
                itemView.setOnClickListener(this)
            }
        }

        override fun onClick(itView: View){
            if (itView != null){
                clickListener?.onItemClick(itView, bindingAdapterPosition)
            }
        }

    }

}


