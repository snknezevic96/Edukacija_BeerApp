package com.example.edukacija_masterdetail.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.edukacija_masterdetail.data.model.Beer

@Database(entities = [Beer::class], version = 2)
abstract class Database : RoomDatabase() {

    abstract fun beerDao() : BeerDao
}