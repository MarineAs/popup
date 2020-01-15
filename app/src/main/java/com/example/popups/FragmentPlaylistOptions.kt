package com.example.popups

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.example.popups.databinding.PlaylistOptionsDialogBinding
import com.example.popups.viewModel.ViewModelPlaylistOptions
import com.example.popups.viewModel.ViewModelPlaylistOptionsFactory


class FragmentPlaylistOptions : DialogFragment() {
    val TAG_PLAYLIST_OPTIONS = "FragmentPlaylistOptions"
    lateinit var viewModelPlaylistOptions: ViewModelPlaylistOptions
    private val frManager: FragmentManager? by lazy {
        activity?.supportFragmentManager
    }

    companion object {
        fun getInstance(): FragmentPlaylistOptions {
            return FragmentPlaylistOptions()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val factory =
            ViewModelPlaylistOptionsFactory(frManager!!)
        viewModelPlaylistOptions =
            ViewModelProviders.of(this, factory).get(ViewModelPlaylistOptions::class.java)
        val dataBinding: PlaylistOptionsDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.playlist_options_dialog,
            null,
            false
        )
        val view = dataBinding.root
        dataBinding.lifecycleOwner = this
        dataBinding.viewModelPlaylistOption = viewModelPlaylistOptions

        val dialog = Dialog(activity!!, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        return dialog
    }
}