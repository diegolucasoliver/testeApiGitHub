package com.diego.testeapigithub.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diego.testeapigithub.R
import com.diego.testeapigithub.model.Gist
import kotlinx.android.synthetic.main.item_list.view.*

class GistListAdapter(
    val gistList: List<Gist>
) : RecyclerView.Adapter<GistListAdapter.GistListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return GistListViewHolder(view)
    }

    override fun getItemCount() = gistList.count()

    override fun onBindViewHolder(holder: GistListViewHolder, position: Int) {
        holder.bindView(gistList[position])
    }

    class GistListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val user = itemView.tvUserName
        private val type = itemView.tvGistType
        private val avatar = itemView.ivUser

        fun bindView(gist: Gist) {
            user.text = gist.user
            type.text = gist.type
            Glide
                .with(itemView.context)
                .load(gist.avatar)
                .fitCenter()
                .into(avatar)
        }
    }
}