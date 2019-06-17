package com.wkz.activitytransition;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected Activity mContext;
    protected boolean shouldOverridePending;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (shouldOverridePending) {
            // 跳转时，第一个参数为下一个页面的进入动画，第二个参数为当前页面的退出动画
            overridePendingTransition(R.anim.rotate_down_in, R.anim.rotate_down_out);
        }
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    public void finish() {
        super.finish();
        if (shouldOverridePending) {
            // 返回时，第一个参数为上一个页面的进入动画，第二个参数为当前页面的退出动画
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }
    }
}
