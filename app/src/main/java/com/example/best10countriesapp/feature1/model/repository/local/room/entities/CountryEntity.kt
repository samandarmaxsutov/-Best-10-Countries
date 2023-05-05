package com.example.best10countriesapp.feature1.model.repository.local.room.entities


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
data class CountryEntity(
    @PrimaryKey (autoGenerate = true) val id: Int ,
    val name: String,
    val capital: String,
    val image: Int,
    val aboutText:String,
    val location: String,
    val starts:Int,
    val favourite:Boolean
): Serializable