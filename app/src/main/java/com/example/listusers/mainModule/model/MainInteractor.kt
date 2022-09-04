package com.example.listusers.mainModule.model

import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.example.listusers.UserApplication
import com.example.listusers.common.Utils.Constants
import com.example.listusers.common.entities.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainInteractor {
    fun getUsers(callback: (MutableList<User>) -> Unit){
        val url = Constants.STORES_URL + Constants.GET_ALL_PATH
        var usersList = mutableListOf<User>()
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            val jsonList = response.optJSONArray(Constants.DATA_PROPERTY)?.toString()
            if(jsonList != null){
                val mutableListType = object : TypeToken<MutableList<User>>(){}.type
                usersList = Gson().fromJson(jsonList, mutableListType)
            }
            callback(usersList)
        }, {
            it.printStackTrace()
            callback(usersList)
        })

        UserApplication.userAPI.addToRequestQueue(jsonObjectRequest)
    }
}