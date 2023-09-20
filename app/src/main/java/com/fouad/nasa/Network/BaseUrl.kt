package com.fouad.nasa.Network

object BaseUrl {
    private  const val key:String="?sol=1000&api_key=DEMO_KEY"
    private const val baseURL: String = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"
    const val photos: String = baseURL+"photos/$key"
    const val image_rl: String = "https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/"
    const val my_images="http://mars.jpl.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/01000/opgs/edr/fcam/FLB_486265257EDR_F0481570FHAZ00323M_.JPG"
}