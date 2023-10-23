package com.example.diceroll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.diceroll.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var currentPlayer:Int = 1
    private var playerOneScore:Int = 0
    private var playerTwoScore:Int = 0
    private var winningScore:Int = 50
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        currentPlayer = 1
        binding.rollButton.setOnClickListener {
            val random = Random.nextInt(6) + 1
            val drawableResource = when (random) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            binding.dice.setImageResource(drawableResource)

            //update player value scores


            if(currentPlayer == 1)
            {
                playerOneScore += random
                binding.firstPlayer.text = playerOneScore.toString()
                currentPlayer = 2
            }
            else
            {
                playerTwoScore += random
                binding.secondPlayer.text = playerTwoScore.toString()
                currentPlayer = 1
            }
            binding.currentPlayer.text = currentPlayer.toString()

            // check player reach a winnig numebr
            val intent = Intent(this, winner_activity::class.java)
            if(playerOneScore >= winningScore)
            {
                binding.winningText.visibility = View.VISIBLE
                binding.winningText.text = "Player one won🎉🎉🎊"
                intent.putExtra(winner_activity.NAME_EXTRA , "Player One")
                startActivity(intent)
            }
            else if(playerTwoScore >= winningScore)
            {
                binding.winningText.visibility = View.VISIBLE
                binding.winningText.text = "Player two won🎉🎉🎊"
                intent.putExtra(winner_activity.NAME_EXTRA , "Player Two")
                startActivity(intent)
            }
        }
    }
}