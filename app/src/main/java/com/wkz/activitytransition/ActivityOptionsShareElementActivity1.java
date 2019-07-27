package com.wkz.activitytransition;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class ActivityOptionsShareElementActivity1 extends BaseActivity {

    private ImageView mIvRedCircle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_options_share_element_1);
        initView();

        // 设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new Fade());

        // 设置ShareElementTransition,指定的ShareElement会执行这个Transition动画
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTarget(mIvRedCircle);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);
    }

    private void initView() {
        mIvRedCircle = (ImageView) findViewById(R.id.mIvRedCircle);
    }
}
