package com.fouad.nasa.Network

object BaseUrl {
    private  const val key:String="?sol=1000&api_key=DEMO_KEY"
    private const val baseURL: String = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"
    const val photos: String = baseURL+"photos$key"
}