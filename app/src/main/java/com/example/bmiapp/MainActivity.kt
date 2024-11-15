package com.example.bmiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMIApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMIApp() {
    var weightInput by remember { mutableStateOf("") }
    var heightInput by remember { mutableStateOf("") }
    var isUSC by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf<Double?>(null) }
    var category by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BMI Calculator") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .align(Alignment.TopCenter), // Konten ada di bagian atas
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "BMI Calculator", style = MaterialTheme.typography.headlineMedium)

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = weightInput,
                    onValueChange = { weightInput = it },
                    label = { Text(if (isUSC) "Weight (lbs)" else "Weight (kg)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = heightInput,
                    onValueChange = { heightInput = it },
                    label = { Text(if (isUSC) "Height (inches)" else "Height (cm)") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Use USC")
                    Switch(
                        checked = isUSC,
                        onCheckedChange = { isUSC = it }
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    val weight = weightInput.toDoubleOrNull()
                    val height = heightInput.toDoubleOrNull()
                    if (weight != null && height != null) {
                        result = calculateBMI(weight, height, isUSC)
                        category = getBMICategory(result)
                    }
                }) {
                    Text(text = "Calculate BMI")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Result Display
                result?.let {
                    Text(text = "Your BMI: ${"%.2f".format(it)}", style = MaterialTheme.typography.headlineMedium)
                    Text(text = "Category: $category", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Text(
                text = "© 2024 By Andre Saputra Ginting",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(8.dp)
            )
        }
    }
}
fun calculateBMI(weight: Double, height: Double, isUSC: Boolean): Double {
    return if (isUSC) {
        703 * (weight / height.pow(2))
    } else {
        weight / (height / 100).pow(2)
    }
}

fun getBMICategory(bmi: Double?): String {
    return when {
        bmi == null -> ""
        bmi < 18.5 -> "Underweight"
        bmi in 18.5..24.9 -> "Normal weight"
        bmi in 25.0..29.9 -> "Overweight"
        else -> "Obesity"
    }
}