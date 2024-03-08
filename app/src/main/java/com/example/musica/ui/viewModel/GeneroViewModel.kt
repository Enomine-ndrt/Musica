package com.example.musica.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musica.core.RetrofitInstance
import com.example.musica.data.model.Music.Body
import com.example.musica.data.model.Music.Music
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GeneroViewModel : ViewModel() {
    private var musicLiveData = MutableLiveData<List<Body>>()
    val isLoading = MutableLiveData<Boolean>()

    fun getMusic(){
        isLoading.postValue(true)
        RetrofitInstance.api.getAllGeneres().enqueue(object: Callback<Music>{
            override fun onResponse(call: Call<Music>, response: Response<Music>) {
                if(response.body() != null){
                    musicLiveData.value = response.body()!!.body
                  //  Log.d("TAG1",musicLiveData.value.toString())
                    isLoading.postValue(false)
                }else{
                   Log.d("TAG2",response.body().toString())
                    return
                }
            }

            override fun onFailure(call: Call<Music>, t: Throwable) {
                    Log.d("TAG2",t.message.toString())
            }

        })
    }

    fun observeMusicLiveData() :LiveData<List<Body>>{
        return musicLiveData
    }
}