package com.coding.meet.photopickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

class SingleVideoPickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_video_pick)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val singleVideoPickerBtn = findViewById<Button>(R.id.singleVideoPickerBtn)
        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        val singleVideoLauncher =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()){uri ->
                videoView.setVideoURI(uri)
                // here every every you should play
                // so,
                videoView.start()
            }

        singleVideoPickerBtn.setOnClickListener {
            singleVideoLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly)
            )
        }
    }
}