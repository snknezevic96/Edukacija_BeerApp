package com.example.edukacija_masterdetail.data.network.data_source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.edukacija_masterdetail.data.model.Beer
import com.example.edukacija_masterdetail.data.network.ApiInterface

class DataSourceImpl : DataSource {

    private var _items = MutableLiveData<List<Beer>>()
    override val items : LiveData<List<Beer>>
        get() = _items

    override suspend fun fatchItems() {
        _items.postValue(ApiInterface().getAllItems().await())
    }
}