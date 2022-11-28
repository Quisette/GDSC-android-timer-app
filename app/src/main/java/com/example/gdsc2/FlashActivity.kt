package com.example.gdsc2

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button

class FlashActivity : AppCompatActivity() {

    //  XML object predifination

    //  Our media player to play media


    //  Our countdown timer




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)

        //  grab objects from XML


        // Set the media player up


        //  changes the top bar text
        supportActionBar!!.title = "Time's up!"

        //  flag for indicating animation states
        var flag : Boolean = false

        //  start playing the sound


        //  this countdown timer will tick per 250 milliseconds , and will last for 10 seconds.


        // start the timer


        // when "back" button is clicked, this acitvity will be closed

    }


    // on touching back button on the nav bar:
    override fun onBackPressed() {

        super.onBackPressed()

        // stop the timer in case it alarms when we close it


    }
}