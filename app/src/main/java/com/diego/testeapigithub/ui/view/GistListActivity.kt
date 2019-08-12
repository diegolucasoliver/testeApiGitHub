package com.diego.testeapigithub.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diego.testeapigithub.R
import com.diego.testeapigithub.ui.adapter.GistListAdapter
import com.diego.testeapigithub.ui.viewmodel.GistListViewModel
import kotlinx.android.synthetic.main.activity_gist_list.*

class GistListActivity : AppCompatActivity() {

    lateinit var viewModel: GistListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gist_list)

        viewModel =
            ViewModelProviders.of(this).get(GistListViewModel::class.java)
        viewModel.gistListLiveData.observe(this, Observer {
            it?.let { gists ->
                with(rvGistList) {
                    layoutManager = LinearLayoutManager(
                        this@GistListActivity, RecyclerView.VERTICAL, false
                    )
                    adapter = GistListAdapter(gists) { gist ->
                        val intent = GistDetailsActivity.getStartIntent(this@GistListActivity, gist)
                        this@GistListActivity.startActivity(intent)
                    }
                }
            }
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.getGists()
    }


}
