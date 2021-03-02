package com.android.cleanarchitecuresample.di

import com.android.cleanarchitecuresample.MainActivity
import com.android.cleanarchitecuresample.di.scopes.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}