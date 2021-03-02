package com.android.cleanarchitecuresample.domain.usecases

import androidx.lifecycle.LiveData
import com.android.cleanarchitecuresample.base.usecasetypes.BaseUseCaseWitOuthParams
import com.android.cleanarchitecuresample.domain.Repository
import javax.inject.Inject

class SimpleUseCaseTest @Inject constructor( val repository: Repository) :
    BaseUseCaseWitOuthParams<Boolean> {

    override suspend fun run(): Boolean {
        TODO()
    }

}