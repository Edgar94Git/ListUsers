package com.example.listusers.mainModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listusers.R
import com.example.listusers.common.entities.User
import com.example.listusers.databinding.ActivityMainBinding
import com.example.listusers.databinding.ItemUserBinding
import com.example.listusers.mainModule.adapter.OnClickListener
import com.example.listusers.mainModule.adapter.UserAdapter
import com.example.listusers.mainModule.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var mAdapter: UserAdapter
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var mMainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView(){
        mAdapter = UserAdapter(mutableListOf(), this)
        mLayoutManager = LinearLayoutManager(this)

        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mMainViewModel.getUsers().observe(this){ stores ->
            mAdapter.setUsers(stores)
        }
        mBinding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            adapter = mAdapter
        }
    }

    override fun onClick(user: User) {
        TODO("Not yet implemented")
    }
}