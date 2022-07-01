package com.example.integrate20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import io.flutter.embedding.android.FlutterView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FlutterEngine(this).let {
            it.navigationChannel.setInitialRoute("/")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            FlutterEngineCache.getInstance().put("my_engine_id",it)
        }


//        startActivity(FlutterActivity.withCachedEngine("my_engine_id").build(this))
        FlutterEngine(this).let {
            it.navigationChannel.setInitialRoute("/demo")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            FlutterEngineCache.getInstance().put("flutter_fragment_id",it)
        }

        FlutterEngine(this).let {
            it.lifecycleChannel.appIsResumed()
            it.navigationChannel.setInitialRoute("/cell")
            it.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            FlutterEngineCache.getInstance().put("flutter_view_id",it)
        }

    }


    fun flutterFragment(view: View) {
        val intent=Intent()
        intent.setClass(this,com.example.integrate20.FlutterFragment::class.java)
        startActivity(intent)
    }

    fun flutterView(view: View) {

        val intent=Intent()
        intent.setClass(this,com.example.integrate20.FlutterView::class.java)
        startActivity(intent)
    }
}

