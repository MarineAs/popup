package com.example.popups.viewModel

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.popups.FragmentPostOptions

class ViewModelPostOptions(private val fragmentManager: FragmentManager) : ViewModel() {

    fun copyLink() {
        Log.d("111", "Copy Link ")
    }

    fun turnNotification() {
        Log.d("111", "Turn on post notification")
    }

    fun shareLink() {
        Log.d("111", "Share link")
    }

    fun mute() {
        Log.d("111", "Mute")
    }

    fun report() {
        Log.d("111", "Report")
    }

    fun closeDialog() {
        fragmentManager.findFragmentByTag(FragmentPostOptions.getInstance().TAG_POST_OPTIONS)?.let {
            (it as DialogFragment).dismiss()
        }
    }
}