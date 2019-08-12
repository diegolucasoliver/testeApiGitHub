package com.diego.testeapigithub.services

import com.diego.testeapigithub.response.GistBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GitHubServices {

    @Headers("user-agent: request")
    @GET("/gists/public")
    fun getGistList(
        @Query("page") page: Int = 0,
        @Query("per_page") perPage: Int = 50
    ): Call<List<GistBodyResponse>>
}