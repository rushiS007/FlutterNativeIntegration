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
import android.os.BatteryManager
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.flutter.embedding.android.FlutterView
import io.flutter.plugin.common.MethodChannel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val flutterFragment1=FlutterFragment.withCachedEngine("flutter_fragment1_id").build<FlutterFragment>()
//        loadFragment(BlankFragment())
//        val bottomNav=findViewById<BottomNavigationView>(R.id.bottomNav)
//        bottomNav.setOnNavigationItemReselectedListener {
//            val f=when(it.itemId){
//                R.id.home-> {
//                    BlankFragment()
//                }
////                R.id.message-> {
////                    FlutterView()
////                }
////                R.id.settings->{
////                    FlutterView2()
////                }
//                else ->{
//                    BlankFragment()
//                }
//            }
//            loadFragment(f)
//
//        }

    }

    private fun loadFragment(fragment: Fragment){
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(com.google.android.material.R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
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

    fun flutterView2(view: View) {
        val intent=Intent()
        intent.setClass(this,com.example.integrate20.FlutterView2::class.java)
        startActivity(intent)
    }

    private fun getBatteryLevel():Int{
        val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
        val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
        val batteryPct = level * 100 / scale.toFloat()
        print("batteryPct")
        println( batteryPct)

        return batteryPct.toInt()
    }
}

