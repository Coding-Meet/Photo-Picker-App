package com.coding.meet.photopickerapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class LoadVideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_video)

        val videoView = findViewById<VideoView>(R.id.videoView)

        // local video file load
        videoView.setVideoURI(Uri.parse("android.resource://"+ packageName+"/"+R.raw.video))

        //  Url = online video file load
//        videoView.setVideoPath("https://github.com/Coding-Meet/Change-Theme-And-Font-App/raw/master/video/video.mp4")

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

    }
}