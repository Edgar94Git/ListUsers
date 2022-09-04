package com.example.listusers.mainModule.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.listusers.common.entities.User
import com.example.listusers.mainModule.model.MainInteractor

class MainViewModel: ViewModel() {
    private var interactor: MainInteractor = MainInteractor()
    private var userList: MutableList<User> = mutableListOf()

    private val users: MutableLiveData<MutableList<User>> by lazy {
        MutableLiveData<MutableList<User>>().also {
            loadUsers()
        }
    }

    private fun loadUsers() {
        interactor.getUsers {
            users.value = it
            userList = it
        }
    }

    fun getUsers(): LiveData<MutableList<User>> {
        return users
    }

}