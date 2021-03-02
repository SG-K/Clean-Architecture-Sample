package com.android.cleanarchitecuresample.di.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.cleanarchitecuresample.sample.SampleViewmodel
import java.lang.IllegalStateException

class ViewModelFactory constructor(val sampleViewmodel: SampleViewmodel): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        if(modelClass == SampleViewmodel::class.java){
            sampleViewmodel as T
        }else{
            throw  IllegalStateException("Unknown entity")
        }
}