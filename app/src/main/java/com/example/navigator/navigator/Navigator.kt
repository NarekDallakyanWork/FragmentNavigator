package com.example.navigator.navigator

/**
 * Created by Gevorg Gevorgyan
 */

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.navigator.navigator.Screens

interface Navigator {

    /**
     * Set container for fragment transactions
     */
    fun setContainer(@IdRes containerId: Int)

    /**
     * go to previous screen
     */
    fun goBack(recreate: Boolean = false, bundle: Bundle? = null)

    /**
     * navigate to screen in set
     */
    fun navigateTo(
        screen: Screens,
        bundle: Bundle? = null,
        recreate: Boolean = false,
        removeCurrentScreen: Boolean = false,
    )

    /**
     * add screens in back stack
     */
    fun addScreens(screen: Array<out Screens>)

    /**
     * remove screens from back stack
     */
    fun removeScreens(screen: Array<out Screens>)

    /**
     * get current fragment instance
     */
    fun getCurrentScreenFragment(): Fragment?

    /**
     * get current screen
     */
    fun getCurrentScreen(): Screens?

    /**
     * remove all screens from back stack
     */
    fun removeAllScreens()
}