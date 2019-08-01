package com.wkz.activitytransition;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

public class ActivityOptionsShareElementActivity3 extends BaseActivity {


    private FrameLayout mFlContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_options_share_element_3);
        initView();
        initData();
    }

    private void initView() {
        mFlContainer = (FrameLayout) findViewById(R.id.mFlContainer);
    }

    private void initData() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.mFlContainer, ActivityOptionsShareElementFragment1.newInstance())
                .commit();
    }
}
