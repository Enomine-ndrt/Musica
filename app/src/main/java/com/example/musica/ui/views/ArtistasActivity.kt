package com.example.musica.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musica.adapters.main.ArtistFromGenereAdapter
import com.example.musica.databinding.ActivityArtistasBinding
import com.example.musica.ui.viewModel.ArtistaViewModel

class ArtistasActivity : AppCompatActivity() {
    private lateinit var artistasBinding: ActivityArtistasBinding
    private lateinit var viewModel: ArtistaViewModel
    private lateinit var artistFromGenereAdapter: ArtistFromGenereAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_artistas)
        val bundle = intent.extras
        val id_genero = bundle?.getString("id_genero")
       // Log.d("TAG1",id_genero.toString())
        artistasBinding = ActivityArtistasBinding.inflate(layoutInflater)
        setContentView(artistasBinding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[ArtistaViewModel::class.java]
        viewModel.generoArtista(Integer.parseInt(id_genero))

        viewModel.observeArtistasLiveData().observe(this,{artistList ->
           artistFromGenereAdapter.setArtistFromGenere(artistList)
        })

    }

    fun  prepareRecyclerView(){
        artistFromGenereAdapter = ArtistFromGenereAdapter(this)
        artistasBinding.rvFromGenere.apply {
            layoutManager = GridLayoutManager(applicationContext,1,GridLayoutManager.VERTICAL,false)
            adapter = artistFromGenereAdapter
        }
    }


}