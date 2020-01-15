package com.example.popups.viewModel

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.popups.FragmentPlaylistKeepChanges

class ViewModelPlaylistKeepChanges(private val fragManager: FragmentManager) : ViewModel() {

    fun discard() {
        Log.d("111", "Discard  ")
    }

    fun backToPost() {
        Log.d("111", "Back to post ")
    }

    fun closeDialog() {
        fragManager.findFragmentByTag(FragmentPlaylistKeepChanges.getInstance().TAG_PLAYLIST_KEEP_CHANGES)
            ?.let {
                (it as DialogFragment).dismiss()
            }
    }
}