package com.noober.image.photoview.component;

/**
 * Created by xiaoqi on 2018/5/22
 */
public interface OnGestureListener {

    void onDrag(float dx, float dy);

    void onFling(float startX, float startY, float velocityX, float velocityY);

    void onScale(float scaleFactor, float focusX, float focusY);
}
