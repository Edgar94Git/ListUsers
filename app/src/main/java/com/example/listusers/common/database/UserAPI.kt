package com.example.listusers.common.database

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

class UserAPI(context: Context) {
    companion object{
        @Volatile
        private var INSTANCE: UserAPI? = null
        fun getInstance(context: Context) = INSTANCE?: synchronized(this){
            INSTANCE?: UserAPI(context).also{ INSTANCE = it }
        }
    }

    private val requestQueue: RequestQueue by lazy{
        Volley.newRequestQueue(context.applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>){
        requestQueue.add(req)
    }
}