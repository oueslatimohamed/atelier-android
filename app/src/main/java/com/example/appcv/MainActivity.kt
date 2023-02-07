package com.example.appcv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var email: EditText
        var age: EditText
        var skillAndroid: SeekBar
        var gender: RadioGroup
        var fullName: EditText
        var skillIos: SeekBar
        var skillFlutter: SeekBar
        var nextBtn: Button
        var resetBtn: Button

        fullName = findViewById(R.id.nameField)
        email = findViewById(R.id.emailField)
        age = findViewById(R.id.ageField)
        gender = findViewById(R.id.radioGrp)
        skillAndroid = findViewById(R.id.seekAndroid)
        skillIos = findViewById(R.id.seekIos)
        skillFlutter =findViewById(R.id.seekFlutter)
        nextBtn= findViewById(R.id.nextBtn)
        resetBtn = findViewById(R.id.resetBtn)


        nextBtn.setOnClickListener {
            if (fullName.text.isEmpty() || email.text.isEmpty() || age.text.isEmpty()) {
                Toast.makeText(this, "Please fill the form", Toast.LENGTH_SHORT).show()
            } else if (!email.text.matches(Patterns.EMAIL_ADDRESS.toRegex())) {
                Toast.makeText(this, "Please put a valid email", Toast.LENGTH_SHORT).show()
            } else {
                var listSeek = listOf(skillAndroid.progress, skillIos.progress, skillFlutter.progress)
                val listSkills = listOf("Android", "IOS", "Flutter")
                for ((value, skill) in listSeek.zip(listSkills)) {
                    if (value > 80) {
                        Toast.makeText(this, "Vous êtes excellent en $skill", Toast.LENGTH_LONG).show()
                    }
                }
                listSeek = listSeek.filter { skill -> skill > 30 }
                if (listSeek.isEmpty()) {
                    Toast.makeText(this, "Vous devez travailler vos skills", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this, "Vous avez de bons skills !", Toast.LENGTH_SHORT).show()
            }
        }

        resetBtn.setOnClickListener {
            reset(fullName,email,age,skillAndroid,skillIos,skillFlutter)
        }

    }

    fun reset(fullname: EditText ,email: EditText , age:EditText , skillAndroid: SeekBar,skillIos: SeekBar ,skillFlutter: SeekBar) {
        val edits = listOf(fullname,email,age)
        val skills = listOf(skillAndroid,skillIos,skillFlutter)
        edits.forEach { editText -> editText.setText("") }
        skills.forEach { skill-> skill.progress = 0 }
    }
}