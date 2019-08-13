package com.diego.testeapigithub.ui.view

import android.os.Bundle
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diego.testeapigithub.R
import com.diego.testeapigithub.model.Gist
import com.diego.testeapigithub.ui.adapter.GistListAdapter
import com.diego.testeapigithub.ui.viewmodel.GistListViewModel
import kotlinx.android.synthetic.main.activity_gist_list.*

class GistListActivity : AppCompatActivity() {

    lateinit var viewModel: GistListViewModel
    val list: MutableList<Gist> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gist_list)

        viewModel =
            ViewModelProviders.of(this).get(GistListViewModel::class.java)

        with(rvGistList) {
            layoutManager = LinearLayoutManager(
                this@GistListActivity, RecyclerView.VERTICAL, false
            )

            adapter = GistListAdapter(list) { gist ->
                val intent = GistDetailsActivity.getStartIntent(this@GistListActivity, gist)
                this@GistListActivity.startActivity(intent)
            }
        }

        viewModel.gistListLiveData.observe(this, Observer {
            it?.let { gists ->
                list.addAll(gists)
                rvGistList.adapter?.notifyDataSetChanged()
            }
        })

        rvGistList.viewTreeObserver.addOnScrollChangedListener(object : ViewTreeObserver.OnScrollChangedListener {
            override fun onScrollChanged() {
                var scrollBottom = endOfScroll(rvGistList)
                if (scrollBottom) {
                    viewModel.getNextPage()
                }
            }

        })

    }

    fun endOfScroll(recyclerView: RecyclerView): Boolean {
        val view = recyclerView.getChildAt(recyclerView.childCount - 1)
        val scrollBottom = (view.bottom - (recyclerView.height + recyclerView.scrollY))

        return scrollBottom == 0
    }

    override fun onResume() {
        super.onResume()
        viewModel.getGists()
    }


}
