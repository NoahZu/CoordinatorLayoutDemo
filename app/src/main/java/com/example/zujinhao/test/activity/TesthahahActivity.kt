package com.example.zujinhao.test.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zujinhao.test.R

class TesthahahActivity : AppCompatActivity() {

    val strArray = arrayListOf<String>(
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈",
            "哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testhahah)

        val rv = findViewById<RecyclerView>(R.id.recyclerview)
        rv.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL, false)
        rv.adapter = MyAdapter(this,strArray)
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textV = itemView.findViewById<TextView>(R.id.myTextView)
    }

    class MyAdapter(val context : Context,val data : ArrayList<String>) : RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_rv_haha, parent,false))
        }

        override fun getItemCount(): Int = data.size

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textV.text = data[position]
        }

    }
}