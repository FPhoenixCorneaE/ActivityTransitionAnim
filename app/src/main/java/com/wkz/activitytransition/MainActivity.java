package com.wkz.activitytransition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

public class MainActivity extends BaseActivity implements View.OnClickListener {

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
        setContentView(R.layout.activity_main);
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
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnOverridePendingTransition:
                startActivity(new Intent(mContext, OverridePendingTransitionActivity1.class));
                break;
            case R.id.btnAnimStyle:
                startActivity(new Intent(mContext, AnimStyleActivity1.class));
                break;
            case R.id.btnActivityOptions:
                Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants(this, true);
                startActivity(new Intent(mContext, ActivityOptionsActivity1.class), ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, pairs).toBundle());
                break;
            case R.id.btnActivityOptionsStyle:
                Pair<View, String>[] stylePairs = TransitionHelper.createSafeTransitionParticipants(this, true);
                startActivity(new Intent(mContext, ActivityOptionsStyleActivity1.class), ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, stylePairs).toBundle());
                break;
            case R.id.btnActivityOptionsShareElement:
                startActivity(new Intent(mContext, ActivityOptionsShareElementActivity1.class), ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, mBtnActivityOptionsShareElement, getString(R.string.activity_options_share_element_1)).toBundle());
                break;
        }
    }
}
