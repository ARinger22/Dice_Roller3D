package com.example.diceroller

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.gesture.Gesture
import android.graphics.Rect
import android.graphics.RectF
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.GestureDetector
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.OverScroller
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.handleCoroutineException
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        var rollButton: Button=findViewById(R.id.roll_button)
        rollButton.text = "let's roll"
        diceImage = findViewById(R.id.dice_image)
        rollButton.setOnClickListener {
            Toast.makeText(this ,"Button Clicked", Toast.LENGTH_SHORT).show()
            animateRocket()
            rollDice()
            //animateRocket()
        }
    }

    private fun rollDice() {
        var resultText: TextView = findViewById(R.id.result_Text)
        var random = Random().nextInt(6) +1
        resultText.text = random.toString()
        val drawableResource = when(random)
        {
            1-> {
                R.drawable.dice_1
            }
            2-> R.drawable.dice_2
            3-> R.drawable.dice_3
            4-> R.drawable.dice_4
            5-> R.drawable.dice_5
            else -> {R.drawable.dice_6}
        }

        diceImage.setImageResource(drawableResource)

        //val rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_animation)
        //diceImage.animation = rotate
        //var diceImage : ImageView = findViewById(R.id.dice_image)
    }
    private fun animateRocket() {
        val rotate = AnimationUtils.loadAnimation(this,R.anim.rotate_animation)
        diceImage.animation = rotate

        var player = MediaPlayer.create(this ,R.raw.pop)
        player.start()

    }
}