package com.wkz.activitytransition;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

public class ActivityOptionsShareElementActivity2 extends BaseActivity implements View.OnClickListener {

    private ImageView mIvBlackCircle;
    /**
     * share element text
     */
    private TextView mTvBlackText;
    private ConstraintLayout mClRoot;

    private boolean isChangeLocation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_options_share_element_2);
        initView();

        // 设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
        getWindow().setEnterTransition(new Slide(Gravity.TOP));
        getWindow().setExitTransition(new Slide(Gravity.BOTTOM));

        // 设置ShareElementTransition,指定的ShareElement会执行这个Transition动画
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTarget(mIvBlackCircle);
        transitionSet.addTarget(mTvBlackText);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);
        getWindow().setSharedElementReenterTransition(transitionSet);
        getWindow().setSharedElementReturnTransition(transitionSet);
        getWindow().setSharedElementsUseOverlay(true);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
    }

    private void initView() {
        mIvBlackCircle = (ImageView) findViewById(R.id.mIvBlackCircle);
        mIvBlackCircle.setOnClickListener(this);
        mTvBlackText = (TextView) findViewById(R.id.mTvBlackText);
        mClRoot = (ConstraintLayout) findViewById(R.id.mClRoot);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mIvBlackCircle:
                if (isChangeLocation) {
                    Pair<View, String>[] shareElementPairs = TransitionHelper.createSafeTransitionParticipants(
                            this, true, TransitionHelper.createPairArray(mIvBlackCircle, mTvBlackText)
                    );
                    startActivity(new Intent(mContext, ActivityOptionsShareElementActivity3.class),
                            ActivityOptionsCompat.makeSceneTransitionAnimation(mContext,
                                    shareElementPairs).toBundle());
                } else {
                    changeLocation();
                }
                break;
        }
    }

    private void changeLocation() {
        isChangeLocation = true;
        TransitionManager.beginDelayedTransition(mClRoot);

        ConstraintLayout.LayoutParams ivLayoutParams = (ConstraintLayout.LayoutParams) mIvBlackCircle.getLayoutParams();
        ivLayoutParams.width = (int) (ivLayoutParams.width * 1.8);
        ivLayoutParams.height = (int) (ivLayoutParams.height * 1.8);
        ivLayoutParams.topToTop = R.id.mClRoot;
        ivLayoutParams.startToStart = R.id.mClRoot;
        ivLayoutParams.endToEnd = R.id.mClRoot;
        ivLayoutParams.bottomToBottom = R.id.mClRoot;
        ivLayoutParams.verticalBias = 0.7F;
        mIvBlackCircle.setLayoutParams(ivLayoutParams);

        ConstraintLayout.LayoutParams tvLayoutParams = (ConstraintLayout.LayoutParams) mTvBlackText.getLayoutParams();
        tvLayoutParams.topToBottom = R.id.mIvBlackCircle;
        tvLayoutParams.topMargin = 20;
        tvLayoutParams.startToStart = R.id.mClRoot;
        tvLayoutParams.endToEnd = R.id.mClRoot;
        tvLayoutParams.bottomToBottom = 0;
        mTvBlackText.setLayoutParams(tvLayoutParams);

        mTvBlackText.setTextSize(20);
        mTvBlackText.setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}
