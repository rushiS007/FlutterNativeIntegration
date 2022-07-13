package com.example.integrate20

import android.content.Intent
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class SplashScreen : AppCompatActivity() {

    private val BATTERY_CHANNEL="rushi.com/battery"
    private val MESSAGE_CHANNEL="rushi.com/message"
    private  lateinit var channel: MethodChannel
    private lateinit var msg:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        FlutterEngine(this).let {
            it.navigationChannel.setInitialRoute("/secret")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            FlutterEngineCache.getInstance().put("my_engine_id",it)
        }

        FlutterEngine(this).let {
            it.navigationChannel.setInitialRoute("/")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            FlutterEngineCache.getInstance().put("flutter_fragment1_id",it)
        }

        FlutterEngine(this).let {
            it.lifecycleChannel.appIsResumed()
            it.navigationChannel.setInitialRoute("/cell")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            channel= MethodChannel(it.dartExecutor.binaryMessenger,BATTERY_CHANNEL)
            FlutterEngineCache.getInstance().put("flutter_view_id",it)
        }

        FlutterEngine(this).let {
//            it.lifecycleChannel.appIsResumed()
            it.navigationChannel.setInitialRoute("/demo")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
//            channel1= MethodChannel(it.dartExecutor.binaryMessenger,MESSAGE_CHANNEL)
            FlutterEngineCache.getInstance().put("flutter_demo_id", it)
//            channel1.setMethodCallHandler{
//                    call,
//                    result -> val argData=call.argument<String>("message")
//                println(argData)
//
//                msg= "args data is $argData"
//                val txtView = findViewById<TextView>(R.id.textView2)
////                txtView.setText("Recieved from flutter :$msg")
//
//                println(msg)
//            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val batteryLevel=getBatteryLevel()
            channel.invokeMethod("reportBatteryLevel",batteryLevel)
        },0 )
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //

    }

    private fun getBatteryLevel():Int{
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level * 100 / scale.toFloat()

        return batteryPct.toInt()
    }

}