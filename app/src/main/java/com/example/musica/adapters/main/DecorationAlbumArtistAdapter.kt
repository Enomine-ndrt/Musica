package com.example.musica.adapters.main

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musica.data.model.Music.albums.Header
import com.example.musica.data.model.Music.artistas.BodyX
import com.example.musica.databinding.AlbumArtistaDecorationLayoutBinding
import com.example.musica.databinding.ArtistFromGenereBinding

class DecorationAlbumArtistAdapter(val context: Context) : RecyclerView.Adapter<DecorationAlbumArtistAdapter.ViewHolder>() {
    private var artistDecorationList = ArrayList<Header>()

    fun setArtistDecorationList(artistDecorationList: List<Header>){
        this.artistDecorationList = artistDecorationList as ArrayList<Header>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AlbumArtistaDecorationLayoutBinding) : RecyclerView.ViewHolder(binding.root){}



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DecorationAlbumArtistAdapter.ViewHolder {
        return ViewHolder(
            AlbumArtistaDecorationLayoutBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return artistDecorationList.size
    }

    override fun onBindViewHolder(holder: DecorationAlbumArtistAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(artistDecorationList[position].banner)
            .into(holder.binding.ImageArtistDetail)

        Glide.with(holder.itemView)
            .load(artistDecorationList[position].avatar)
            .into(holder.binding.avatarArtist)

        var color = "#0000"
            color = artistDecorationList[position].colorBanner
        if(color.isNullOrEmpty()){
            holder.binding.backgroundDecoration.setBackgroundColor(Color.parseColor(color))
        }
    }


}