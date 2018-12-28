package com.jaede.moviesontips.api

/**
 * Created by jyotidubey on 28/12/18.
 */
interface ApiResponseCallback<in T>{
    fun onSuccess(responseCallback: T)
    fun onError(error:Throwable)
}