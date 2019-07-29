package com.example.edukacija_masterdetail.data.network

import com.example.edukacija_masterdetail.data.model.Beer
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    companion object{
        operator fun invoke() : ApiInterface{
            return Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/danijela-k/test/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(ApiInterface::class.java)
        }
    }

    @GET("items")
    fun getAllItems() : Deferred<List<Beer>>
}