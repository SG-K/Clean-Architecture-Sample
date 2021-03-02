package com.android.cleanarchitecuresample.sample



import androidx.lifecycle.ViewModel
import com.android.cleanarchitecuresample.domain.Repository
import com.android.cleanarchitecuresample.domain.SimpleUseCaseTest
import javax.inject.Inject

class SampleViewmodel @Inject constructor(val simpleUseCaseTest: SimpleUseCaseTest) : ViewModel() {




}