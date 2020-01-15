package com.example.popups

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPostOptions.setOnClickListener(this)
        btnPlayList.setOnClickListener(this)
        btnPlayListKeep.setOnClickListener(this)
        btnLogOut.setOnClickListener(this)
        vivaCell.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPostOptions -> {
                FragmentPostOptions.getInstance().show(
                    supportFragmentManager,
                    FragmentPostOptions.getInstance().TAG_POST_OPTIONS
                )

            }
            R.id.btnPlayList -> {
                FragmentPlaylistOptions.getInstance().show(
                    supportFragmentManager,
                    FragmentPlaylistOptions.getInstance().TAG_PLAYLIST_OPTIONS
                )
            }
            R.id.btnPlayListKeep -> {
                FragmentPlaylistKeepChanges.getInstance().show(
                    supportFragmentManager,
                    FragmentPlaylistKeepChanges.getInstance().TAG_PLAYLIST_KEEP_CHANGES
                )
            }
            R.id.btnLogOut -> {
                FragmentLogOut.getInstance()
                    .show(supportFragmentManager, FragmentLogOut.getInstance().TAG_LOG_OUT)
            }
            R.id.vivaCell -> {

            }
        }
    }


}
