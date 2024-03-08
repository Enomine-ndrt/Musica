package com.example.musica.core

import com.example.musica.data.model.Music.artistas.Artistas
import com.example.musica.data.model.Music.Music
import com.example.musica.data.model.Music.albums.Albums
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicApi{
    @GET("genero/Read.php")
    fun getAllGeneres(): Call<Music>
    @GET("genero/ReadArtist.php?")
    fun getArtistFromGenres(@Query("id_generos") id_generos: Int): Call<Artistas>
    @GET("album/single_read.php?")
    fun getAlbumFromArtist(@Query("id_artista") id_artista: Int): Call<Albums>

}

object RetrofitInstance{
    val api : MusicApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://192.168.1.121:8080/music_share/php-rest-api/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MusicApi::class.java)
    }
}

