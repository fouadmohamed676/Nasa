package com.fouad.nasa.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.fouad.nasa.Network.BaseUrl
import com.fouad.nasa.Photo
import com.fouad.nasa.R
import com.fouad.nasa.adapter.PhotoAdapter
import com.fouad.nasa.databinding.ActivityDetailsBinding
import org.json.JSONException
import org.json.JSONObject

class DetailsActivity :AppCompatActivity(R.layout.activity_details) {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerView: RecyclerView
    private  val photoArrayList: ArrayList<Photo> = ArrayList()
    private lateinit var adapter: PhotoAdapter


    val urlData = BaseUrl.photos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = LinearLayoutManager(this)
        binding.recyclerData.layoutManager = layoutManager
        binding.recyclerData.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerData.setHasFixedSize(true)
        getData()
    }

    private fun getData() {
        val queue = Volley.newRequestQueue(this@DetailsActivity)
        val request: StringRequest =
            object : StringRequest(Request.Method.GET, urlData, object : Response.Listener<String?> {
                @SuppressLint("SuspiciousIndentation")
                override fun onResponse(response: String?) {
                    // hiding our progress bar.
                    Toast.makeText(this@DetailsActivity, "Data Updated..", Toast.LENGTH_SHORT).show()
                    try {
                        // on below line we are extracting data from our json object
                        // and passing our response to our json object.
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
                            Log.e("Response  : ","Success")
                            adapter = PhotoAdapter(photoArrayList)
                            binding.recyclerData.adapter=adapter
                            photoArrayList.add(photo)
                        }

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }, Response.ErrorListener { error ->
                // displaying toast message on response failure.
                Log.e("Error Response", "error is " + error!!.message)
                Toast.makeText(this@DetailsActivity, "Fail to update data..", Toast.LENGTH_SHORT)
                    .show()
            })
            {
                override fun getParams(): Map<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    return params
                }
            }
        queue.add(request)
    }


}