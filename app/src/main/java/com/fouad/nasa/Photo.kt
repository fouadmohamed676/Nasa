package com.fouad.nasa

import org.json.JSONObject

data class Photo(
    val sol: Long,
    val earthDate: String,
    val id: Long,
    val camera: JSONObject,
    val rover: JSONObject,
    val img_src: String
)
