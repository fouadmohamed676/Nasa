package com.fouad.nasa.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fouad.nasa.R
import com.fouad.nasa.databinding.DetialsItemBinding
import com.squareup.picasso.Picasso

class DetailsActivity :AppCompatActivity(R.layout.activity_second) {
    private lateinit var binding : DetialsItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DetialsItemBinding.inflate(layoutInflater)
//        intent.putExtra("id",photo.)
//        intent.putExtra("sol",photo.)
//        intent.putExtra("camera",photo.camera.getString("id"))
//        intent.putExtra("camera",photo.camera.getString("name"))
//        intent.putExtra("",photo.camera.getString("full_name"))
//        intent.putExtra("rover",photo.rover.getString("name"))
//        intent.putExtra("rover",photo.rover.getString("status"))
//        intent.putExtra("rover",photo.rover.getString("max_date"))
//        intent.putExtra("",photo.img_src)
        val id=intent.getStringExtra("id")
        val sol=intent.getStringExtra("sol")
        val img_src=intent.getStringExtra("img_src")
        val photo=intent.getStringExtra("photo")
//        val id=intent.getStringExtra("id")
        Log.e("response","$photo")
//        Picasso.get().load(img_src+intent.getStringExtra("image")).into(binding.imageDet)
    }

}