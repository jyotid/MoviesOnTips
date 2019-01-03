package com.jaede.moviesontips.data.api

import com.jaede.moviesontips.data.model.ApiError

/**
 * Created by jyotidubey on 28/12/18.
 */
interface ApiResponseCallback<in T>{
    fun onSuccess(responseCallback: T)
    fun onError(error: ApiError)
}