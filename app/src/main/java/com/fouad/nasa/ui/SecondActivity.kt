package com.fouad.nasa.ui

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.nasa.Network.BaseUrl
import com.fouad.nasa.Photo
import com.fouad.nasa.R
import com.fouad.nasa.adapter.PhotoAdapter
import com.fouad.nasa.databinding.ActivitySecondBinding
import org.json.JSONException
import org.json.JSONObject

@Suppress("DEPRECATION")
class SecondActivity :AppCompatActivity(R.layout.activity_second) {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private  val photoArrayList: ArrayList<Photo> = ArrayList()
    private lateinit var adapter: PhotoAdapter
    private lateinit var progress :ProgressDialog

    val urlData = BaseUrl.photos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
        getData()
    }

    private fun getData() {
        progress_show()
        val queue = Volley.newRequestQueue(this@SecondActivity)
        val request: StringRequest =
            object :
                StringRequest(Request.Method.GET, urlData, object : Response.Listener<String?> {
                    @SuppressLint("SuspiciousIndentation")
                    override fun onResponse(response: String?) {
                        progress_cancel()
                        try {
                            Log.e("Success", "Response is: $response")
                            val jsonObject = response?.let { JSONObject(it) }
                            val jsonArrayInfo = jsonObject?.getJSONArray("photos")
                            val size: Int = jsonArrayInfo!!.length()
                            for (i in 0 until size) {
                                val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
                                val photo = Photo(
                                    jsonObjectDetails.getString("sol"),
                                    jsonObjectDetails.getString("earth_date"),
                                    jsonObjectDetails.getString("id"),
                                    jsonObjectDetails.getJSONObject("camera"),
                                    jsonObjectDetails.getJSONObject("rover"),
                                    jsonObjectDetails.getString("img_src"),
                                )
                                adapter = PhotoAdapter(photoArrayList)
                                binding.recyclerData.adapter = adapter
                                photoArrayList.add(photo)
                            }

                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    }
                }, Response.ErrorListener { error ->
                    // displaying toast message on response failure.
                    Log.e("Error Response", "error is " + error!!.message)
                    Toast.makeText(this@SecondActivity, "Fail to get data..", Toast.LENGTH_SHORT)
                        .show()
                })
            {}
        queue.add(request)
    }


    private fun setup(){

        progress= ProgressDialog(this)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerData.layoutManager = layoutManager
        binding.recyclerData.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerData.setHasFixedSize(true)
    }
    private fun progress_show(){
        progress.setTitle("Loading..")
        progress.setMessage("Please Waite..")
        progress.setCancelable(false)
        progress.show()
    }

    private fun progress_cancel(){
        progress.dismiss()
    }


}