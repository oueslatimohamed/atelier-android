package com.esprit.diceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ResumeFragment(val name:String, val age:String,  val gender:String,val email:String) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_resume, container, false)
        // Inflate the layout for this fragment
        view.findViewById<TextView>(R.id.textname).text = "Hello, My name is $name"
        view.findViewById<TextView>(R.id.textage).text = "I have $age years old" +
                "\nand i'm a $gender" +
                "\nYou can contact me via my email \n$email"
        return view
    }

}