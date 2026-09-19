package com.oso.mygames.data

import com.oso.mygames.model.GamesModel
import com.oso.mygames.model.SingleGameModel
import com.oso.mygames.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGames {

    @GET(Constants.END_POINT+ Constants.API_KEY)
    suspend fun getGames(): Response<GamesModel>

    @GET("${Constants.END_POINT}/{id}${Constants.API_KEY}")
    suspend fun getGameById(@Path(value = "id")id : Int): Response<SingleGameModel>

}