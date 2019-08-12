package com.diego.testeapigithub.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diego.testeapigithub.GistDB

class GistDetailsViewModel() : ViewModel() {

    val gistDetailsLiveData: MutableLiveData<List<GistDB>> = MutableLiveData()

    fun saveFavorite() {
    }
}