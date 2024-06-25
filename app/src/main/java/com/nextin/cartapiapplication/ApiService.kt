package com.nextin.cartapiapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("carts")
    fun getCartData():Call<MyData>
}