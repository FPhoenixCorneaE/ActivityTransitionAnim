package com.wkz.activitytransition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class OverridePendingTransitionActivity1 extends BaseActivity implements View.OnClickListener {

    /**
     * 使用 overridePendingTransition 方法实现Activity过渡动画
     */
    private Button mBtnOverridePendingTransition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_override_pending_transition1);
        initView();
    }

    private void initView() {
        mBtnOverridePendingTransition = (Button) findViewById(R.id.btnOverridePendingTransition);
        mBtnOverridePendingTransition.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnOverridePendingTransition:
                startActivity(new Intent(mContext, OverridePendingTransitionActivity2.class));
                break;
        }
    }
}
