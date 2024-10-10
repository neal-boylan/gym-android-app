package org.wit.gym_android_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import timber.log.Timber.i

class GymActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gym)

        Timber.plant(Timber.DebugTree())
        i("Gym Activity started..")
    }
}