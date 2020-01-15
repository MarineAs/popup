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
import com.example.popups.databinding.PlaylistKeepChangesDialogBinding
import com.example.popups.viewModel.ViewModelPlaylistKeepChanges
import com.example.popups.viewModel.ViewModelPlaylistKeepChangesFactory

class FragmentPlaylistKeepChanges : DialogFragment() {
    val TAG_PLAYLIST_KEEP_CHANGES = "PlaylistKeepChanges"
    lateinit var viewModelPlaylistKeepChanges: ViewModelPlaylistKeepChanges
    private val frManager: FragmentManager? by lazy {
        activity?.supportFragmentManager
    }

    companion object {
        fun getInstance(): FragmentPlaylistKeepChanges {
            return FragmentPlaylistKeepChanges()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val factory = ViewModelPlaylistKeepChangesFactory(frManager!!)
        viewModelPlaylistKeepChanges =
            ViewModelProviders.of(this, factory).get(ViewModelPlaylistKeepChanges::class.java)
        val dataBinding: PlaylistKeepChangesDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.playlist_keep_changes_dialog,
            null,
            false
        )
        val view = dataBinding.root
        dataBinding.lifecycleOwner = this
        dataBinding.viewModelplaylistKeepChanges = viewModelPlaylistKeepChanges

        val dialog=Dialog(activity!!,android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        return dialog
    }

}
