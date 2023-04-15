package com.example.best10countriesapp.feature1.model.repository.local.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.best10countriesapp.feature1.model.repository.local.room.entities.CountryEntity

@androidx.room.Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(countryList: ArrayList<CountryEntity>)

    @Update
    fun update(countryEntity: CountryEntity)

    @Query("select * from CountryEntity")
    fun getCountryList():LiveData<List<CountryEntity>>
}