package com.example.tasarimcalismasi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasarimcalismasi.ui.theme.AnaRenk
import com.example.tasarimcalismasi.ui.theme.AnaRenkDark
import com.example.tasarimcalismasi.ui.theme.TasarimCalismasiTheme
import com.example.tasarimcalismasi.ui.theme.YaziRenkBeyaz
import com.example.tasarimcalismasi.ui.theme.YaziRenkGri
import com.example.tasarimcalismasi.ui.theme.YaziRenkGriDark
import com.example.tasarimcalismasi.ui.theme.pacifico

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasarimCalismasiTheme {
                Anasayfa()
                }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Anasayfa(darkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.app_name), fontFamily = pacifico) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (darkTheme) AnaRenkDark else AnaRenk,
                    titleContentColor = YaziRenkBeyaz)
            )
        }
    ) {paddingValues ->
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                stringResource(R.string.pizzaBaslik),
                color = if (darkTheme) AnaRenkDark else AnaRenk,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp)
            Image(
                painter = painterResource(R.drawable.pizza_resim),
                contentDescription = "",
                modifier = Modifier.size(200.dp) // Burada 200.dp olarak boyutlandırabilirsiniz
            )
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                chipButton(stringResource(R.string.biberYazi))
                chipButton(stringResource(R.string.peynirYazi))
                chipButton(stringResource(R.string.sucukYazi))
                chipButton(stringResource(R.string.zeytinYazi))
            }
            Text(
                stringResource(R.string.teslimatSure),
                color = if (darkTheme) YaziRenkGriDark else YaziRenkGri,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp)
            Text(
                stringResource(R.string.teslimatBaslik),
                color = if (darkTheme) AnaRenkDark else AnaRenk,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp)
            Text(
                stringResource(R.string.pizzaAciklama),
                color = if (darkTheme) YaziRenkGriDark else YaziRenkGri,
                fontSize = 22.sp,
                textAlign = TextAlign.Center)
            Row (modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround){
                Text(
                    stringResource(R.string.fiyatYazi),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (darkTheme) AnaRenkDark else AnaRenk,
               )
                Button(onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        if (darkTheme) AnaRenkDark else AnaRenk,
                    )) {
                    Text(
                        stringResource(R.string.buttonYazi),
                        color = YaziRenkBeyaz,
                        fontSize = 20.sp)
                }
            }

        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    TasarimCalismasiTheme {
        Anasayfa()
    }
}