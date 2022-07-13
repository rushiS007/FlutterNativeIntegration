package com.example.integrate20

import android.content.Context
import android.os.BatteryManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class FlutterView2 : FlutterActivity() {
    private val BATTERY_CHANNEL="rushi.com/battery"
//    private  lateinit var channel:MethodChannel


//    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
//        super.configureFlutterEngine(flutterEngine)
//        channel= MethodChannel(flutterEngine.dartExecutor.binaryMessenger,BATTERY_CHANNEL)
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_view2)

        val rv=findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager=LinearLayoutManager(this)
        rv.layoutManager=layoutManager
        rv.adapter=MyAdapter2()

    }


}