package com.example.zujinhao.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.google.android.flexbox.FlexboxLayout;

/**
 * Created by zujinhao on 2017/11/9.
 * 结合了RadioGroup和FlexboxLayout的功能
 */

public class RadioFlexboxLayout extends FlexboxLayout {

    private RadioButton mCheckedRadio = null;
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    private boolean mProtectFromCheckedChange = false;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private PassThroughHierarchyChangeListener mPassThroughListener;



    public RadioFlexboxLayout(Context context) {
        this(context,null);
    }

    public RadioFlexboxLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mChildOnCheckedChangeListener = new CheckedStateTracker();
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
    }




    private class PassThroughHierarchyChangeListener implements
            OnHierarchyChangeListener {
        private OnHierarchyChangeListener mOnHierarchyChangeListener;

        public void onChildViewAdded(View parent, View child) {
            if (parent == RadioFlexboxLayout.this && child instanceof RadioButton) {
                int id = child.getId();
                ((RadioButton) child).setOnCheckedChangeListener(
                        mChildOnCheckedChangeListener);
            }

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }

        public void onChildViewRemoved(View parent, View child) {
            if (parent == RadioFlexboxLayout.this && child instanceof RadioButton) {
                ((RadioButton) child).setOnCheckedChangeListener(null);
            }

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
    }

    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (mProtectFromCheckedChange) {
                return;
            }

            mProtectFromCheckedChange = true;
            if (mCheckedRadio != null) {
                mCheckedRadio.setChecked(false);
            }
            mCheckedRadio = (RadioButton) buttonView;
            mProtectFromCheckedChange = false;

            setCheckedView();
        }
    }

    private void setCheckedView() {
        mCheckedRadio.setChecked(true);
        if (mOnCheckedChangeListener != null){
            mOnCheckedChangeListener.onCheckedChanged(this,mCheckedRadio);
        }
    }


    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener){
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }


    public interface OnCheckedChangeListener{
        void onCheckedChanged(RadioFlexboxLayout radioFlexboxLayout, RadioButton radioButton);
    }
}
