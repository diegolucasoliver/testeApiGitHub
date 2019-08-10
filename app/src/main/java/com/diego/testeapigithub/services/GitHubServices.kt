package com.diego.testeapigithub.services

import com.diego.testeapigithub.response.GistBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubServices {

    @GET("/gists/public")
    fun getGistList(
        @Query("since") since: String = "2019-08-10T16:47:00Z"
    ): Call<List<GistBodyResponse>>
}