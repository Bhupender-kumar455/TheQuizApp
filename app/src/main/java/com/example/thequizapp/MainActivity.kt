package com.example.thequizapp

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val etName = findViewById<EditText>(R.id.etName)

        btnStart.setOnClickListener {
            if(etName.text.toString().isEmpty()){
                Toast.makeText(this,"Enter your name please",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
              intent.putExtra(Constant.USER_NAME,etName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}

