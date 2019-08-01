package com.wkz.activitytransition;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

public class ActivityOptionsShareElementFragment2 extends Fragment implements View.OnClickListener {

    private ImageView mIvWhiteCircle;
    private TextView mTvWhiteText;
    private ConstraintLayout mClRoot;

    public static ActivityOptionsShareElementFragment2 newInstance() {
        return new ActivityOptionsShareElementFragment2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_activity_options_share_element_2, container, false);
        initView(contentView);
        setTransition();
        return contentView;
    }

    private void initView(View contentView) {
        mIvWhiteCircle = contentView.findViewById(R.id.mIvWhiteCircle);
        mIvWhiteCircle.setOnClickListener(this);
        mTvWhiteText = contentView.findViewById(R.id.mTvWhiteText);
        mClRoot = contentView.findViewById(R.id.mClRoot);
    }

    private void setTransition() {
        // Transition for fragment1
        Slide slideTransition = new Slide(Gravity.END);
        slideTransition.setDuration(500);
        setEnterTransition(slideTransition);
        setReenterTransition(slideTransition);
        setExitTransition(slideTransition);
        // 设置ShareElementTransition,指定的ShareElement会执行这个Transition动画
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTarget(mIvWhiteCircle);
        transitionSet.addTarget(mTvWhiteText);
        setSharedElementEnterTransition(transitionSet);
        setSharedElementReturnTransition(transitionSet);
        setAllowEnterTransitionOverlap(true);
        setAllowReturnTransitionOverlap(true);
    }

    @Override
    public void onClick(View v) {
        if (v == mIvWhiteCircle) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.mFlContainer, ActivityOptionsShareElementFragment1.newInstance())
                    .addToBackStack(null)
                    .addSharedElement(mIvWhiteCircle, mIvWhiteCircle.getTransitionName())
                    .addSharedElement(mTvWhiteText, mTvWhiteText.getTransitionName())
                    .commit();
        }
    }
}
