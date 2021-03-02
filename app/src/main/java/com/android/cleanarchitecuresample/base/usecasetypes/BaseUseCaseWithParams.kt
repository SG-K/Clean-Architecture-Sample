package com.android.cleanarchitecuresample.base.usecasetypes

import androidx.lifecycle.LiveData

interface BaseUseCaseWithParams< P, R > {

    suspend fun run(params : P) : R

}
