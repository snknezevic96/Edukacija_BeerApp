package com.example.edukacija_masterdetail.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.edukacija_masterdetail.data.model.Beer

@Dao
interface BeerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<Beer>)

    @Query("SELECT * FROM beer_table")
    fun getAll() : LiveData<List<Beer>>

}