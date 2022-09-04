package com.example.listusers.mainModule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.listusers.R
import com.example.listusers.common.entities.User
import com.example.listusers.databinding.ItemUserBinding

class UserAdapter(private var users: MutableList<User>, private var listener: OnClickListener):
    RecyclerView.Adapter<UserAdapter.VieHolder>(){

    private lateinit var context: Context

    inner class VieHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view)
        fun setListener(user: User){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VieHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return  VieHolder(view)
    }

    override fun onBindViewHolder(holder: VieHolder, position: Int) {
        val user = users[position]
        with(holder){
            binding.tvEmail.text = user.email
            binding.tvName.text = user.first_name + " " + user.last_name
            Glide.with(context)
                .load(user.avatar)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.imgAvatar)
        }
    }

    override fun getItemCount() = users.size

    fun setUsers(users: MutableList<User>) {
        this.users = users
        notifyDataSetChanged()
    }
}