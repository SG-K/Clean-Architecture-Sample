package com.android.cleanarchitecuresample.data

import com.android.cleanarchitecuresample.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val sampleApiService: SampleApiService) : Repository {

}