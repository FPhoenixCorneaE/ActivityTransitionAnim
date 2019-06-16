package com.wkz.activitytransition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    /**
     * 使用 overridePendingTransition 方法实现Activity过渡动画
     */
    private Button mBtnOverridePendingTransition;
    /**
     * 使用 style 方式实现Activity过渡动画
     */
    private Button mBtnStyle;
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
        mBtnStyle = (Button) findViewById(R.id.btnStyle);
        mBtnStyle.setOnClickListener(this);
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
            case R.id.btnStyle:
                break;
            case R.id.btnActivityOptions:
                break;
            case R.id.btnActivityOptionsStyle:
                break;
            case R.id.btnActivityOptionsShareElement:
                break;
        }
    }
}
