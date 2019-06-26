package com.wkz.activitytransition;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for creating content transitions used with {@link android.app.ActivityOptions}.
 *
 * @author Administrator
 * @date 2019/06/26 18:02
 */
public class TransitionHelper {

    /**
     * Create the transition participants required during a activity transition while
     * avoiding glitches with the system UI.
     *
     * @param activity         The activity used as start for the transition.
     * @param includeStatusBar If false, the status bar will not be added as the transition
     *                         participant.
     * @return All transition participants.
     */
    @SafeVarargs
    public static Pair<View, String>[] createSafeTransitionParticipants(
            @NonNull Activity activity, boolean includeStatusBar, @Nullable Pair<View, String>... otherParticipants) {
        // Avoid system UI glitches as described here:
        // https://plus.google.com/+AlexLockwood/posts/RPtwZ5nNebb
        View decor = activity.getWindow().getDecorView();
        View statusBar = null;
        if (includeStatusBar) {
            statusBar = decor.findViewById(android.R.id.statusBarBackground);
        }
        View navBar = decor.findViewById(android.R.id.navigationBarBackground);

        // Create pair of transition participants.
        List<Pair<View, String>> participants = new ArrayList<>(3);
        addViewToTransitionParticipants(statusBar, participants);
        addViewToTransitionParticipants(navBar, participants);

        // only add transition participants if there's at least one none-null element
        if (otherParticipants != null) {
            for (Pair<View, String> pair : otherParticipants) {
                if (pair != null) {
                    participants.add(pair);
                }
            }
        }
        Pair<View, String>[] pairs = new Pair[participants.size()];
        return participants.toArray(pairs);
    }

    private static void addViewToTransitionParticipants(View view, List<Pair<View, String>> participants) {
        if (view == null) {
            return;
        }
        participants.add(new Pair<>(view, view.getTransitionName()));
    }
}
