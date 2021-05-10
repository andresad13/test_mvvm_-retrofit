package com.andresad13.pruebagrupodigital.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andresad13.pruebagrupodigital.R
import com.andresad13.pruebagrupodigital.model.User

class ListUsersAdapter(listaUsers: List<User>) :
    RecyclerView.Adapter<ListUsersAdapter.UsersViewHolder>() {
    private val listaUsers: List<User>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, null, false)
        return UsersViewHolder(view)
    }
    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.name.setText(listaUsers[position].name)
        holder.id.setText(listaUsers[position].id.toString())
        holder.username.setText(listaUsers[position].username)
        holder.email.setText(listaUsers[position].email)
        holder.phone.setText(listaUsers[position].phone)
        holder.website.setText(listaUsers[position].website)
    }
    override fun getItemCount(): Int {
        return listaUsers.size
    }
    inner class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var id: TextView
        var username: TextView
        var phone: TextView
        var email: TextView
        var website: TextView
        init {
            name = itemView.findViewById(R.id.textName)
            id = itemView.findViewById(R.id.textId)
            username = itemView.findViewById(R.id.textUserName)
            phone = itemView.findViewById(R.id.textPhone)
            email = itemView.findViewById(R.id.textEmail)
            website = itemView.findViewById(R.id.textWebSite)
        }
    }
    init {
        this.listaUsers = listaUsers
    }
}