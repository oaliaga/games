package com.oso.mygames.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oso.mygames.model.GameList
import com.oso.mygames.repository.GamesRepository
import com.oso.mygames.state.GameState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel(){

    private val _games= MutableStateFlow<List<GameList>>(emptyList())
    val games=_games.asStateFlow()

    var state by mutableStateOf(GameState())
        private set


    init {
        fechGames()
    }

    private fun fechGames(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result= repository.getGames()
                _games.value=result ?: emptyList()
            }
        }
    }

    fun getGameById(id:Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result=repository.getGameById(id)
                state = state.copy(
                    name= result?.name ?:"",
                    description= result?.description ?:"",
                    metacritic= result?.metacritic ?:111,
                    background_image= result?.background_image ?:"sin web",
                    website= result?.website ?:"",
                )
            }
        }
    }

}