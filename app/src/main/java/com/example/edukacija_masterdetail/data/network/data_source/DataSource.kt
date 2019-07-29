package com.example.edukacija_masterdetail.data.network.data_source

import androidx.lifecycle.LiveData
import com.example.edukacija_masterdetail.data.model.Beer

interface DataSource {

    val items : LiveData<List<Beer>>

    suspend fun fatchItems()
}