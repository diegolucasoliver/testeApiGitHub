package com.diego.testeapigithub.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.diego.testeapigithub.R
import com.diego.testeapigithub.model.Gist
import kotlinx.android.synthetic.main.activity_gist_details.*

class GistDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gist_details)

        tvUserNameDetail.text = intent.getStringExtra(EXTRA_USER)
        tvGistTypeDetail.text = intent.getStringExtra(EXTRA_TYPE)
        Glide
            .with(this)
            .load(intent.getStringExtra(EXTRA_AVATAR))
            .into(ivUserDetail)
    }

    companion object {
        private const val EXTRA_USER = "EXTRA USER"
        private const val EXTRA_AVATAR = "EXTRA AVATAR"
        private const val EXTRA_TYPE = "EXTRA TYPE"

        fun getStartIntent(context: Context, gist: Gist): Intent {
            return Intent(context, GistDetailsActivity::class.java).apply {
                putExtra(EXTRA_USER, gist.user)
                putExtra(EXTRA_AVATAR, gist.avatar)
                putExtra(EXTRA_TYPE, gist.type)
            }
        }
    }
}
