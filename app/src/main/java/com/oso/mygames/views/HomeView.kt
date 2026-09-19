package com.oso.mygames.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.oso.mygames.components.CardGame
import com.oso.mygames.components.MainTopBar
import com.oso.mygames.util.Constants
import com.oso.mygames.viewmodel.GamesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(viewModel: GamesViewModel, navController: NavController){

    Scaffold (
        topBar = {
            MainTopBar(title = "Api Games"){

            }
        }
    ) {padding->
        ContentHomeView(viewModel,padding,navController)
    }
}

@Composable
fun ContentHomeView(viewModel: GamesViewModel, padding: PaddingValues, navController: NavController){
    val games by viewModel.games.collectAsState()
    LazyColumn(modifier = Modifier
        .padding(padding)
        .background(MaterialTheme.colorScheme.background)
    ){
        items(games){ item->
            CardGame(item){
                navController.navigate("DetailView/${item.id}")
            }
            Text(
                text=item.name,
                fontWeight = FontWeight.ExtraBold,
                color= Color.White,
                modifier = Modifier.padding(start = 10.dp)
            )
        }
    }

}