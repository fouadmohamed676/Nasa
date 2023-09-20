package com.fouad.nasa

import android.annotation.SuppressLint
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
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val urlData = BaseUrl.photos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addData()
    }
    private fun addData() {
//        loadingPB.visibility = View.VISIBLE
        val queue = Volley.newRequestQueue(this@MainActivity)

        val request: StringRequest =
            object : StringRequest(Request.Method.GET, urlData, object : Response.Listener<String?> {
                @SuppressLint("SuspiciousIndentation")
                override fun onResponse(response: String?) {

                    // hiding our progress bar.
                    Toast.makeText(this@MainActivity, "Data Updated..", Toast.LENGTH_SHORT).show()
                    try {
                        // on below line we are extracting data from our json object
                        // and passing our response to our json object.
                        val jsonObject = response?.let { JSONObject(it) }
                        val jsonArrayInfo = jsonObject?.getJSONArray("photos")
                        val size: Int = jsonArrayInfo!!.length()
                        for (i in 0 until size) {
                            val jsonObjectDetails: JSONObject = jsonArrayInfo.getJSONObject(i)
                            val photo = Photo(
                                jsonObjectDetails.getLong("sol"),
                                jsonObjectDetails.getString("earth_date"),
                                jsonObjectDetails.getLong("id"),
                                jsonObjectDetails.getJSONObject("camera"),
                                jsonObjectDetails.getJSONObject("rover"),
                                jsonObjectDetails.getString("img_src"),
                            )
                            Log.e("Response  -  : ","Success response ${photo.id}")

                        }


                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    // displaying toast message on response failure.
                    Log.e("tag", "error is " + error!!.message)
                    Toast.makeText(this@MainActivity, "Fail to update data..", Toast.LENGTH_SHORT)
                        .show()
                }
            }) {
                override fun getParams(): Map<String, String>? {
                    val params: MutableMap<String, String> = HashMap()
                    return params
                }
            }
        queue.add(request)
    }





}