package com.example.apiuse

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        // Build Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://real-time-news-data.p.rapidapi.com/") // Base URL for the news API
            .addConverterFactory(GsonConverterFactory.create())   // Use Gson for JSON parsing
            .build()
            .create(ApiInterface::class.java)

        // Make an API call to get news headlines
        val call = retrofit.getTopHeadlines(
            country = "US",
            language = "en",
            limit = 500,
            apiKey = "5f4f0939ddmsh37728f0e0b39793p13e9aajsn72c861191c8c",
            apiHost = "real-time-news-data.p.rapidapi.com"
        )

        call.enqueue(object : Callback <MyData> { // Adjust the response type to List<MyData>
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                if (response.isSuccessful) {
                    Log.d("MainActivityffff", "API call successful")
                    val newsList = response.body() ?: emptyList()// Handle null response
                    myAdapter = MyAdapter(newsList, this@MainActivity)
                    recyclerView.adapter = myAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                } else {
                    Log.e("MainActivitrgy", "API call failed with code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Log.e("MainActivityefef", "API call failed: ${t.message}")
            }
        })
    }
}