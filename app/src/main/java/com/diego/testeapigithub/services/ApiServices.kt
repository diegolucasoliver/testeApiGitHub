package com.diego.testeapigithub.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServices {

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service = initRetrofit().create(GitHubServices::class.java)
}