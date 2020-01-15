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
import com.example.popups.databinding.PostOptionsDialogBinding
import com.example.popups.viewModel.ViewModelPostOptionFactory
import com.example.popups.viewModel.ViewModelPostOptions


open class FragmentPostOptions : DialogFragment() {
    val TAG_POST_OPTIONS = "FragmentPostOptions"
    lateinit var viewModelPostOptions: ViewModelPostOptions
    private val frManager: FragmentManager? by lazy {
        activity?.supportFragmentManager
    }

    companion object {
        fun getInstance(): FragmentPostOptions {
            return FragmentPostOptions()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val factory =
            ViewModelPostOptionFactory(frManager!!)
        viewModelPostOptions =
            ViewModelProviders.of(this, factory).get(ViewModelPostOptions::class.java)
        val dataBinding: PostOptionsDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.post_options_dialog,
            null,
            false
        )
        val view = dataBinding.root
        dataBinding.lifecycleOwner = this
        dataBinding.viewModelPostOption = viewModelPostOptions

        val dialog = Dialog(activity!!, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        return dialog
    }
}


