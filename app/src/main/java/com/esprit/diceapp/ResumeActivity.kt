package com.esprit.diceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class ResumeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resume)
        val name = intent.getStringExtra("name")!!
        val email = intent.getStringExtra("email")!!
        val age = intent.getStringExtra("age")!!
        val gender = intent.getStringExtra("gender")!!
        val android = intent.getStringExtra("android")!!
        val ios = intent.getStringExtra("ios")!!
        val flutter = intent.getStringExtra("flutter")!!
        val languages = intent.getStringExtra("languages").toString().filter { c-> c.isLetter() || c.isWhitespace()}
        val hobbies = intent.getStringExtra("hobbies").toString().filter { c-> c.isLetter() || c.isWhitespace() }

        findViewById<TextView>(R.id.textView).text = name
        findViewById<TextView>(R.id.textView2).text = email
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout3,SkillsFragment(android,ios,flutter)).commit()
        val toolbar : Toolbar =  findViewById<Toolbar>(R.id.toolbar)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.info -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout3,ResumeFragment(name,age,gender,email)).commit()
            }
            true
        }

        findViewById<Button>(R.id.skillsbtn)?.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout3,SkillsFragment(android,ios,flutter)).commit()
        }
        findViewById<Button>(R.id.hobbiebtn)?.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout3,HobbiesFragment()).commit()

        }
        findViewById<Button> (R.id.langbtn)?.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.frameLayout3,LanguageFragment()).commit()

        }

        findViewById<Button>(R.id.careerbtn).setOnClickListener{
            val intent = Intent(this, MyCareerActivity::class.java)
            startActivity(intent)
        }
    }
}