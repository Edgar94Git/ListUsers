package com.example.listusers

import android.app.Application
import com.example.listusers.common.database.UserAPI

class UserApplication: Application() {
    companion object{
        lateinit var userAPI: UserAPI
    }

    override fun onCreate() {
        super.onCreate()

        userAPI = UserAPI.getInstance(this)
    }
}