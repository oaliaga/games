package com.oso.mygames.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.TableInfo
import coil.compose.rememberImagePainter
import com.oso.mygames.model.GameList
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
            containerColor = MaterialTheme.colorScheme.background
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

@Composable
fun CardGame(game: GameList, onclick: () -> Unit){
    Card(
        shape= RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(10.dp)
            .shadow(40.dp)
            .clickable { onclick()}
    ){
        Column {
            MainImage(image=game.background_image)
        }
    }
}

@Composable
fun  MainImage(image:String){
    val image = rememberImagePainter(data=image)

    Image(
        painter = image,
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
    )
}

@Composable
fun MetaWebsite(url:String){
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_VIEW,Uri.parse(url))

    Column() {
        Text(
            text = "METASCORE",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top=10.dp, bottom = 10.dp)
        )
        Button(
            onClick = {
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
                containerColor = Color.Gray
        )) {
            Text(text="Sitio web")
        }
    }
}