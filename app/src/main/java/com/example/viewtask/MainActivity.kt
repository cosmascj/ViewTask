package com.example.viewtask

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.sax.TextElementListener
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.internal.ContextUtils.getActivity
import kotlin.properties.Delegates

open class MainActivity : AppCompatActivity() {

    private lateinit var stateTextView: TextView
    private lateinit var orientationCounter: TextView
     var landScape = 0
    var  portrait = 0

    //The resource values or id of each text view is introduced with lateint
    // and var to make the mutable variable accessible to all functions within the main activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        stateTextView = findViewById(R.id.stateTextView)
        orientationCounter = findViewById(R.id.orientationCounter)
        stateTextView.text = "onCreate()"

        if (savedInstanceState != null) {
            portrait = savedInstanceState.getInt("portrait")
            landScape = savedInstanceState.getInt("landScape")

        }
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            landScape++
            orientationCounter.text = "Landscape: " + landScape

        } else {
            portrait++
            orientationCounter.text = "Portrait: " + portrait

        }
    }
        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putInt("portrait", portrait)
            outState.putInt("landScape", landScape)
        }

//The following methods will call the various stages of the activity life cycle

    override fun onStart() {
        super.onStart()
        val handler = Handler()
        //Introduce a handler to delay to display time for 3 seconds
        handler.postDelayed({

            stateTextView.text = "OnStart State"

        }, 2000)

    }

    override fun onResume() {
        super.onResume()
        var handler = Handler()
        handler.postDelayed({
            //Introduce a handler to delay to display time for 4 seconds

            stateTextView.text = "OnResume State"

        }, 4000)
    }

    override fun onPause() {
        super.onPause()
        var handler = Handler()
        handler.postDelayed({

            stateTextView.text = "onPause State"

        }, 1000)
    }

    override fun onStop() {
        super.onStop()
        var handler = Handler()
        handler.postDelayed({

            stateTextView.text = "onStop State"

        }, 5000)
    }
    override fun onDestroy() {
        super.onDestroy()
        //The onDestroy function marks the end pf the activity

        var handler = Handler()
        handler.postDelayed({
            stateTextView.text = "onDestroy State"

        }, 3000)
    }


}










