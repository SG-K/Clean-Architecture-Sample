package com.android.cleanarchitecuresample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.cleanarchitecuresample.di.viewmodel.ViewModelFactory
import com.android.cleanarchitecuresample.sample.SampleViewmodel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewmodel = ViewModelProvider(this, viewModelFactory).get(SampleViewmodel::class.java)


    }

}