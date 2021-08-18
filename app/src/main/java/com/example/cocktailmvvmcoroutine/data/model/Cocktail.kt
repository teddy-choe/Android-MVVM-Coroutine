package com.example.cocktailmvvmcoroutine.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cocktail")
data class Cocktail(
    @PrimaryKey
    @ColumnInfo(name = "id_drink")
    val idDrink: Long,
    @ColumnInfo(name = "str_drink")
    val strDrink: String,
    @ColumnInfo(name = "str_drink_thumb")
    val strDrinkThumb: String
)
