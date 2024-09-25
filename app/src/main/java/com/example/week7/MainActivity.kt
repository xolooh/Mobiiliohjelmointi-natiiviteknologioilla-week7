package com.example.week7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BmiCalculatorScreen()
        }
    }
}

@Composable
fun BmiCalculatorScreen(viewModel: BmiViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "BMI Calculator", style = MaterialTheme.typography.titleLarge)


        TextField(
            value = viewModel.height.value,
            onValueChange = { viewModel.height.value = it },
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = viewModel.weight.value,
            onValueChange = { viewModel.weight.value = it },
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.calculateBmi() }) {
            Text("Calculate BMI")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Your BMI: ${viewModel.bmiResult.value}", style = MaterialTheme.typography.titleMedium)
    }
}
