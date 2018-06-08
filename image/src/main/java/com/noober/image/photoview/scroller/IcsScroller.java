package com.noober.image.photoview.scroller;

import android.annotation.TargetApi;
import android.content.Context;

/**
 * Created by xiaoqi on 2018/5/22
 */
@TargetApi(14)
public class IcsScroller extends GingerScroller {

    public IcsScroller(Context context) {
        super(context);
    }

    @Override
    public boolean computeScrollOffset() {
        return mScroller.computeScrollOffset();
    }

}
