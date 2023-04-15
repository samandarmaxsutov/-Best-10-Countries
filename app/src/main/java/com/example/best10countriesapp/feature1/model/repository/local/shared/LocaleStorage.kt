package com.example.best10countriesapp.feature1.model.repository.local.shared

import android.content.Context
import com.example.best10countriesapp.feature1.utils.SharedPreferenceHelper

class LocalStorage private constructor(context: Context): SharedPreferenceHelper(context){

    companion object{
        private var storage:LocalStorage?=null
        fun init(context: Context){
            if (storage==null){
                storage= LocalStorage(context)
            }
        }

        fun getLocalStorage()= storage!!
    }

    var first:Boolean by booleans(false)

}