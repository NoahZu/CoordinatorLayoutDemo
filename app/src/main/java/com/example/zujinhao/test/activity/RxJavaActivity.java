package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.other.UIToast;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaActivity extends BaseActivity {

    Observable<String> mStringObservable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        mStringObservable = Observable.just("Hello World");


        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStringObservable
                        .map(new Function<String, String>() {
                            @Override
                            public String apply(String s) throws Exception {
                                return s + "--- Noah";
                            }
                        })
                        .observeOn(Schedulers.io())
                        .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        UIToast.show(RxJavaActivity.this,s);
                    }
                });
            }
        });
    }
}
