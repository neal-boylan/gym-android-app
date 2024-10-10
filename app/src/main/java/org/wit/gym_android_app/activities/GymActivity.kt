package org.wit.gym_android_app.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.wit.gym_android_app.databinding.ActivityGymBinding
import org.wit.gym_android_app.models.WorkoutModel
import timber.log.Timber
import timber.log.Timber.i

class GymActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGymBinding
    var workout = WorkoutModel()
    val workouts = ArrayList<WorkoutModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGymBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())
        i("Gym Activity started..")

        binding.btnAdd.setOnClickListener() {
            workout.title = binding.workoutTitle.text.toString()
            workout.description = binding.workoutDescription.text.toString()
            if (workout.title.isNotEmpty()) {
                i("add Button Pressed: $workout.title")
                workouts.add(workout.copy())
                for (i in workouts.indices) {
                    i("Workout[$i]: ${this.workouts[i]}")
                }
            }
            else {
                Snackbar
                    .make(it,"Please Enter a title", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }
}