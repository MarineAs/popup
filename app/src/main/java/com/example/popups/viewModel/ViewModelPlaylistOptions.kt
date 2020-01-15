package com.example.popups.viewModel

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.popups.FragmentPlaylistOptions

class ViewModelPlaylistOptions(private val frManager: FragmentManager) : ViewModel() {
    fun copyLink() {
        Log.d("111", "Copy Link ")
    }

    fun shareOnWall() {
        Log.d("111", "Turn on post notification")
    }

    fun shareLinkVia() {
        Log.d("111", "Share link")
    }

    fun invite() {
        Log.d("111", "Mute")
    }

    fun report() {
        Log.d("111", "Report")
    }

    fun shareToFacebook() {
        Log.d("111", "Share facebook")
    }

    fun shareToVK() {
        Log.d("111", "Share twitter")
    }

    fun shareToTwitter() {
        Log.d("111", "Share twitter")
    }

    fun shareToLinkedin() {
        Log.d("111", "Share twitter")
    }

    fun closeDialog() {
        frManager.findFragmentByTag(FragmentPlaylistOptions.getInstance().TAG_PLAYLIST_OPTIONS)
            ?.let {
                (it as DialogFragment).dismiss()
            }
    }
}
