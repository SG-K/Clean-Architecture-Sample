package com.android.cleanarchitecuresample.di

import com.android.cleanarchitecuresample.data.RepositoryImpl
import com.android.cleanarchitecuresample.domain.Repository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImpl: RepositoryImpl) : Repository

}