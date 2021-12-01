package com.inaki.countrylistapp

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // here we are not setting the fragment by using the support fragment manager

        // we are loading hte fragment statically from the activity XML file
    }
}