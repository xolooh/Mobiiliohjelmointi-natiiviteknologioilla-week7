package com.example.week7

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {
    var weight = mutableStateOf("")
    var height = mutableStateOf("")
    var bmiResult = mutableStateOf("")

    fun calculateBmi() {
        val weightValue = weight.value.toDoubleOrNull()
        val heightValue = height.value.toDoubleOrNull()

        if (weightValue != null && heightValue != null && heightValue > 0) {
            val bmi = weightValue / (heightValue * heightValue)
            bmiResult.value = String.format("%.2f", bmi)
        } else {
            bmiResult.value = "Invalid input"
        }
    }
}