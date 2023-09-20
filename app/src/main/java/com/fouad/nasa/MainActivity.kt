package com.fouad.nasa

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.nasa.Network.BaseUrl
import com.fouad.nasa.databinding.ActivityMainBinding
import com.fouad.nasa.ui.DetailsActivity
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            val intent =Intent(this,DetailsActivity::class.java)
            startActivity(intent)
        }
    }




}