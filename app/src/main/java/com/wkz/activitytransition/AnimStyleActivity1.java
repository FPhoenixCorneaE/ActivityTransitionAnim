package com.wkz.activitytransition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class AnimStyleActivity1 extends BaseActivity implements View.OnClickListener {

    /**
     * 使用 AnimStyle 方式实现Activity过渡动画
     */
    private Button mBtnAnimStyle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_style_1);
        initView();
    }

    private void initView() {
        mBtnAnimStyle = (Button) findViewById(R.id.btnAnimStyle);
        mBtnAnimStyle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnAnimStyle:
                startActivity(new Intent(mContext, AnimStyleActivity2.class));
                break;
        }
    }
}
