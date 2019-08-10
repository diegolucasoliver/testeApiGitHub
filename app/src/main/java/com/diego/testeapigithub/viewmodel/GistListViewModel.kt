package com.diego.testeapigithub.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diego.testeapigithub.model.Gist
import com.diego.testeapigithub.response.GistBodyResponse
import com.diego.testeapigithub.services.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GistListViewModel : ViewModel() {

    val gistListLiveData: MutableLiveData<List<Gist>> = MutableLiveData()

    fun getGists() {
        ApiServices.service.getGistList().enqueue(object : Callback<List<GistBodyResponse>> {
            override fun onFailure(call: Call<List<GistBodyResponse>>, t: Throwable) {
                Log.e("onFailure", t.message)
            }

            override fun onResponse(call: Call<List<GistBodyResponse>>, response: Response<List<GistBodyResponse>>) {
                if (response.isSuccessful) {
                    val gistList: MutableList<Gist> = mutableListOf()

                    response.body()?.let {
                        for (results in it.indices) {
                            val gist = Gist(
                                user = it[results].owner.login,
                                avatar = it[results].owner.avatar_url
                            )
                            gistList.add(gist)
                        }
                    }

                    gistListLiveData.value = gistList
                }

                Log.e("onResponse", response.raw().toString())
            }
        })
    }
}