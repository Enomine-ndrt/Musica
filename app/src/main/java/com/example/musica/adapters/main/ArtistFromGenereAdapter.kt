package com.example.musica.adapters.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musica.data.model.Music.artistas.BodyX
import com.example.musica.databinding.ArtistFromGenereBinding
import com.example.musica.ui.views.AlbumsFromArtistActivity

class ArtistFromGenereAdapter(val context: Context): RecyclerView.Adapter<ArtistFromGenereAdapter.ViewHolder>() {

    private var artistFromGenereList = ArrayList<BodyX>()

    fun setArtistFromGenere(artistFromGenereList: List<BodyX>){
        this.artistFromGenereList = artistFromGenereList as ArrayList<BodyX>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ArtistFromGenereBinding):RecyclerView.ViewHolder(binding.root){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistFromGenereAdapter.ViewHolder {
      return ViewHolder(
          ArtistFromGenereBinding.inflate(
              LayoutInflater.from(parent.context)
          )
      )
    }

    override fun getItemCount(): Int {
        return artistFromGenereList.size
    }

    override fun onBindViewHolder(holder: ArtistFromGenereAdapter.ViewHolder, position: Int) {
                Glide.with(holder.itemView)
                    .load(artistFromGenereList[position].imagen_artista)
                    .into(holder.binding.artistaImageDetail)
                    holder.binding.artistName.text = artistFromGenereList[position].nombre_artista

                    val id = artistFromGenereList[position].id_artista.toString()
                    val intent = Intent(context,AlbumsFromArtistActivity::class.java)

                    holder.binding.artistaImageDetail.setOnClickListener(View.OnClickListener {
                            intent.putExtra("id_artista",id)
                            context.startActivity(intent)
                       // Log.d("TAG1",id)
                    })
    }

}