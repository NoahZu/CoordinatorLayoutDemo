package com.example.zujinhao.test.xhs

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.RelativeLayout
import com.example.zujinhao.test.R
import kotlinx.android.synthetic.main.layout_xhs_text.view.*

class XhsTextView : RelativeLayout {

    var onDeleteFunc : ((view : XhsTextView) -> Unit)? = null
    private lateinit var activeBackDrawable : Drawable
    var status : XhsTextStatus = XhsTextStatus.NORMAL

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_xhs_text,this)
        activeBackDrawable = resources.getDrawable(R.drawable.bg_xhs_text)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        closeBtn.setOnClickListener{
            onDeleteFunc?.invoke(this)
        }
    }

    fun setTextContent(content : String){
        textContent.text = content
    }


    fun normal(){
        status = XhsTextStatus.NORMAL
        notifyStatusChange()

    }

    fun active(){
        status = XhsTextStatus.ACTIVE
        notifyStatusChange()
    }

    private fun notifyStatusChange(){
        when(status){
            XhsTextStatus.NORMAL -> {
                closeBtn.visibility = View.GONE
                textContent.background = null
            }
            XhsTextStatus.ACTIVE -> {
                closeBtn.visibility = View.VISIBLE
                textContent.background = activeBackDrawable
            }
        }
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        println("========dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }


    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }
}