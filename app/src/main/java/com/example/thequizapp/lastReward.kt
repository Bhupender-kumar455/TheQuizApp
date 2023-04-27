package com.example.thequizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class lastReward : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_reward)

        val tvName :TextView = findViewById(R.id.userName)
        val score : TextView = findViewById(R.id.score)
        val finishBtn: Button = findViewById(R.id.finishButton)
        val correctAnswer = intent.getIntExtra(Constant.CORRECT_ANSWER,0)
        val totalQuestion :Int = intent.getIntExtra(Constant.TOTAL_QUESTION,0)
        score.text ="Your Score is $correctAnswer out of $totalQuestion"
       tvName.text = intent.getStringExtra(Constant.USER_NAME)

        finishBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}