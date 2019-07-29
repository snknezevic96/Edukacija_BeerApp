package com.example.edukacija_masterdetail.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.edukacija_masterdetail.data.model.Beer
import java.util.*

interface Repository {

    fun getFromDb() : LiveData<List<Beer>>?

    fun saveToDb()

    fun getFromApi()


}