package com.android.cleanarchitecuresample.domain

import com.android.cleanarchitecuresample.base.usecasetypes.BaseUseCaseWitOuthParams
import javax.inject.Inject

class SimpleUseCaseTest @Inject constructor(val repository: Repository) :
    BaseUseCaseWitOuthParams<Boolean> {

    override suspend fun run(): Boolean {
        TODO()
    }

}