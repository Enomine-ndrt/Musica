package com.example.musica.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musica.core.RetrofitInstance
import com.example.musica.data.model.Music.albums.Albums
import com.example.musica.data.model.Music.albums.Body
import com.example.musica.data.model.Music.albums.Header
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AlbumArtistViewModel: ViewModel() {
    private var artistaAlbumsLiveData = MutableLiveData<List<Body>>()
    private var artistaDecorationLiveData = MutableLiveData<List<Header>>()

    fun getInfoAlbumsArtist(id: Int){
        RetrofitInstance.api.getAlbumFromArtist(id).enqueue(object: Callback<Albums>{
            override fun onResponse(call: Call<Albums>, response: Response<Albums>) {
                if(response.body() != null){
                    artistaAlbumsLiveData.value = response.body()!!.body
                    artistaDecorationLiveData.value = response.body()!!.header
                    // Log.d("RES1",artistaAlbumsLiveData.value.toString())
                    //Log.d("RES1",artistaDecorationLiveData.value.toString())
                }else{
                    // Log.d("TAG1",response.body().toString())
                    return

                }
            }

            override fun onFailure(call: Call<Albums>, t: Throwable) {
                Log.d("TAG1",t.message.toString())
            }

        })
    }

    fun observeAlbumArtistLiveData(): LiveData<List<Body>> {
        return artistaAlbumsLiveData
    }

    fun observeArtistDecorationLiveData(): LiveData<List<Header>>{
        return artistaDecorationLiveData
    }
}