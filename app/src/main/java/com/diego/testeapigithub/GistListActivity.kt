package com.diego.testeapigithub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_gist_list.*

class GistListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gist_list)
        setUpAdapter()
    }

    fun setUpAdapter() {
        with(rvGistList) {
            layoutManager = LinearLayoutManager(
                this@GistListActivity, RecyclerView.VERTICAL, false
            )
            adapter = GistListAdapter(getList())
        }
    }

    fun getList(): List<Gist> {
        return listOf(
            Gist(
                "Diego",
                "android",
                "https://avatars0.githubusercontent.com/u/33063030?s=400&u=7fdd634a18923d7f527a41973e950e46eed18e63&v=4"
            ),
            Gist("Bruna", "front", "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png"),
            Gist("Julia", "design", "https://homepages.cae.wisc.edu/~ece533/images/barbara.png"),
            Gist("Eduardo", "back", "https://homepages.cae.wisc.edu/~ece533/images/boat.png")
        )
    }
}
