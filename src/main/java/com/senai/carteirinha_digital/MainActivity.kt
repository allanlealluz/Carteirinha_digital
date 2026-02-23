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

/**
 * The main entry point of the application.
 *
 * This activity is responsible for setting up the main UI of the application
 * using Jetpack Compose. It displays a digital student ID card.
 */
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

/**
 * Composable function representing the Digital Student ID (Carteirinha Digital) screen.
 * This function displays a student's information including photo, personal details, and QR code.
 *
 * @param modifier The modifier to be applied to the layout
 * @param function A callback function to be executed when certain actions occur
 */
    @Composable
    fun Carteirinha_digitalApp(modifier: Modifier = Modifier, function: () -> Unit) {

    // Column layout that fills the entire screen with padding and center alignment
        Column(
            modifier = modifier
                .fillMaxSize() // Makes the column occupy the entire available space
                .padding(16.dp), // Adds 16dp padding around the content
            horizontalAlignment = Alignment.CenterHorizontally, // Centers children horizontally
            verticalArrangement = Arrangement.SpaceEvenly // Distributes children evenly vertically
        ) {

        // Displays the Senai institution logo
            Image(
                painter = painterResource(id = R.drawable.senai),
                contentDescription = "Logo Senai"
            )

        // Displays the student's profile photo with weight for sizing
            Image(
                painter = painterResource(id = R.drawable.chico),
                contentDescription = "Foto de Perfil", // Profile photo description
                modifier = Modifier.weight(0.3f) // Assigns 30% of the available vertical space
            )



        // Displays student information as text
            Text(text = "Nome: Allan") // Student's name
            Text(text = "Curso: ADS") // Course name
            Text(text = "Turma: 4° DEVSM") // Class information
            Text(text = "Matrícula: 2026") // Student ID
            Text(text = "Data de Nascimento: 21/09/2005") // Date of birth

        // Displays the QR code containing student identification number
            QrCode("90000000001382838830")
        }
    }
}