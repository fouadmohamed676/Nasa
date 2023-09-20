package com.fouad.nasa

import org.json.JSONObject

data class Photo(
    val sol: String,
    val earthDate: String,
    val id: String,
    val camera: JSONObject,
    val rover: JSONObject,
    val img_src: String
)
