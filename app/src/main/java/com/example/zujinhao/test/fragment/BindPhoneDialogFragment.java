package com.example.zujinhao.test.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.utils.UIUtil;

/**
 * Created by zujinhao on 2017/7/5.
 */

public class BindPhoneDialogFragment extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        return inflater.inflate(R.layout.layout_bind_phone,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams layoutParams = getDialog().getWindow().getAttributes();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = UIUtil.dip2px(getContext(),300);
        layoutParams.height = UIUtil.dip2px(getContext(),300);
        layoutParams.gravity = Gravity.CENTER;
        getDialog().getWindow().setAttributes(layoutParams);
    }
}
