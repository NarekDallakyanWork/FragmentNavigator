package com.example.navigator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigator.navigator.Screens

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        navigator.setContainer(R.id.main_fragments_container)
    }

    override fun onStart() {
        super.onStart()
        openFragment(Screens.SCREEN_ONE)
    }
}