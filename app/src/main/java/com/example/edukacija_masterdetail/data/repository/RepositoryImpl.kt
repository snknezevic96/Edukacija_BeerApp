package com.example.edukacija_masterdetail.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.edukacija_masterdetail.data.db.BeerDao
import com.example.edukacija_masterdetail.data.db.Database
import com.example.edukacija_masterdetail.data.model.Beer
import com.example.edukacija_masterdetail.data.network.data_source.DataSource
import com.example.edukacija_masterdetail.data.network.data_source.DataSourceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RepositoryImpl(val beerApi: DataSource, val db: Database) : Repository {

    val items = MutableLiveData<List<Beer>>()
    var downloadFinished = MutableLiveData<Boolean>()

    // observe for change
    // save to Db when data arrive
    init {
        downloadFinished.postValue(false)
        beerApi.items.observeForever {
            if (it == null) return@observeForever
            items.postValue(it)
            saveToDb()
        }
    }

    override fun getFromApi() {
        GlobalScope.launch(Dispatchers.IO) {
            beerApi.fatchItems()
            downloadFinished.postValue(true)
        }
    }

    override fun getFromDb(): LiveData<List<Beer>> = db.beerDao().getAll()

    override fun saveToDb() {
        GlobalScope.launch(Dispatchers.IO) {
            db.beerDao().insertAll(items.value!!)
            Log.i("api_rez", "saveToDb: ${items.value}")
        }
    }

}