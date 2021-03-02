package com.android.cleanarchitecuresample.base.usecasetypes


interface BaseUseCaseWithParams< P, R > {

    suspend fun run(params : P) : R

}