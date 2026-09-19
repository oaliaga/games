package com.oso.mygames.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.oso.mygames.util.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title:String, showBackButton:Boolean= false, onclickBackButton :() -> Unit){

    TopAppBar(
        title={
            Text(
                text=title,
                color=Color.White,
                fontWeight = FontWeight.ExtraBold)
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color(Constants.CUSTOM_BLACK)
        ),
        navigationIcon = {
            if(showBackButton){
                IconButton (onClick = {onclickBackButton}) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "icon back",
                        tint = Color.White
                    )
                }
            }
        }
    )

}