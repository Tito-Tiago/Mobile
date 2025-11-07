package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    CardCalculadora()
                }
            }
        }
    }
}

fun calcularImc(pesoString: String, alturaString: String): String {
    val pesoNum = pesoString.toFloatOrNull()
    val alturaNum = alturaString.toFloatOrNull()

    if (pesoNum != null && alturaNum != null && alturaNum > 0f) {
        val imcNum = pesoNum / (alturaNum * alturaNum)

        val imcFormatado = "%.2f".format(imcNum)

        return when(imcNum) {
            in 0.0..16.99 -> "Seu IMC é $imcFormatado, você está muito abaixo do peso"
            in 17.0..18.49 -> "Seu IMC é $imcFormatado, você está abaixo do peso"
            in 18.5..24.99 -> "Seu IMC é $imcFormatado, seu peso é normal"
            in 25.0..29.99 -> "Seu IMC é $imcFormatado, você está acima do peso"
            in 30.0..34.99 -> "Seu IMC é $imcFormatado, você está com obesidade I"
            in 35.0..39.99 -> "Seu IMC é $imcFormatado, você está com obesidade II (severa)"
            else -> "Seu IMC é $imcFormatado, você está com obesidade III (mórbida)"
        }
    } else {
        return "Valores inválidos"
    }
}

@Composable
fun CardCalculadora(modifier: Modifier = Modifier) {
    Card (
        modifier = Modifier
            .padding(32.dp),
    ) {
        Column (
            modifier = Modifier
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            var altura by remember {
                mutableStateOf("")
            }

            var peso by remember {
                mutableStateOf("")
            }

            var imc by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = altura,
                onValueChange = {newText ->
                    altura = newText
                },
                label = {Text("digite sua altura em metros")}
            )
            OutlinedTextField(
                value = peso,
                onValueChange = {newText ->
                    peso = newText
                },
                label = {Text("digite seu peso em kilos")}
            )
            OutlinedTextField(
                value = imc,
                onValueChange = {},
                label = {Text("IMC:")},
                readOnly = true
            )
            Button(
                onClick = {
                    imc = calcularImc(peso, altura)
                }
            ) {
                Text("Calcular")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraIMCTheme {
        CardCalculadora()
    }
}