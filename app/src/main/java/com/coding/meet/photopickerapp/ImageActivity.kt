package com.coding.meet.photopickerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)


        /// Single Image Picker
        val outputImage = findViewById<ImageView>(R.id.outputImage)
        val singleImagePickerBtn = findViewById<Button>(R.id.singleImagePickBtn)
        val singlePhotoPickerLauncher =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri ->

                outputImage.setImageURI(uri)
            }
        singleImagePickerBtn.setOnClickListener {
            singlePhotoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }


        /// Multiple Image Pick
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        val inAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right)

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation

        val multiplePhotoPickLauncher =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia()){uris ->

                viewFlipper.removeAllViews()
                for (image in uris){
                    val imageView = ImageView(this)
                    imageView.setImageURI(image)
                    imageView.layoutParams = RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                    )
                    viewFlipper.addView(imageView)
                }
            }
        val multipleImagePickBtn = findViewById<Button>(R.id.multipleImagePickBtn)
        multipleImagePickBtn.setOnClickListener {
            multiplePhotoPickLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }
    }
}