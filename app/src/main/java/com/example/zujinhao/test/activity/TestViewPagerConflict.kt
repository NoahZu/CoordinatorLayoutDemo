package com.example.zujinhao.test.activity

import android.app.ActionBar
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.example.zujinhao.test.R
import kotlinx.android.synthetic.main.activity_test_view_pager_conflict.*

class TestViewPagerConflict : AppCompatActivity() {

    lateinit var views : List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view_pager_conflict)

        val textView1 = TextView(this@TestViewPagerConflict).apply {
            text = "111"
            setSingleLine()
            gravity = Gravity.RIGHT
            setBackgroundColor(Color.parseColor("#44FF0000"))
            setOnClickListener {
                println("111")
            }
        }
        val textView2 = TextView(this@TestViewPagerConflict).apply {
            text = "222"
            setSingleLine()
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#4400FF00"))
            setOnClickListener {
                println("222")
            }
        }
        val textView3 = TextView(this@TestViewPagerConflict).apply {
            text = "333"
            setSingleLine()
            gravity = Gravity.CENTER
            setBackgroundColor(Color.parseColor("#440000FF"))
            setOnClickListener {
                println("333")
            }
        }

        views = listOf(textView1,textView2,textView3)


        mViewPager.adapter = object : PagerAdapter() {
            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view == `object`
            }

            override fun getCount(): Int = views.size

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                container.addView(views[position],ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
                return views[position]
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(views[position])
            }
        }
    }


}