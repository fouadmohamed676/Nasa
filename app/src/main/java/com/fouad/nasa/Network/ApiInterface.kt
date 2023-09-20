package com.fouad.nasa.Network

import com.android.volley.Response
import com.fouad.nasa.Data
import retrofit2.http.GET

interface ApiInterface {
//    @GET("/pations/")
//     fun getuser() : Response<User>
    @GET(BaseUrl.photos)
//    suspend fun getAllUsers(): Response<Locals>
    suspend fun getAllUsers(): Response<Data>
}