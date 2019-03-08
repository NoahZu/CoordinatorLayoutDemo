package com.example.zujinhao.test.activity

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.Dimension
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.FrameLayout
import android.widget.TextView
import com.example.zujinhao.test.R
import com.example.zujinhao.test.other.UIUtils
import kotlinx.android.synthetic.main.activity_xhs_text.*

class XhsTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xhs_text)

        addTextButton.setOnClickListener {
            addAText()
        }

    }

    private fun addAText() {
        textContainer.addXhsText(this,"小红书")
    }
}
