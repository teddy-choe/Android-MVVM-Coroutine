package com.example.cocktailmvvmcoroutine.data.network

import com.example.cocktailmvvmcoroutine.data.model.CocktailDetailResponse
import com.example.cocktailmvvmcoroutine.data.model.CocktailResponse
import com.example.cocktailmvvmcoroutine.data.model.IngredientResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {
    @GET("api/json/v1/1/filter.php?")
    suspend fun getAlcoholicCocktailList(
        @Query("a") alcoholic: String = "Alcoholic"
    ): CocktailResponse

    @GET("api/json/v1/1/lookup.php?")
    suspend fun getCocktailDetailInfo(
        @Query("i") idDrink: Long
    ): CocktailDetailResponse

    @GET("api/json/v1/1/search.php?")
    suspend fun getIngredient(
        @Query("i") strIngredient: String
    ): IngredientResponse
}
