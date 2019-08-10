package com.diego.testeapigithub.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diego.testeapigithub.R
import com.diego.testeapigithub.adapter.GistListAdapter
import com.diego.testeapigithub.viewmodel.GistListViewModel
import kotlinx.android.synthetic.main.activity_gist_list.*

class GistListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gist_list)

        val viewModel: GistListViewModel =
            ViewModelProviders.of(this).get(GistListViewModel::class.java)

        viewModel.gistListLiveData.observe(this, Observer {
            it?.let { gists ->
                with(rvGistList) {
                    layoutManager = LinearLayoutManager(
                        this@GistListActivity, RecyclerView.VERTICAL, false
                    )
                    adapter = GistListAdapter(gists)
                }
            }
        })

        viewModel.getGists()
    }
}
