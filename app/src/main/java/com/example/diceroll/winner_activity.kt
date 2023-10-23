package com.example.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroll.databinding.ActivityMainBinding
import com.example.diceroll.databinding.ActivityWinnerBinding

class winner_activity : AppCompatActivity() {
    private val binding: ActivityWinnerBinding by lazy {
        ActivityWinnerBinding.inflate(layoutInflater)
    }
    companion object{
        const val NAME_EXTRA =  "name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val winner = intent.getStringExtra(NAME_EXTRA)
        binding.finalWinner.text = "The winner is :\n $winner"
    }
}