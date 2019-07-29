package com.example.edukacija_masterdetail.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.edukacija_masterdetail.data.model.Beer
import com.example.edukacija_masterdetail.data.repository.Repository
import com.example.edukacija_masterdetail.data.repository.RepositoryImpl

class AppViewModel(val repository : Repository) : ViewModel() {

    fun fatchDataFromApi() = (repository as RepositoryImpl).getFromApi()

    fun getDataFromDb() : LiveData<List<Beer>> = (repository as RepositoryImpl).getFromDb()

    fun dataFromApi() : LiveData<List<Beer>> = (repository as RepositoryImpl).items

    // no need for fun saveToDb in viewModel...save to db done in repository (init block)
    //
    // fun saveData() = repository.saveToDb()
}