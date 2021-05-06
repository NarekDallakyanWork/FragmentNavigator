package com.example.navigator

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.MotionEvent
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.navigator.navigator.Navigator
import com.example.navigator.navigator.Screens


abstract class BaseActivity(@LayoutRes layout: Int) : AppCompatActivity(layout) {

    var navigator: Navigator = com.example.navigator.navigator.NavigatorImpl(this)

    private var dispatchTouchEvent: ((ev: MotionEvent) -> Unit)? = null

    var keyboardIsOpened = false

    fun goTo(activity: Class<out AppCompatActivity>, bundle: Bundle? = null, popStack: Boolean) {

        val intent = Intent(this, activity)

        if (bundle != null)
            intent.putExtra("bundle", bundle)

        if (popStack) {

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        startActivity(intent)

        if (popStack)
            finish()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    fun openFragment(
        screen: Screens,
        bundle: Bundle? = null,
        recreate: Boolean = false,
        removeCurrentScreen: Boolean = false
    ) {

        // Navigate to screen
        navigator.navigateTo(screen, bundle, recreate, removeCurrentScreen)
    }

    fun previousScreen(recreate: Boolean = false, bundle: Bundle? = null){
        navigator.goBack(recreate, bundle)
    }

    fun addScreens(screen: Array<out Screens>) {
        navigator.addScreens(screen)
    }

    fun removeScreens(screen: Array<out Screens>) {
        navigator.removeScreens(screen)
    }

    fun removeAllScreens() {
        navigator.removeAllScreens()
    }

    fun getCurrentScreenFragment(): Fragment? {
        return navigator.getCurrentScreenFragment()
    }

    override fun onBackPressed() {
        previousScreen()
    }
}