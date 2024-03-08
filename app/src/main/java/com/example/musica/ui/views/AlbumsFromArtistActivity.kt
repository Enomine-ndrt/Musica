package com.example.musica.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musica.adapters.main.AlbumsFromArtistAdapter
import com.example.musica.adapters.main.DecorationAlbumArtistAdapter
import com.example.musica.databinding.ActivityAlbumsFromArtistBinding
import com.example.musica.databinding.ActivityArtistasBinding
import com.example.musica.ui.viewModel.AlbumArtistViewModel


class AlbumsFromArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumsFromArtistBinding
    private lateinit var viewModel: AlbumArtistViewModel
    private lateinit var AlbumAdapter: AlbumsFromArtistAdapter
    private lateinit var artistDecorationAdapter: DecorationAlbumArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        val id_artista = bundle?.getString("id_artista")
        binding = ActivityAlbumsFromArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        prepareRecyclerViewDecoration()
        viewModel = ViewModelProvider(this)[AlbumArtistViewModel::class.java]
        viewModel.getInfoAlbumsArtist(Integer.parseInt(id_artista))

        viewModel.observeAlbumArtistLiveData().observe(this,{albums->
            AlbumAdapter.setAlbumFromArtist(albums)
        })

        viewModel.observeArtistDecorationLiveData().observe(this,{artistList ->
            artistDecorationAdapter.setArtistDecorationList(artistList)
        })
    }

    fun prepareRecyclerView(){
        AlbumAdapter = AlbumsFromArtistAdapter(this)
        binding.rvAlbumsArtist.apply {
            layoutManager = GridLayoutManager(applicationContext,1,GridLayoutManager.VERTICAL,false)
            adapter = AlbumAdapter
        }
    }

    fun prepareRecyclerViewDecoration (){
        artistDecorationAdapter = DecorationAlbumArtistAdapter(this)
        binding.rvAlbumsDecorations.apply {
            layoutManager = GridLayoutManager(applicationContext,1,GridLayoutManager.VERTICAL,false)
            adapter =  artistDecorationAdapter
        }
    }
}