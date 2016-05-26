package com.anirudh.kotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import anirudh.com.explorekotlin.R
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    /**
     * Simple onclick listener for views
     * also contains implementation of when in Kotlin which replaces Switch in java
     * more powerful and clean as compared to Switch
     */
    override fun onClick(p0: View?) {
        when (p0) {
            btnToast -> Toast.makeText(this, "Hello Toast", Toast.LENGTH_LONG).show()
            btnSnackBar -> Snackbar.make(btnSnackBar, "Hello SnackBar", Snackbar.LENGTH_LONG).show()
            btnListView -> startActivity(Intent(this, SimpleListImplementationActivity::class.java)) //implementation of intent to start a activity
            else -> {
                //this will execute if no condition is match just like default in switch
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // set listener on views
        //listener can also be set for a single view using
        // btnSnackBar.setOnClickListener { View -> //do anything on click }

        btnToast.setOnClickListener(this)
        btnSnackBar.setOnClickListener(this)
        btnListView.setOnClickListener(this)
    }
}
