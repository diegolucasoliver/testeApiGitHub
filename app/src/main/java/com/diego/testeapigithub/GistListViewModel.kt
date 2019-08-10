package com.diego.testeapigithub

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diego.testeapigithub.model.Gist

class GistListViewModel : ViewModel() {

    val gistListLiveData: MutableLiveData<List<Gist>> = MutableLiveData()

    fun getGists() {
        gistListLiveData.value = createFakeGists()
    }

    fun createFakeGists(): List<Gist> {
        return listOf(
            Gist(
                "Diego",
                "android",
                "https://avatars0.githubusercontent.com/u/33063030?s=400&u=7fdd634a18923d7f527a41973e950e46eed18e63&v=4"
            ),
            Gist(
                "Bruna",
                "front",
                "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"
            ),
            Gist(
                "Julia",
                "design",
                "https://homepages.cae.wisc.edu/~ece533/images/barbara.png"
            ),
            Gist(
                "Eduardo",
                "back",
                "https://homepages.cae.wisc.edu/~ece533/images/boat.png"
            )
        )
    }
}