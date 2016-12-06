package com.github.clans.fab;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

public class FloatingActionButtonBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    private int mToolbarHeight = -1;
    private final boolean USE_TRANSLATION=false;

    public FloatingActionButtonBehavior() {
        super();
    }

    public FloatingActionButtonBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout
                || dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child,
                                          View dependency) {
        if (dependency instanceof Snackbar.SnackbarLayout) {
            return updateFabTranslationForSnackbar(parent, child, dependency);
        } else if (dependency instanceof AppBarLayout) {
            // If we're depending on an AppBarLayout we will show/hide it automatically
            // if the FAB is anchored to the AppBarLayout
            return updateFabVisibility(parent, (AppBarLayout) dependency, child);
        }
        return false;
    }

    private boolean updateFabTranslationForSnackbar(CoordinatorLayout parent,
                                                 final FloatingActionButton fab, View snackbar) {
        if (fab.getVisibility() != View.VISIBLE) {
            return false;
        }

        if (mToolbarHeight == -1)
            mToolbarHeight = Util.getToolbarHeight(parent.getContext());

        final CoordinatorLayout.LayoutParams lp =
                (CoordinatorLayout.LayoutParams) fab.getLayoutParams();

        if (lp.getAnchorId() != -1) {
            return false;
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            float translationY;
            translationY = Math.min(0, snackbar.getTranslationY() - snackbar.getHeight());
            fab.setTranslationY(translationY);
        }else{
            if (snackbar.getTop()<0.0)
                fab.hide(true);
            else
                fab.show(true);
        }

        return true;
    }

    private boolean updateFabVisibility(CoordinatorLayout parent,
                                        AppBarLayout appBarLayout, FloatingActionButton fab) {

        final CoordinatorLayout.LayoutParams lp =
                (CoordinatorLayout.LayoutParams) fab.getLayoutParams();

        if (lp.getAnchorId()!=-1 && lp.getAnchorId() != appBarLayout.getId()) {
            // The anchor ID doesn't match the dependency, so we won't automatically
            // show/hide the FAB
            return false;
        }

        if (mToolbarHeight == -1)
            mToolbarHeight = Util.getToolbarHeight(parent.getContext());

        if (USE_TRANSLATION && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            float translationY;
            int famBottomMargin = lp.bottomMargin;
            int height = fab.getHeight();
            int distanceToScroll = height + famBottomMargin;
            float ratio = appBarLayout.getY() / (float) mToolbarHeight;
            translationY = -distanceToScroll * ratio;

            fab.setTranslationY(translationY);
        }else{
            if (appBarLayout.getTop()<-mToolbarHeight*4/5)
                fab.hide(true);
            else
                fab.show(true);
        }

        return true;
    }

}