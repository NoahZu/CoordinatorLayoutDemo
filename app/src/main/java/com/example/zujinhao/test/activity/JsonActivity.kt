package com.example.zujinhao.test.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.zujinhao.test.R
import com.example.zujinhao.test.bean.TestBean
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_json.*

class JsonActivity : AppCompatActivity() {

    val json = "{\"a\": 1,\"b\": 2,\"c\":3}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        btnConvert.setOnClickListener{
            val bean = Gson().fromJson<TestBean>(json,TestBean::class.java)

            bean.toString()
        }
    }
}
