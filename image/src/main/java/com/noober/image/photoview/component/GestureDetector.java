package com.noober.image.photoview.component;

import android.view.MotionEvent;

/**
 * Created by xiaoqi on 2018/5/22
 */
public interface GestureDetector {

    boolean onTouchEvent(MotionEvent ev);

    boolean isScaling();

    boolean isDragging();

    void setOnGestureListener(OnGestureListener listener);
}
