package com.example.musica.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musica.core.RetrofitInstance
import com.example.musica.data.model.Music.artistas.Artistas
import com.example.musica.data.model.Music.artistas.BodyX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistaViewModel : ViewModel() {
    private var artistaLiveData = MutableLiveData<List<BodyX>>()

    fun generoArtista(id :Int){
        RetrofitInstance.api.getArtistFromGenres(id).enqueue(object: Callback<Artistas> {
            override fun onResponse(call: Call<Artistas>, response: Response<Artistas>) {
                if(response.body() != null){
                    artistaLiveData.value = response.body()!!.body
                  //  Log.d("TAG1",artistaLiveData.value.toString())
                }else{
                  //  Log.d("TAG1",response.body().toString())
                    return

                }
            }

            override fun onFailure(call: Call<Artistas>, t: Throwable) {
                Log.d("TAG1",t.message.toString())
            }
        })
    }

    fun observeArtistasLiveData(): LiveData<List<BodyX>> {
        return artistaLiveData
    }
}