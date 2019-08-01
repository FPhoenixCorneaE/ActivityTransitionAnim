package com.wkz.activitytransition;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

public class ActivityOptionsShareElementActivity1 extends BaseActivity implements View.OnClickListener {

    private ImageView mIvRedCircle;
    /**
     * share element text
     */
    private TextView mTvRedText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_options_share_element_1);
        initView();

        // 设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
        getWindow().setEnterTransition(new Slide(Gravity.END));
        getWindow().setExitTransition(new Slide(Gravity.BOTTOM));

        // 设置ShareElementTransition,指定的ShareElement会执行这个Transition动画
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTarget(mIvRedCircle);
        transitionSet.addTarget(mTvRedText);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);
        getWindow().setSharedElementReenterTransition(transitionSet);
        getWindow().setSharedElementReturnTransition(transitionSet);
        getWindow().setSharedElementsUseOverlay(true);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
    }

    private void initView() {
        mIvRedCircle = (ImageView) findViewById(R.id.mIvRedCircle);
        mIvRedCircle.setOnClickListener(this);
        mTvRedText = (TextView) findViewById(R.id.mTvRedText);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mIvRedCircle:
                Pair<View, String>[] shareElementPairs = TransitionHelper.createSafeTransitionParticipants(
                        this, true, TransitionHelper.createPairArray(mIvRedCircle, mTvRedText)
                );
                startActivity(new Intent(mContext, ActivityOptionsShareElementActivity2.class),
                        ActivityOptionsCompat.makeSceneTransitionAnimation(mContext,
                                shareElementPairs).toBundle());
                break;
        }
    }
}
