package com.example.tarealistas

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListasAdapter(private val listas: List<Alumno>): RecyclerView.Adapter<ListasAdapter.ViewHolder> {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = listas.size{
        TODO("Not yet implemented")
    }

}