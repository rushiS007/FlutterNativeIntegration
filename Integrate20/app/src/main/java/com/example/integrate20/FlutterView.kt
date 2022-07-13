package com.example.integrate20
import android.os.BatteryManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class FlutterView : FlutterActivity() {
    private val BATTERY_CHANNEL="rushi.com/battery"
    private val MESSAGE_CHANNEL="rushi.com/message"
//    private  lateinit var channel:MethodChannel
    private  lateinit var channel1:MethodChannel
    private lateinit var msg:String
    private lateinit var flutterEngine2:FlutterEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_view)
        val textView2=findViewById<TextView>(R.id.textView2)

        flutterEngine2= FlutterEngineCache.getInstance().get("flutter_demo_id")!!
        flutterEngine2.let {

            channel1 = MethodChannel(it.dartExecutor.binaryMessenger, MESSAGE_CHANNEL)
            FlutterEngineCache.getInstance().put("flutter_demo_id", it)
            channel1.setMethodCallHandler { call,
                                            result ->
                val argData = call.argument<String>("message")
                println(argData)
                msg = "args data is $argData" ?: "no data"
                val txtView = findViewById<TextView>(R.id.textView2)
                txtView.setText("Recieved from flutter :$msg")

                println(msg)
            }
        }

        var content=""
        val rv=findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager=LinearLayoutManager(this)
        rv.layoutManager=layoutManager
        val queue= Volley.newRequestQueue(context)
        val  url = "https://jsonplaceholder.typicode.com/todos/1"



        val stringRequest= StringRequest(
            Request.Method.GET,url,
            { response ->
                content=response.substring(40,58)
                textView2.text=response.substring(0,83)
                var adapter=MyAdapter()
                rv.adapter=adapter
                adapter.setContents(content)
                adapter.notifyDataSetChanged()
            },
            { content="That didn't work!"}
        )
        queue.add(stringRequest)
    }

    fun getMessage():String{
        return msg
    }



}