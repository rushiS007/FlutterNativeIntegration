package com.example.integrate20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.flutter.embedding.android.FlutterFragment

class FlutterFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_fragment)
        val fragment=FlutterFragment.withCachedEngine("flutter_fragment_id")
            .build<FlutterFragment>()

        supportFragmentManager.beginTransaction()
            .add(R.id.layout_fragment, fragment).commit()

    }
}