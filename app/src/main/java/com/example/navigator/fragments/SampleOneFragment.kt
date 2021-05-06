package com.example.navigator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.navigator.MainActivity
import com.example.navigator.R
import com.example.navigator.navigator.Screens
import com.example.navigator.navigator.`interface`.NavigatorInterface

class SampleOneFragment : Fragment(), NavigatorInterface {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().findViewById<Button>(R.id.button).setOnClickListener {
            (requireActivity() as MainActivity).openFragment(Screens.SCREEN_TWO)
        }
    }

    override fun onShow(data: Any?) {
        Toast.makeText(activity, "fragment one showed", Toast.LENGTH_SHORT).show()
    }

    override fun onHide(data: Any?) {
        Toast.makeText(activity, "fragment one hide", Toast.LENGTH_SHORT).show()
    }
}