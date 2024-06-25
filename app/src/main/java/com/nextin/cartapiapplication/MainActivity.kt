package com.nextin.cartapiapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.nextin.cartapiapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
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


        retrofitData.enqueue(object  :Callback<MyData>{
            override fun onResponse(p0: Call<MyData>, p1: Response<MyData>) {
                val responseBody = p1.body()
                val cartData = responseBody!!.carts

                binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                val myAdapter = MyAdapter(this@MainActivity, cartData)

                binding.recyclerView.adapter=myAdapter
            }
            override fun onFailure(p0: Call<MyData>, p1: Throwable) {
                Log.e("Main Activity ","Failed because ${p1.message} ")
            }
        })
    }
}