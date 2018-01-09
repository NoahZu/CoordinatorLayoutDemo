package com.example.zujinhao.test.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.fragment.BindPhoneDialogFragment;
import com.example.zujinhao.test.other.UIToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_1:
                startActivity(new Intent(MainActivity.this,Test1Activity.class));
                break;
            case R.id.btn_2:
                startActivity(new Intent(MainActivity.this,Test2Activity.class));
                break;
            case R.id.btn_3:
                startActivity(new Intent(MainActivity.this,Test3Activity.class));
                break;
            case R.id.btn_4:
                startActivity(new Intent(MainActivity.this,Test4Activity.class));
                break;
            case R.id.btn_5:
                startActivity(new Intent(MainActivity.this,Test5Activity.class));
                break;
            case R.id.btn_6:
                startActivity(new Intent(MainActivity.this,Test6Activity.class));
                break;
            case R.id.btn_7:
                showDialog();
                break;
            case R.id.btn_8:
                startActivity(new Intent(MainActivity.this,Test7Activity.class));
                break;
            case R.id.btn_9:
                startActivity(new Intent(MainActivity.this,ScrollerTestActivity.class));
                break;
            case R.id.btn_10:
                startActivity(new Intent(MainActivity.this,RecyclerViewSnapHelperTestActivity.class));
                break;
            case R.id.btn_11:
                startActivity(new Intent(MainActivity.this,DrawLayoutActivity.class));
                break;
            case R.id.btn_12:
                startActivity(new Intent(MainActivity.this,DrawableTestActivity.class));
                break;
            case R.id.btn_14:
                startActivity(new Intent(MainActivity.this,LiveRoomActivity.class));
                break;
            case R.id.btn_toast:
                UIToast.show(MainActivity.this,"这个Toast显示不显示呢？？？？");
                break;
            case R.id.btn_rotate:
                startActivity(new Intent(MainActivity.this,RotateActivity.class));
                break;
            case R.id.btn_juanchi:
                startActivity(new Intent(MainActivity.this,RulerActivity.class));
                break;
            case R.id.btn_anim:
                startActivity(new Intent(MainActivity.this,AnimTextActivity.class));
                break;
            case R.id.btn_radio_flex_box:
                startActivity(new Intent(MainActivity.this,RadioFlexboxLayoutActivity.class));
                break;
            case R.id.btn_constraintLayout:
                startActivity(new Intent(MainActivity.this,ConstraintLayoutActivity.class));
                break;
        }
    }

    private void showDialog() {
        new BindPhoneDialogFragment().show(getSupportFragmentManager(),"bind");
    }
}
