package com.example.best10countriesapp.feature1.app

import android.app.Application
import com.example.best10countriesapp.feature1.model.repository.local.room.AppDatabase
import com.example.best10countriesapp.feature1.model.repository.local.shared.LocalStorage

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        AppDatabase.init(this)
    }
}