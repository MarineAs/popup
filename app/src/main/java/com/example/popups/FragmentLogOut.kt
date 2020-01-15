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
import com.example.popups.databinding.LogOutDialogBinding
import com.example.popups.viewModel.ViewModelLogOut
import com.example.popups.viewModel.ViewModelLogOutFactory

class FragmentLogOut : DialogFragment() {
    val TAG_LOG_OUT = "LogOut"
    lateinit var viewModelLogOut: ViewModelLogOut
    private val frManager: FragmentManager? by lazy {
        activity?.supportFragmentManager
    }

    companion object {
        fun getInstance(): FragmentLogOut {
            return FragmentLogOut()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val factory = ViewModelLogOutFactory(frManager!!)
        viewModelLogOut = ViewModelProviders.of(this, factory).get(ViewModelLogOut::class.java)
        val dataBinding: LogOutDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.log_out_dialog,
            null,
            false
        )
        val view = dataBinding.root
        dataBinding.lifecycleOwner = this
        dataBinding.viewModelLogOut = viewModelLogOut

        val dialog = Dialog(activity!!, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(view)
        return dialog
    }
}






