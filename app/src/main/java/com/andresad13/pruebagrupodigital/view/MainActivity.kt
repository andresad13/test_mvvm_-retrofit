package com.andresad13.pruebagrupodigital.view

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andresad13.pruebagrupodigital.R
import com.andresad13.pruebagrupodigital.adapters.ListUsersAdapter
import com.andresad13.pruebagrupodigital.model.User
import com.andresad13.pruebagrupodigital.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    lateinit var context: Context
    private var listaUsers: List<User>? = null
    lateinit var listaFiltro: ArrayList<User>
    private var recyclerViewUsers: RecyclerView? = null
    lateinit var adapter: ListUsersAdapter

    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this@MainActivity
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        recyclerViewUsers = findViewById<View>(R.id.recyclerPersonas) as RecyclerView
        var editFindUser = findViewById<EditText>(R.id.edit_find_user)
        var loadingView = findViewById<View>(R.id.loading_view)
        recyclerViewUsers!!.setLayoutManager(LinearLayoutManager(this))
        loadingView.visibility = View.VISIBLE
        editFindUser.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                if(listaUsers!!.size > 0) {
                    listaFiltro.clear()
                    for (i in listaUsers!!) if (editFindUser.text in i.name)listaFiltro.add(i)
                }
                adapter.notifyDataSetChanged()
            }
        })
            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->
                listaUsers = serviceSetterGetter.user
                listaFiltro = ArrayList(listaUsers)
                adapter = listaFiltro?.let { ListUsersAdapter(it) }
                recyclerViewUsers!!.setAdapter(adapter)
                loadingView.visibility = View.GONE
            })
    }
}