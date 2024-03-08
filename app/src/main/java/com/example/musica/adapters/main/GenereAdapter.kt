package com.example.musica.adapters.main

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musica.adapters.main.GenereAdapter.*
import com.example.musica.data.model.Music.Body
import com.example.musica.databinding.ActivityMainBinding
import com.example.musica.databinding.GeneroLayoutBinding
import com.example.musica.ui.views.ArtistasActivity

//import com.example.musica.databinding.ActivityArtistasBinding

class GenereAdapter(val context: Context) :RecyclerView.Adapter<GenereAdapter.ViewHolder>() {
    private var genereList = ArrayList<Body>()

    fun setMusicGenere(genereList: List<Body>){
        this.genereList = genereList as ArrayList<Body>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: GeneroLayoutBinding):RecyclerView.ViewHolder(binding.root) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GeneroLayoutBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return genereList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.tituloGenero.text = genereList[position].genero
        if(genereList[position].color.isEmpty()){
            holder.binding.background.setBackgroundColor(Color.parseColor(genereList[position].color))
        }

        val id = genereList[position].id_generos.toString()
        holder.binding.background.setOnClickListener(View.OnClickListener {
           // Log.d("TAG1", genero)
            val intent = Intent(context,ArtistasActivity::class.java)
            intent.putExtra("id_genero",id)
            context.startActivity(intent)
        })
    }

}