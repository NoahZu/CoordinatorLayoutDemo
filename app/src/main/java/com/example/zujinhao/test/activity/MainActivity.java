package com.example.zujinhao.test.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.fragment.BindPhoneDialogFragment;
import com.example.zujinhao.test.fragment.DialogSheetFragment;
import com.example.zujinhao.test.other.UIToast;
import com.example.zujinhao.test.test.Test;

import component.noahzu.github.io.uirouter.UIRouter;

public class MainActivity extends BaseActivity {

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
            case R.id.btn_bottom_sheet:
                showBottomSheet();
                break;
            case R.id.btn_8:
                startActivity(new Intent(MainActivity.this,Test7Activity.class));
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
            case R.id.btn_draw_pic_text_in_bitmap:
                startActivity(new Intent(MainActivity.this,DrawPicTextInBitmapActivity.class));
                break;
            case R.id.btn_show_float_view:
                startActivity(new Intent(MainActivity.this,FloatingViewActivity.class));
                break;
            case R.id.btn_record:
                UIRouter.from(MainActivity.this).url("yizhibo://main/record").jump();
                break;
            case R.id.btn_okhttp:
                UIRouter.from(MainActivity.this).url("yizhibo://main/okhttp").jump();
                break;
            case R.id.btn_native:
                UIToast.show(this, Test.getString());
                break;
            case R.id.btn_rx:
                startActivity(new Intent(MainActivity.this,RxJavaActivity.class));
                break;
            case R.id.btn_aidl:
                startActivity(new Intent(MainActivity.this,AidlActivity.class));
                break;
            case R.id.btn_video_list:
                startActivity(new Intent(MainActivity.this,VideoListActivity.class));
                break;
            case R.id.vertical_muti_list:
                startActivity(new Intent(MainActivity.this,VerticalMutiListActivity.class));
                break;

        }
    }

    private void showBottomSheet() {
        DialogSheetFragment dialogSheetFragment = new DialogSheetFragment();
        dialogSheetFragment.show(getSupportFragmentManager(),"Music");

    }
}
