package org.wit.gym_android_app.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import org.wit.gym_android_app.R
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

        var workoutKeys = resources.getStringArray(R.array.weeklyWorkoutKeys)
        var workoutVals: Array<String> = resources.getStringArray(R.array.weeklyWorkouts)
        var workoutMap = mutableMapOf<String, String>()
        for (i in workoutKeys.indices) {
            i("workout keys: ${workoutKeys[i]}")
            workoutMap[workoutKeys[i]] = workoutVals[i]
        }

        binding.btnAdd.setOnClickListener() {
            workout.title = binding.spinner.selectedItem.toString()
            binding.workoutExercise.setText(workoutMap[binding.spinner.selectedItem.toString()])
            workout.weight = binding.workoutWeight.text.toString()

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

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                i("Spinner item selected: $position")
                binding.workoutExercise.setText(workoutMap[binding.spinner.selectedItem.toString()])
            }

        }
    }
}