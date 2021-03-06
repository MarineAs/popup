package com.example.popups.viewModel

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelPlaylistOptionsFactory(private val frManager: FragmentManager) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(FragmentManager::class.java).newInstance(frManager)
    }
}
