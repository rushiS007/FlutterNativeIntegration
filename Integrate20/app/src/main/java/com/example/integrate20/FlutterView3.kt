package com.example.integrate20

import android.content.Context
import android.os.BatteryManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel
import org.json.JSONArray
import org.json.JSONObject

class FlutterView3 : FlutterActivity() {

    private val MESSAGE_CHANNEL="rushi.com/message"
    private  lateinit var channel1:MethodChannel
    private lateinit var msg:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_view3)
        val textView2=findViewById<TextView>(R.id.textView2)
        FlutterEngineCache.getInstance().get("flutter_demo_id").let {
            channel1=
                it?.dartExecutor?.binaryMessenger?.let { it1 -> MethodChannel(it1,MESSAGE_CHANNEL) }!!
            channel1.setMethodCallHandler{
                    call,
                    result -> val argData=call.argument<String>("message")
                println(argData)
                msg="args data is $argData"?:"no data"
                textView2.setText("Recieved from flutter :$msg")
                println(msg)
            }
        }
    }

}