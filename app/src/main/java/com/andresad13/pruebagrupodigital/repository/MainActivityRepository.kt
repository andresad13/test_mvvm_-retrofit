package com.andresad13.pruebagrupodigital.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.andresad13.pruebagrupodigital.model.ServicesSetterGetter
import com.andresad13.pruebagrupodigital.model.User
import com.andresad13.pruebagrupodigital.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<ServicesSetterGetter>()

    fun getServicesApiCall(): MutableLiveData<ServicesSetterGetter> {

        val call = RetrofitClient.apiInterface.getServices()

        call.enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                val data = response.body()
                serviceSetterGetter.value = ServicesSetterGetter(data!!)
            }
        })
        return serviceSetterGetter
    }
}