package com.example.best10countriesapp.feature1.ui.screens.splash


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.best10countriesapp.feature1.model.CountryList
import com.example.best10countriesapp.feature1.model.repository.local.room.AppDatabase
import com.example.best10countriesapp.feature1.model.repository.local.shared.LocalStorage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenViewModel : ViewModel() {

    private val localStorage=LocalStorage.getLocalStorage()
    private val appDatabase=AppDatabase.getAppDatabase()
    private val countryList=CountryList()
    val openMainScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            if (!localStorage.first){
                localStorage.first=true
                appDatabase.getCountryDao().insertAll(countryList.listCountry)
            }
            delay(1500)

                openMainScreenLiveData.value=Unit

        }
    }
}

