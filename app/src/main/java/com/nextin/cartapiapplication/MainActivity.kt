package com.nextin.cartapiapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.nextin.cartapiapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val builder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val retrofitData = builder.getCartData()

        retrofitData.enqueue(object :Callback<Cart>{
            override fun onResponse(p0: Call<Cart>, response: Response<Cart>) {

                val responseBody = response.body()
                val cartProduct = responseBody?.products!!

                val strBuilder = StringBuilder()
                for (index in  cartProduct.indices){
                    strBuilder.append(index)
                }
                binding.textView.text = strBuilder
            }

            override fun onFailure(p0: Call<Cart>, error: Throwable) {
                Log.d("Error" , "Given is error "+error.localizedMessage)
            }

        })
    }
}