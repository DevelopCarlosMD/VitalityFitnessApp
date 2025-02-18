package com.capgemini.vitalityfitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_STEPS = "TOTAL_STEPS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btn_calculate_calories).setOnClickListener {
            val totalSteps = (findViewById<EditText>(R.id.edt_steps_number)).text.toString().toInt()
            changeToCalories(totalSteps)
        }
    }

    private fun changeToCalories(totalSteps: Int) {
        val intent = Intent(this, CaloriesActivity::class.java)
        intent.putExtra(TOTAL_STEPS, totalSteps)
        startActivity(intent)
        cleanStepsInput()
    }

    private fun cleanStepsInput() = (findViewById<EditText>(R.id.edt_steps_number)).setText("")
}