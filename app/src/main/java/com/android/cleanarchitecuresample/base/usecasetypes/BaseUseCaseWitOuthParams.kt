package com.android.cleanarchitecuresample.base.usecasetypes

import androidx.lifecycle.LiveData

interface BaseUseCaseWitOuthParams< R > {

    suspend fun run() : R

}