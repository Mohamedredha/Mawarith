package com.mohamedreda.mawarith

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val btn_start = findViewById<Button>(R.id.btn_start)
        val et_name = findViewById<AppCompatEditText>(R.id.et_name)


        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this, "please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,QuizQuestionActivity::class.java)
                startActivity(intent)
                finish()
            }
    }
}}