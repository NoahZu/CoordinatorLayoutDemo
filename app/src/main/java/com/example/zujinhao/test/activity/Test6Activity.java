package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zujinhao.test.fragment.CustomBottomSheetDialogFragment;
import com.example.zujinhao.test.R;

import java.util.ArrayList;
import java.util.List;

public class Test6Activity extends BaseActivity implements View.OnClickListener {

    // BottomSheetBehavior variable
    private BottomSheetBehavior bottomSheetBehavior;

    // TextView variable
    private TextView bottomSheetHeading;

    // Button variables
    private Button expandBottomSheetButton;
    private Button collapseBottomSheetButton;
    private Button hideBottomSheetButton;
    private Button showBottomSheetDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test6);

        initViews();
        initListeners();


    }

    /**
     * method to initialize the views
     */
    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetLayout));
        bottomSheetHeading = (TextView) findViewById(R.id.bottomSheetHeading);
        expandBottomSheetButton = (Button) findViewById(R.id.expand_bottom_sheet_button);
        collapseBottomSheetButton = (Button) findViewById(R.id.collapse_bottom_sheet_button);
        hideBottomSheetButton = (Button) findViewById(R.id.hide_bottom_sheet_button);
        showBottomSheetDialogButton = (Button) findViewById(R.id.show_bottom_sheet_dialog_button);


    }


    /**
     * method to initialize the listeners
     */
    private void initListeners() {
        // register the listener for button click
        expandBottomSheetButton.setOnClickListener(this);
        collapseBottomSheetButton.setOnClickListener(this);
        hideBottomSheetButton.setOnClickListener(this);
        showBottomSheetDialogButton.setOnClickListener(this);

        // Capturing the callbacks for bottom sheet
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {

                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    bottomSheetHeading.setText("text_collapse_me");
                } else {
                    bottomSheetHeading.setText("text_expand_me");
                }

                // Check Logs to see how bottom sheets behaves
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.e("Bottom Sheet Behaviour", "STATE_COLLAPSED");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.e("Bottom Sheet Behaviour", "STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.e("Bottom Sheet Behaviour", "STATE_EXPANDED");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.e("Bottom Sheet Behaviour", "STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.e("Bottom Sheet Behaviour", "STATE_SETTLING");
                        break;
                }
            }


            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });


    }

    /**
     * onClick Listener to capture button click
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.collapse_bottom_sheet_button:
                // Collapsing the bottom sheet
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.expand_bottom_sheet_button:
                // Expanding the bottom sheet
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.hide_bottom_sheet_button:
                // Hiding the bottom sheet
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.show_bottom_sheet_dialog_button:
                CustomBottomSheetDialogFragment customBottomSheetDialogFragment = new CustomBottomSheetDialogFragment();
                List<String> items = new ArrayList<String>();
                customBottomSheetDialogFragment.setItemData("我很可爱1","我很可爱2","我很可爱3","我很可爱4");
                customBottomSheetDialogFragment.show(getSupportFragmentManager(),"dialog");
                break;

        }
    }
}