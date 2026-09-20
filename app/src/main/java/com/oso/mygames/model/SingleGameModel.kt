package com.oso.mygames.model

import kotlinx.serialization.Serializable

@Serializable
data class SingleGameModel(
    val name:String,
    val description: String,
    val description_raw: String,
    val metacritic:Int,
    val website:String,
    val background_image:String
)
