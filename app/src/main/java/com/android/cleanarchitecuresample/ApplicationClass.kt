package com.android.cleanarchitecuresample

import android.app.Application
import com.android.cleanarchitecuresample.di.AppComponent
import com.android.cleanarchitecuresample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class ApplicationClass : DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }

}