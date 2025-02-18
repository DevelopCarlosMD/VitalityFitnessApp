package com.capgemini.vitalityfitness

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CaloriesActivity : AppCompatActivity() {

    private var steps: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calories)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        steps = intent.getIntExtra(MainActivity.TOTAL_STEPS, 0)
        Log.d("steps", steps.toString())
        val caloriesBurned = CalorieCalculator.calculateCaloriesBurnedBaseOnSteps(steps)
        findViewById<TextView>(R.id.total_calories_burned_text).text =
            getString(R.string.calories_burned_message, caloriesBurned, steps)
    }
}