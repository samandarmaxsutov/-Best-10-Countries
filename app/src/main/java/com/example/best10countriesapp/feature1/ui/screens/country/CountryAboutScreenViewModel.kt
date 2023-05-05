package com.example.best10countriesapp.feature1.ui.screens.country

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.best10countriesapp.feature1.model.repository.local.room.AppDatabase
import com.example.best10countriesapp.feature1.model.repository.local.room.entities.CountryEntity

class CountryAboutScreenViewModel : ViewModel() {
    var fav=false
    private val appDatabase= AppDatabase.getAppDatabase()
    val getUiChange=MediatorLiveData<CountryEntity>()
    init {

    }
    fun update(countryEntity: CountryEntity){
        appDatabase.getCountryDao().update(countryEntity)
        getUiChange.addSource(appDatabase.getCountryDao().getCountry(countryEntity.id) ){
            getUiChange.value=it
        }
    }
}