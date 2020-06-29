package com.assem.chat_app_mvvm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.models.User
import com.mostafa.gomlaexpress.app.util.circularImage
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by Mohamed Assem on 24-Jun-20.
 * mo7mad.assim@gmail.com
 */

class UsersListAdapter : RecyclerView.Adapter<UsersListAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_user,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = differ.currentList[position]
        holder.itemView.apply {
//            Glide.with(this).load(user.image).into(item_user_img)
            circularImage(this, item_user_img, user.image, R.drawable.profile_pic_placeholder)
            item_user_username.text = user.username
            setOnClickListener {
                onItemClickListener?.let { it(user) }
            }
        }
    }


    private var onItemClickListener: ((User) -> Unit)? = null

    fun setOnItemClickListener(listener: (User) -> Unit) {
        onItemClickListener = listener
    }


    private val differCallback = object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            // comparing uid as it's unique
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}