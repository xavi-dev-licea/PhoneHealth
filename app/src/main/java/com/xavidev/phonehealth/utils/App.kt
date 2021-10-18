package com.xavidev.phonehealth.utils

import android.app.Application
import android.content.Context

class App : Application() {

    var mcontext: Context? = null

    override fun onCreate() {
        super.onCreate()
        mcontext = this
    }

    fun getContext(): Context {
        return mcontext!!
    }
}