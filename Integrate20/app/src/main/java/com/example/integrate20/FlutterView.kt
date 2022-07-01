package com.example.integrate20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FlutterView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_view)
//        val layoutManager = LinearLayoutManager(this)
//        val myAdapter=MyAdapter()
//        recyclerView.layoutManager=layoutManager
//        recyclerView.adapter=myAdapter
        val rv=findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager=LinearLayoutManager(this)
        rv.layoutManager=layoutManager
        rv.adapter=MyAdapter()

    }
}