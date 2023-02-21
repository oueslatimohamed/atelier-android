package com.esprit.diceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar


class SkillsFragment(val androids: String , val ios : String , val flutter : String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_skills,container,false)
        // Inflate the layout for this fragment
        view.findViewById<SeekBar>(R.id.seekAndroid1).setProgress(androids.toInt())
        view.findViewById<SeekBar>(R.id.seekIos1).setProgress(ios.toInt())
        view.findViewById<SeekBar>(R.id.seekFlutter1).setProgress(ios.toInt())
        return view
    }


}