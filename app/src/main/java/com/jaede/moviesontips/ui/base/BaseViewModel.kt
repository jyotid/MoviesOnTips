package com.jaede.moviesontips.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jaede.moviesontips.data.model.ApiError


/**
 * Created by jyotidubey on 02/01/19.
 */
open class BaseViewModel : ViewModel(){

    val errorState = MutableLiveData<ApiError>()

    class ViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BaseViewModel::class.java)) {
                return BaseViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}