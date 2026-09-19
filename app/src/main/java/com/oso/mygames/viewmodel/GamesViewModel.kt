package com.oso.mygames.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oso.mygames.model.GameList
import com.oso.mygames.repository.GamesRepository
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

}