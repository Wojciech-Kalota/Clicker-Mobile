package me.regos.myfirstapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import java.util.prefs.Preferences


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hide()

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        val btnClickMe = findViewById<Button>(R.id.mybutton)

        var timesClicked = sharedPref.getInt("timesClicked", 0)
        btnClickMe.text = timesClicked.toString()


        btnClickMe.setOnClickListener() {

            timesClicked++
            editor.apply{
                putInt("timesClicked", timesClicked)
                apply()
            }
            hide()

            btnClickMe.text = timesClicked.toString()
        }

    }

    fun hide() {
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}


