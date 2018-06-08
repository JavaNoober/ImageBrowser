package com.noober.image.photoview.component;

import android.content.Context;
import android.os.Build;

import com.noober.image.photoview.gestures.CupcakeGestureDetector;
import com.noober.image.photoview.gestures.EclairGestureDetector;
import com.noober.image.photoview.gestures.FroyoGestureDetector;

/**
 * Created by xiaoqi on 2018/5/22
 */
public final class VersionedGestureDetector {

    public static GestureDetector newInstance(Context context,
                                              OnGestureListener listener) {
        final int sdkVersion = Build.VERSION.SDK_INT;
        GestureDetector detector;

        if (sdkVersion < Build.VERSION_CODES.ECLAIR) {
            detector = new CupcakeGestureDetector(context);
        } else if (sdkVersion < Build.VERSION_CODES.FROYO) {
            detector = new EclairGestureDetector(context);
        } else {
            detector = new FroyoGestureDetector(context);
        }

        detector.setOnGestureListener(listener);

        return detector;
    }

}
