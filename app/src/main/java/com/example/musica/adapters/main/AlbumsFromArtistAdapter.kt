package com.example.musica.adapters.main

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.layout.Layout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musica.data.model.Music.albums.Body
import com.example.musica.databinding.AlbumsArtistLayoutBinding

class AlbumsFromArtistAdapter(val context: Context): RecyclerView.Adapter<AlbumsFromArtistAdapter.ViewHolder>() {

    private var albumsFromArtistList = ArrayList<Body>()

    fun setAlbumFromArtist(albumsFromArtistList: List<Body>){
        this.albumsFromArtistList = albumsFromArtistList as ArrayList<Body>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: AlbumsArtistLayoutBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsFromArtistAdapter.ViewHolder {
      return ViewHolder(
          AlbumsArtistLayoutBinding.inflate(
              LayoutInflater.from(parent.context)
          )
      )
    }

    override fun getItemCount(): Int {
        return albumsFromArtistList.size
    }

    override fun onBindViewHolder(holder: AlbumsFromArtistAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(albumsFromArtistList[position].imagen_album)
            .into(holder.binding.albumImageDetail)
        holder.binding.albumName.text = albumsFromArtistList[position].nombre_album
        Log.d("nombre",albumsFromArtistList[position].nombre_album.toString())
    }
}