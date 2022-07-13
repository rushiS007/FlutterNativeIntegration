package com.example.integrate20
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class MyAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var flutterView: FlutterView? = null
    private var flutterView3:FlutterView?=null
    private var flutterEngine: FlutterEngine? = null
    private var flutterEngine3:FlutterEngine? = null


    private val MESSAGE_CHANNEL="rushi.com/message"
    private lateinit var channel1:MethodChannel
    var num : Int = 0
    var msg:String="messaging coming"
    lateinit var btn:Button

    var content="the"
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val mView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)

        flutterView = FlutterView(parent.context)
        flutterView3= FlutterView(parent.context)

        flutterEngine = FlutterEngineCache.getInstance().get("flutter_view_id")
        flutterEngine3=FlutterEngineCache.getInstance().get("flutter_demo_id")


//        flutterEngine3.let {
//            it?.lifecycleChannel?.appIsResumed()
//            it?.navigationChannel?.setInitialRoute("/demo")
//            it?.dartExecutor?.executeDartEntrypoint(
//                DartExecutor.DartEntrypoint.createDefault()
//            )
//            channel1=
//                it?.dartExecutor?.binaryMessenger?.let { it1 -> MethodChannel(it1,MESSAGE_CHANNEL) }!!
//            MethodChannel(it?.dartExecutor?.binaryMessenger!!,MESSAGE_CHANNEL).setMethodCallHandler{
//                    call,
//                    result -> val argData=call.argument<String>("message")
//                println(argData)
//                msg=argData?:"no data"
//            }
//        }


        return MyViewHolder(mView)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {


        holder as MyViewHolder
        when (position) {
            0 -> {
                holder.cardView.addView(flutterView3)
                flutterEngine3?.let { flutterView3?.attachToFlutterEngine(it) }
            }

            1 -> {
                holder.cardView.addView(flutterView)
                flutterEngine?.let { flutterView?.attachToFlutterEngine(it) }
            }
            else -> {
                holder.cardText.text=content
            }
        }
    }



    fun setContents(content:String){
        this.content=content
    }

    override fun getItemCount(): Int {
        return 3
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: FrameLayout = itemView.findViewById(R.id.layout_card)
        var cardText: TextView = itemView.findViewById(R.id.text_card)
    }
}