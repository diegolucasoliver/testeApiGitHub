package com.diego.testeapigithub.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diego.testeapigithub.model.Gist
import com.diego.testeapigithub.response.FilesResponse
import com.diego.testeapigithub.response.GistBodyResponse
import com.diego.testeapigithub.services.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GistListViewModel : ViewModel() {

    val gistListLiveData: MutableLiveData<List<Gist>> = MutableLiveData()

    fun getGists() {
        ApiServices.service.getGistList()
            .enqueue(object : Callback<List<GistBodyResponse>> {
                override fun onFailure(call: Call<List<GistBodyResponse>>, t: Throwable) {
                    Log.e("onFailure", t.message)
                }

                override fun onResponse(
                    call: Call<List<GistBodyResponse>>,
                    response: Response<List<GistBodyResponse>>
                ) {
                    if (response.isSuccessful) {
                        val gistList: MutableList<Gist> = mutableListOf()

                        response.body()?.let { gists ->
                            for (results in gists.indices) {
                                var type = setUpTypes(gists[results].files)
                                val gist = Gist(
                                    user = gists[results].owner.login,
                                    avatar = gists[results].owner.avatar_url,
                                    type = setUpString(type.toString()),
                                    link = gists[results].owner.html_url
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

    fun setUpTypes(types: Map<String, FilesResponse>): MutableSet<String> {
        var entries = types.keys
        var setOf = mutableSetOf<String>()

        for (result in entries) {
            setOf.add(types.get(result).toString())
        }

        return setOf
    }

    private fun setUpString(value: String): String {
        var valueReplacement = value.replace("FilesResponse(type=", "")
        valueReplacement = valueReplacement.replace(")", "")
        valueReplacement = valueReplacement.replace("[", "")
        valueReplacement = valueReplacement.replace("]", "")

        return valueReplacement
    }
}