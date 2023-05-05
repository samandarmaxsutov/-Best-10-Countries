package com.example.best10countriesapp.feature1.ui.screens.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.best10countriesapp.feature1.model.repository.local.room.AppDatabase
import com.example.best10countriesapp.feature1.model.repository.local.room.entities.CountryEntity

class HomeScreenViewModel : ViewModel() {
    private val appDatabase=AppDatabase.getAppDatabase()
    val countriesLiveData= MediatorLiveData<List<CountryEntity>>()
    val openCountryScreenLiveData=MutableLiveData<CountryEntity>()
     fun open(country: CountryEntity) {
        openCountryScreenLiveData.value=country
    }


    init {
        countriesLiveData.addSource(appDatabase.getCountryDao().getCountryList()){
            countriesLiveData.value=it
        }

    }

    fun search(words:String){
        if (words.isNotEmpty()) {
            countriesLiveData.addSource(appDatabase.getCountryDao().search(words)) {
                countriesLiveData.value = it
            }
        }else{
            countriesLiveData.addSource(appDatabase.getCountryDao().getCountryList()){
                countriesLiveData.value=it
            }
        }
    }
}