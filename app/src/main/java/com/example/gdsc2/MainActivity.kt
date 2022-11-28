package com.example.gdsc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.min


class MainActivity : AppCompatActivity() {
    // predefine varaibles for elements in XML

    lateinit var textClock: TextView
    lateinit var minuteInput:EditText
    lateinit var secondInput:EditText
    lateinit var resetButton:Button
    lateinit var toggleButton:Button


    // global variables

    // A flag indicating if the timer is running


    // Time Remaining
    var remainingTime  = 0

    //  Our countdown timer
    lateinit var countDownTimer: CountDownTimer


    // when this activity starts:
    //  onCreate will be run once
    override fun onCreate(savedInstanceState: Bundle?) {

        // Default initialization, don't touch these two lines

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  Below this line, we add our own initialization code

        //  find element IDs from the XML

        resetButton = findViewById(R.id.resetButton)
        toggleButton = findViewById(R.id.toggleButton)
        textClock = findViewById(R.id.textClock)
        minuteInput = findViewById(R.id.minuteInput)
        secondInput= findViewById(R.id.secondInput)


        //  Change the status bar text

        supportActionBar?.title = "GDSC Countdown Timer"


        //  when toggleButton clicks

        toggleButton.setOnClickListener {

            // error detection of invalid input
            // the program will crash on empty input without this detection

            if(minuteInput.text.toString() == "" || minuteInput.text.toString().toInt() < 0 || minuteInput.text.toString().toInt() >= 60){
                minuteInput.setError("Your input for minutes is invalid.")
                return@setOnClickListener
            }
            if(secondInput.text.toString() == "" ||secondInput.text.toString().toInt() < 0 || secondInput.text.toString().toInt() >= 60){
                secondInput.setError("Your input for seconds is invalid.")
                return@setOnClickListener
            }

            // pass the inputs and transform them into variables(in Int)

            val minute  = Integer.parseInt(minuteInput.text.toString())
            val second  = Integer.parseInt(secondInput.text.toString())


            // sets remaining time

            remainingTime =  /* sets remaining time */ ;




            if(/*  the flag of timer status is stopped*/ ){

                toggleButton.text = "stop"                 // change the text of toggle button

                //  Start the timer with the value we set previously
                countDownTimer = object: CountDownTimer(remainingTime*1000L, 1000L){

                    override fun onTick(RawTime: Long) {
                        // update remainingTime to ticked value

                        remainingTime = (RawTime/1000).toInt()

                        // parse remainingTime into normal view

                        val secondNumber = remainingTime % 60
                        val minuteNumber =(remainingTime - secondNumber)/60

                        //add extra zeros on one-digit second/minute number

                        val secondStr = if(secondNumber < 10) "0$secondNumber" else secondNumber.toString()
                        val minuteStr = if(minuteNumber < 10) "0$minuteNumber" else minuteNumber.toString()

                        // change the text of textClock
                        textClock.text = "$minuteStr:$secondStr"

                    }

                    override fun onFinish() {
                        // change the toggleButton text to "start"
                        toggleButton.text = "start"



                        // Start a new activity called "FlashActivity"


                        // hide the reset button

                    }
                }

                }
                countDownTimer.start()





        }

        //  Handle the reset button click
        //  This stops and resets the timer
        resetButton.setOnClickListener {
            if( remainingTime != 0){

                //  Stop the timer
                countDownTimer.cancel()

                //  Reset the statuses
                remainingTime = 0

                //  Reset the texts
                textClock.text = "00:00"
                toggleButton.text = "Start"

                //  Hide the button after being clicked
                resetButton.visibility = View.GONE
            }
        }
    }
}