package com.coding.meet.photopickerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageBtn = findViewById<Button>(R.id.imagePickBtn)
        imageBtn.setOnClickListener {
            startActivity(Intent(this,ImageActivity::class.java))
        }

        val loadVideoBtn = findViewById<Button>(R.id.loadVideoBtn)
        loadVideoBtn.setOnClickListener {
            startActivity(Intent(this,LoadVideoActivity::class.java))
        }


        val singleVideoPickBtn = findViewById<Button>(R.id.singleVideoPickBtn)
        singleVideoPickBtn.setOnClickListener {
            startActivity(Intent(this,SingleVideoPickActivity::class.java))
        }

        val multiplePickBtn = findViewById<Button>(R.id.multipleVidePickBtn)
        multiplePickBtn.setOnClickListener {
            startActivity(Intent(this,MultipleVideoPickActivity::class.java))
        }

    }
}