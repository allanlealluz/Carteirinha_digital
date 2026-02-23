package com.senai.carteirinha_digital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rafaelcosta.myapplication.QrCode
import com.senai.carteirinha_digital.ui.theme.Carteirinha_digitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Carteirinha_digitalTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Carteirinha_digitalApp(modifier = Modifier.padding(innerPadding)) {
                    }

                }
            }
        }
    }

    @Composable
    fun Carteirinha_digitalApp(modifier: Modifier = Modifier, function: () -> Unit) {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = painterResource(id = R.drawable.senai),
                contentDescription = "Logo Senai"
            )

            Image(
                painter = painterResource(id = R.drawable.chico),
                contentDescription = "Foto de Perfil",
                modifier = Modifier.weight(0.3f)
            )

            Text(text = "Nome: Allan")
            Text(text = "Curso: ADS")
            Text(text = "Turma: 4° DEVSM")
            Text(text = "Matrícula: 2026")
            Text(text = "Data de Nascimento: 01/01/2001")

            QrCode("90000000001382838830")
        }
    }
}