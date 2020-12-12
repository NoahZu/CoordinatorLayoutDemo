package com.example.zujinhao.test.flutter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.flutter.embedding.android.FlutterFragment
import com.example.zujinhao.test.R

class TestFlutterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flutter)

        val fragment = FlutterFragment.withNewEngine()
                .initialRoute("home")
                .build<FlutterFragment>()
        supportFragmentManager.beginTransaction()
                .add(R.id.flutter_container, fragment)
                .commit();
    }
}