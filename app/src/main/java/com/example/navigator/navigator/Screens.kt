package com.example.navigator.navigator

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.example.navigator.fragments.SampleOneFragment
import com.example.navigator.fragments.SampleTwoFragment
import kotlinx.android.parcel.Parcelize

/**
 * Available screens.
 */
enum class Screens {

    // All screens
    SCREEN_ONE { override val fragmentClass = SampleOneFragment::class.java },
    SCREEN_TWO { override val fragmentClass = SampleTwoFragment::class.java },
    ;
    abstract val fragmentClass: Class<out Fragment>
}