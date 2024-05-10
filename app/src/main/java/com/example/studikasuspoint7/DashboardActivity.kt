package com.example.studikasuspoint7

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView: RecyclerView = findViewById(R.id.rv_news)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = loadJsonDataFromAsset(this, "listnews.json")
        val adapter = ItemAdapter(items)
        recyclerView.adapter = adapter

    }



    fun loadJsonDataFromAsset(context: Context, fileName: String): List<News> {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, Array<News>::class.java).toList()
    }


}

