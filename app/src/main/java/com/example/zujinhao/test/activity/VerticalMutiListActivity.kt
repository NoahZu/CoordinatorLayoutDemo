package com.example.zujinhao.test.activity

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.zujinhao.test.R
import com.example.zujinhao.test.bean.Topic
import com.example.zujinhao.test.bean.TopicGroup
import com.example.zujinhao.test.bean.TopicGroupListAdapter
import com.example.zujinhao.test.other.UIUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_vertical_muti_list.*

class VerticalMutiListActivity : AppCompatActivity() {

    private var mCurrentId = -1
    private val topicGroupList : ArrayList<TopicGroup>
    private val topicAdapter = TopicGroupListAdapter(this)



    init {
        val type = object : TypeToken<ArrayList<TopicGroup>>(){}.type
        topicGroupList = ArrayList()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_muti_list)

        initRightContent()
        initLeftMenu()

        initData()

    }

    private fun initData() {

        val type = object : TypeToken<ArrayList<TopicGroup>>(){}.type
        topicGroupList.addAll(Gson().fromJson<ArrayList<TopicGroup>>(resources.getString(R.string.test_json),type))


        topicAdapter.setData(topicGroupList)
        topicAdapter.setDefaultId()

        setMenu()
    }

    private fun initRightContent() {
        rightContent.layoutManager = LinearLayoutManager(this, OrientationHelper.VERTICAL,false)
        rightContent.adapter = topicAdapter
    }

    private fun initLeftMenu() {

        leftMenu.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != mCurrentId){
                mCurrentId = checkedId;
                refreshRightContent()
            }
        }
    }

    private fun setMenu() {
        for (topicGroup in topicGroupList) {
            val radioButton = RadioButton(this)
            radioButton.tag = topicGroup.id
            radioButton.text = "${topicGroup.id}"
            radioButton.id = topicGroup.id
            radioButton.buttonDrawable = ColorDrawable(Color.TRANSPARENT)
            radioButton.background = resources.getDrawable(R.drawable.radio_drawable)
            radioButton.gravity = Gravity.CENTER



            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, UIUtils.dip2px(this, 50f))

            leftMenu.addView(radioButton, layoutParams)

        }

        (leftMenu.getChildAt(0) as RadioButton ).isChecked = true
    }


    private fun refreshRightContent(){
        topicAdapter.setCurrentId(mCurrentId)
    }


}
