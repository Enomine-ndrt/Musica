package com.example.musica.ui.views

import android.annotation.SuppressLint
import android.app.Instrumentation.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

import com.example.musica.R
import com.example.musica.adapters.main.GenereAdapter
import com.example.musica.databinding.ActivityMainBinding
import com.example.musica.ui.viewModel.GeneroViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : GeneroViewModel
    private lateinit var genereAdapter: GenereAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[GeneroViewModel::class.java]
        viewModel.getMusic()
            viewModel.observeMusicLiveData().observe(this,{genereList ->
                genereAdapter.setMusicGenere(genereList)
            })

   }

    private fun prepareRecyclerView() {
        genereAdapter = GenereAdapter(this)
        binding.rvMusicGenero.apply {
            layoutManager = GridLayoutManager(applicationContext,1,GridLayoutManager.VERTICAL,false)
            adapter = genereAdapter
        }
    }
}