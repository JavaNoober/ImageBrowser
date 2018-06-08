package com.noober.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.noober.image.photoview.PhotoView;
import com.noober.image.util.DisplayUtil;

/**
 * Created by xiaoqi on 18/6/8
 */
public class ImageViewPager extends ViewPager{

    private final static String TAG = "ImageViewPager";

    private int shift;

    private ViewDragHelper viewDragHelper;

    private View imageView;

    public ImageViewPager(@NonNull Context context) {
        super(context);
        init();
    }

    public ImageViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        shift = DisplayUtil.dip2px(getContext(), 50);
        viewDragHelper = ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
                return true;
            }

            @Override
            public void onViewCaptured(@NonNull View capturedChild, int activePointerId) {
                super.onViewCaptured(capturedChild, activePointerId);
                autoBackViewOriginLeft = capturedChild.getLeft();
                autoBackViewOriginTop = capturedChild.getTop();
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
                return top;
            }

            @Override
            public void onViewReleased(@NonNull View releasedChild, float xvel, float yvel) {
                super.onViewReleased(releasedChild, xvel, yvel);
                Log.e(TAG, "xvel:" + xvel + " yvel:" + yvel);
                viewDragHelper.settleCapturedViewAt(autoBackViewOriginLeft, autoBackViewOriginTop);
                invalidate();
                if (xvel > shift && yvel > shift) {

                } else {

                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }

    int autoBackViewOriginLeft;
    int autoBackViewOriginTop;
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
//        autoBackViewOriginLeft = imageView.getLeft();
//        autoBackViewOriginTop = imageView.getTop();
    }

}
