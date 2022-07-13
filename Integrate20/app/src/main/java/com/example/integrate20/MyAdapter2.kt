package com.example.integrate20

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
//import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import io.flutter.embedding.engine.FlutterEngineCache
//import kotlinx.android.synthetic.main.item_card.view.*
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine

class MyAdapter2 : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var flutterView2: FlutterView? = null
    private var flutterEngine: FlutterEngine? = null
    var num : Int = 0
    lateinit var btn:Button

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card2, parent, false)

        flutterView2 = FlutterView(parent.context)
        flutterEngine = FlutterEngineCache.getInstance().get("my_engine_id")

        return MyViewHolder(mView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        holder as MyViewHolder
        if (position == 3) {
            holder.cardView.addView(flutterView2)
            flutterEngine?.let { flutterView2?.attachToFlutterEngine(it) }
        } else {
//             btn= findViewById(R.id.button2)
//            num = increment(btn)
            holder.cardText.text = position.toString()
        }
    }




//    fun increment(view:View):Int{
//        num++
//        return num
//    }

    override fun getItemCount(): Int {
        return 10
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: FrameLayout = itemView.findViewById(R.id.layout_card)
        var cardText: TextView = itemView.findViewById(R.id.text_card)
    }
}