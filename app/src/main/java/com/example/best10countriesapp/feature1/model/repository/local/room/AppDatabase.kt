package com.example.best10countriesapp.feature1.model.repository.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.best10countriesapp.feature1.model.repository.local.room.daos.CountryDao
import com.example.best10countriesapp.feature1.model.repository.local.room.entities.CountryEntity


@Database(entities = [CountryEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    companion object{
        private var appDatabase:AppDatabase?=null
        fun  init(context: Context){
            if(appDatabase==null){
                appDatabase= Room.databaseBuilder(context,AppDatabase::class.java,"appDatabase").
                allowMainThreadQueries()
                    .build()
            }
        }
        fun getAppDatabase()= appDatabase!!
    }


    abstract fun getCountryDao(): CountryDao



}