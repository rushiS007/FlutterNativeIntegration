package com.example.integrate20

import android.view.LayoutInflater
import android.view.View
//import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.flutter.embedding.engine.FlutterEngineCache
//import kotlinx.android.synthetic.main.item_card.view.*
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine

class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var flutterView: FlutterView? = null
    private var flutterEngine: FlutterEngine? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)

        flutterView = FlutterView(parent.context)
        flutterEngine = FlutterEngineCache.getInstance().get("flutter_view_id")

        return MyViewHolder(mView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        holder as MyViewHolder
        if (position == 4) {
            holder.cardView.addView(flutterView)
            flutterEngine?.let { flutterView?.attachToFlutterEngine(it) }
        } else {
            holder.cardText.text = position.toString()
        }

    }

    override fun getItemCount(): Int {
        return 10
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: FrameLayout = itemView.findViewById(R.id.layout_card)
        var cardText: TextView = itemView.findViewById(R.id.text_card)
    }
}