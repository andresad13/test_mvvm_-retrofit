package com.andresad13.pruebagrupodigital.retrofit

import com.andresad13.pruebagrupodigital.model.ServicesSetterGetter
import com.andresad13.pruebagrupodigital.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getServices(
    )
     : Call<List<User>>

}