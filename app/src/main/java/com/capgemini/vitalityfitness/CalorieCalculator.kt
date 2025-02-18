package com.capgemini.vitalityfitness


import kotlin.math.roundToInt

class CalorieCalculator {
    companion object {
        private const val AVERAGE_STEP_LENGTH_METERS = 0.762 // Average step length in meters
        private const val AVERAGE_WALKING_SPEED_KM_PER_HOUR = 4.8 // Average walking speed in km/h
        private const val MET_VALUE = 3.5 // MET value for moderate walking
        private const val AVERAGE_WEIGHT_KG = 70.0 // Average weight in kg

        fun calculateCaloriesBurnedBaseOnSteps(
            steps: Int,
            weightKg: Double = AVERAGE_WEIGHT_KG,
            stepLengthMeters: Double = AVERAGE_STEP_LENGTH_METERS,
            walkingSpeedKmPerHour: Double = AVERAGE_WALKING_SPEED_KM_PER_HOUR,
            metValue: Double = MET_VALUE
        ): Int {
            if (steps < 0 || weightKg <= 0 || stepLengthMeters <= 0 || walkingSpeedKmPerHour <= 0 || metValue <= 0) {
                throw IllegalArgumentException("Steps, weight, step length, walking speed, and MET value must be positive values.")
            }
            // Calculate the distance covered in meters
            val distanceMeters = steps * stepLengthMeters

            // Calculate the time taken in hours
            val timeHours = distanceMeters / (walkingSpeedKmPerHour * 1000)

            // Calculate calories burned
            val caloriesBurned = metValue * weightKg * timeHours

            return caloriesBurned.roundToInt()
        }
    }
}