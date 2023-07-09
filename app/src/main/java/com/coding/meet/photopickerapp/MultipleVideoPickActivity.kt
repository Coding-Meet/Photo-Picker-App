package com.coding.meet.photopickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import android.widget.ViewFlipper
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

class MultipleVideoPickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiple_video_pick)
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation

        val multipleVideoPickLauncher =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia()){uris ->
                viewFlipper.removeAllViews()
                for (video in uris){
                    val videoView = VideoView(this)
                    videoView.setVideoURI(video)


                    val mediaController = MediaController(this)
                    videoView.setMediaController(mediaController)
                    mediaController.setAnchorView(videoView)
                    viewFlipper.addView(videoView)
                }

            }

        val mVideoPickBtn = findViewById<Button>(R.id.mVideoPickBtn)
        mVideoPickBtn.setOnClickListener {
            multipleVideoPickLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly)
            )
        }

        val previousBtn = findViewById<Button>(R.id.previousBtn)
        previousBtn.setOnClickListener {
            viewFlipper.showPrevious()
        }
        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            viewFlipper.showNext()
        }
    }
}