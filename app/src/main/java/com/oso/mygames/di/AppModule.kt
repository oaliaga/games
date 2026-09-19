package com.oso.mygames.di

import com.oso.mygames.data.ApiGames
import com.oso.mygames.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import javax.inject.Singleton

import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(json:Json): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json; charset=utf-8".toMediaType()))
            .build()
    }

    @Provides
    fun provideJson():Json{
        return Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

    @Singleton
    @Provides
    fun providesApiGames(retrofit: Retrofit): ApiGames{
        return retrofit.create(ApiGames::class.java)
    }

    //38883910b0ee49229e6c8cd7f8a7e29d
}