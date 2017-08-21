package com.example.zujinhao.test;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

/**
 * Created by zujinhao on 2017/8/17.
 */

public class AppbarLayoutForbidOpenBehavior extends AppBarLayout.Behavior {
    private boolean canOpen = false;

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout parent, AppBarLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        if (canOpen){
            return super.onStartNestedScroll(parent, child, directTargetChild, target, nestedScrollAxes);
        }
        return canOpen;
    }

    public boolean isCanOpen() {
        return canOpen;
    }

    public void setCanOpen(boolean canOpen) {
        this.canOpen = canOpen;
    }
}
