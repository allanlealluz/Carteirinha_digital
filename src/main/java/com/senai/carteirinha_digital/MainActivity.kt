package com.senai.carteirinha_digital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelcosta.myapplication.QrCode
import com.senai.carteirinha_digital.ui.theme.Carteirinha_digitalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           Carteirinha_digitalTheme() {
                Scaffold( modifier = Modifier.fillMaxSize()  ) {
                    innerPadding ->
                    Carteirinha_digitalApp("teste")
                }

            }
        }
    }
}
@Composable
fun Carteirinha_digitalApp(name: String) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.senai),
            contentDescription = "logo senai",
        )
        Image(
            painter = painterResource(id = R.drawable.chico),
            contentDescription = "Foto de Perfil",
        )
        Row {

Text(text = "Nome: $name")
        }
        Row {
            Text(text = "Curso: ADS")
        }
        Row {
            Text(text = "Turma: 2° ADS")
        }
        Row {
            Text(text = "Matricula: 2023")
        }
        Row {
            Text(text = "Data de Nascimento: 01/01/2001")
        }
        Row {
            Text(text = "Endereço: Rua 1, 123")
        }
        Row {
            Text(text = "Telefone: (11) 11111-1111")        }
    }
    QrCode("Valor do QR code")

}