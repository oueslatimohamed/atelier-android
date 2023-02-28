package com.esprit.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MyCareerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_career)
        val frameLayout= findViewById<FrameLayout>(R.id.frameLayoutcareer)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayoutcareer,ExperienceFragment()).commit()

    }
}