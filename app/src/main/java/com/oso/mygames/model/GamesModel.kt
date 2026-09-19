package com.oso.mygames.model

import kotlinx.serialization.Serializable

@Serializable
data class GamesModel(
    val count:Int,
    val results:List<GameList>
)

@Serializable
data class GameList(
    val id:Int,
    val name: String,
    val updated: String,
    val background_image: String
)