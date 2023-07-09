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

    }
}