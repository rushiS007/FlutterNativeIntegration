package com.example.integrate20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel
import org.w3c.dom.Text

class FlutterFragment : AppCompatActivity() {

    private var count:Int = 0
    private val ADDER_CHANNEL = "rushi.com/adder"
    private lateinit var channel:MethodChannel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_fragment)
        loadFragment(BlankFragment())
        FlutterEngine(this).let {
            it.lifecycleChannel.appIsResumed()
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            channel= MethodChannel(it.dartExecutor.binaryMessenger,ADDER_CHANNEL)
            FlutterEngineCache.getInstance().put("flutter_add_id",it)
        }
        findViewById<TextView>(R.id.textView3).text= count.toString()

//        val fragment=FlutterFragment.withCachedEngine("my_engine_id")
//            .build<FlutterFragment>()

//        supportFragmentManager.beginTransaction()
//            .add(R.id.linear_layout, fragment).commit()
    }
    private fun loadFragment(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(com.google.android.material.R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



    fun increment(view: View) {
        count++
        findViewById<TextView>(R.id.textView3).text = count.toString()
    }

}