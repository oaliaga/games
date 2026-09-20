package com.oso.mygames.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.oso.mygames.components.MainImage
import com.oso.mygames.components.MainTopBar
import com.oso.mygames.components.MetaWebsite
import com.oso.mygames.components.ReviewCard
import com.oso.mygames.viewmodel.GamesViewModel

@Composable
fun DetailView(viewModel: GamesViewModel, navController: NavController, id: Int) {

    LaunchedEffect(Unit) {
        viewModel.getGameById(id)
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clean()
        }
    }

    Scaffold(
        topBar = {
            MainTopBar(
                title = viewModel.state.name,
                showBackButton = true,
                onclickBackButton = { navController.popBackStack()},
                onclickAction = {}
                )
        }
    ) { paddingValues ->
        ContentDescription(paddingValues, viewModel)
    }
}


@Composable
fun ContentDescription(paddingValues: PaddingValues, viewModel: GamesViewModel) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .background(MaterialTheme.colorScheme.background)
    ) {
        MainImage(image=state.background_image)
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start=20.dp, end= 5.dp)
        ){
            MetaWebsite(state.website)
            ReviewCard(state.metacritic)
        }

        val scroll= rememberScrollState(0)
        Text(
            text= state.description_raw,
            color=Color.White,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start=15.dp, end=15.dp, bottom = 10.dp)
                .verticalScroll(scroll)
            )

    }
}