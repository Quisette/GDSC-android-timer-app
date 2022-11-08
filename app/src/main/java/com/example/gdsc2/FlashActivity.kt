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
    lateinit var view: View
    lateinit var backButton: Button

    //  Our media player to play media
    lateinit var  mediaPlayer: MediaPlayer

    //  Our countdown timer
    lateinit var countDownTimer: CountDownTimer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)

        //  grab objects from XML
        view = findViewById(R.id.view)
        backButton= findViewById(R.id.backButton)

        // Set the media player up
        mediaPlayer = MediaPlayer.create( this, R.raw.se)

        //  changes the top bar text
        supportActionBar!!.title = "Time's up!"

        //  flag for indicating animation states
        var flag : Boolean = false

        //  start playing the sound
        mediaPlayer.start()

        //  this countdown timer will tick per 250 milliseconds , and will last for 10 seconds.
        countDownTimer = object: CountDownTimer(10000, 250){

            override fun onTick(millisUntilFinished: Long) {

                //  Changes the color of view
                view.setBackgroundColor(Color.parseColor(if(flag) "#FFBF00" else "#FFFFFF"))

                //  set the state of animation
                flag = !flag
            }
            override fun onFinish() {
            }

        }

        countDownTimer.start()

        // when "back" button is clicked:
        backButton.setOnClickListener{
            countDownTimer.cancel()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        countDownTimer.cancel()
    }
}