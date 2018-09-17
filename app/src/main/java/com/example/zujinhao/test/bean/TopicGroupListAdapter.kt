package com.example.zujinhao.test.bean

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.zujinhao.test.R
import java.util.ArrayList

/**
 * Author: jzu
 * Date: 2018/9/17
 * Function:
 */
class TopicGroupListAdapter(val context:Context) : RecyclerView.Adapter<TopicViewHolder>() {

    private val data : ArrayList<TopicGroup> = ArrayList<TopicGroup>()
    private var currentId : Int? = 0
    private var targetData = ArrayList<Topic>()



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TopicViewHolder {
        return TopicViewHolder(LayoutInflater.from(context).inflate(R.layout.item_topic,parent,false))
    }

    override fun getItemCount(): Int = targetData.size

    override fun onBindViewHolder(holder: TopicViewHolder?, position: Int) {
        holder?.setTitle(targetData[position].title)
    }

    fun setData(arrayData : Collection<TopicGroup>){
        data.clear()
        data.addAll(arrayData)
    }

    fun setCurrentId(id : Int){
        currentId = id;

        for (topicGroup in data){
            if (topicGroup.id == currentId){
                targetData = topicGroup.content
                notifyDataSetChanged()
                break
            }
        }
    }

    fun setDefaultId(){
        currentId = data[0].id
        targetData = data[0].content
        notifyDataSetChanged()

    }

}


class TopicViewHolder : RecyclerView.ViewHolder {
    val titleText : TextView
    constructor(itemView: View) : super(itemView){
        titleText = itemView.findViewById(R.id.tvTitle)
    }


    fun setTitle(title : String){
        titleText.text = title
    }
}