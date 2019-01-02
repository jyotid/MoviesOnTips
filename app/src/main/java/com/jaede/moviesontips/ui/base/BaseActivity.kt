package com.jaede.moviesontips.ui.base

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by jyotidubey on 02/01/19.
 */
open class BaseActivity : AppCompatActivity(){
    private val factory = BaseViewModel.ViewModelProviderFactory()
    private lateinit var viewModel : BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this,factory).get(BaseViewModel::class.java)
        viewModel.errorState.observe(this, Observer {
            Toast.makeText(this,it?.message,Toast.LENGTH_LONG).show()
        })


    }
}