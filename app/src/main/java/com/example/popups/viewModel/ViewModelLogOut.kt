package com.example.popups.viewModel

import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.example.popups.FragmentLogOut


class ViewModelLogOut(private val fragManager:FragmentManager):ViewModel(){
    fun logOut(){
        Log.d("111"," Log out")
    }
    fun goBack(){
        Log.d("111"," Go back")
    }
    fun closeDialog() {
        fragManager.findFragmentByTag(FragmentLogOut.getInstance().TAG_LOG_OUT)
            ?.let {
                (it as DialogFragment).dismiss()
            }
    }
}