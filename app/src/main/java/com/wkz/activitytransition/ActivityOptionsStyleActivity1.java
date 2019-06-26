package com.wkz.activitytransition;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.transition.CircularPropagation;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

public class ActivityOptionsStyleActivity1 extends BaseActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_activity_options_1);
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
                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
                startActivity(new Intent(mContext, ActivityOptionsStyleActivity2.class), ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, pairs).toBundle());
                break;
        }
    }
}
