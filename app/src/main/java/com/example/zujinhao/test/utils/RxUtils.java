package com.example.zujinhao.test.utils;

import android.view.View;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * Created by zhangyubao on 2017/11/21.
 */

public class RxUtils {

    public static Observable<Integer> clickView(@NonNull View view) {
        checkNoNull(view);
        return Observable.create(new ClickOneSubscribe(view));
    }


    private static <T> void checkNoNull(T value) {
        if (value == null) {
            throw new NullPointerException("generic value here is null");
        }
    }

    private static class ClickOneSubscribe implements ObservableOnSubscribe<Integer> {

        private View view;
        public ClickOneSubscribe(View view) {
            this.view = view;
        }

        @Override
        public void subscribe(@NonNull final ObservableEmitter subscriber) throws Exception {
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    subscriber.onNext(0);
                }
            };
            view.setOnClickListener(clickListener);
        }
    }
}
