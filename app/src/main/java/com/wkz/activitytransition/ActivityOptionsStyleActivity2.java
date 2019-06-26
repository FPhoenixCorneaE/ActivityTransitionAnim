package com.wkz.activitytransition;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.CircularPropagation;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ActivityOptionsStyleActivity2 extends BaseActivity implements View.OnClickListener {

    /**
     * 使用 overridePendingTransition 方法实现Activity过渡动画
     */
    private Button mBtnOverridePendingTransition;
    /**
     * 使用 style 方式实现Activity过渡动画
     */
    private Button mBtnAnimStyle;
    /**
     * 使用 ActivityOptions 实现Activity过渡动画
     */
    private Button mBtnActivityOptions;
    /**
     * 使用 ActivityOptions + style 实现Activity过渡动画
     */
    private Button mBtnActivityOptionsStyle;
    /**
     * 使用 ActivityOptions + 共享元素 实现Activity过渡动画
     */
    private Button mBtnActivityOptionsShareElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在setContentView()之前执行，用于告诉Window页面切换需要使用动画，默认是打开的，但不排除有些厂商修改
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(mContext, R.color.colorPrimary)));
        getWindow().setTransitionBackgroundFadeDuration(500L);

        setContentView(R.layout.activity_activity_options_2);
        initView();
    }

    private void initView() {
        mBtnOverridePendingTransition = (Button) findViewById(R.id.btnOverridePendingTransition);
        mBtnOverridePendingTransition.setOnClickListener(this);
        mBtnAnimStyle = (Button) findViewById(R.id.btnAnimStyle);
        mBtnAnimStyle.setOnClickListener(this);
        mBtnActivityOptions = (Button) findViewById(R.id.btnActivityOptions);
        mBtnActivityOptions.setOnClickListener(this);
        mBtnActivityOptionsStyle = (Button) findViewById(R.id.btnActivityOptionsStyle);
        mBtnActivityOptionsStyle.setOnClickListener(this);
        mBtnActivityOptionsShareElement = (Button) findViewById(R.id.btnActivityOptionsShareElement);
        mBtnActivityOptionsShareElement.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ActivityCompat.finishAfterTransition(mContext);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnOverridePendingTransition:
            case R.id.btnAnimStyle:
            case R.id.btnActivityOptions:
            case R.id.btnActivityOptionsStyle:
            case R.id.btnActivityOptionsShareElement:
                startActivity(new Intent(mContext, MainActivity.class));
                break;
        }
    }
}
