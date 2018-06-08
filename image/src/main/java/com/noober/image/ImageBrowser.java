package com.noober.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.noober.image.photoview.PhotoView;
import com.noober.image.util.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaoqi on 18/6/8
 */
public class ImageBrowser extends FrameLayout {

    private final static String TAG = "ImageWatcher";

    private final static String VIEW_TAG = "PHOTOVIEW";

    private List<String> imageList;

    private ImageViewPager viewPager;
    private ImagePagerAdapter imagePagerAdapter;

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
        viewPager.setOffscreenPageLimit(imageList.size() / 2 + 1);
        imagePagerAdapter.notifyDataSetChanged();
    }

    public ImageBrowser(@NonNull Context context) {
        super(context);
        init();
    }

    public ImageBrowser(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageBrowser(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        imageList = new ArrayList<>();
        viewPager = new ImageViewPager(getContext());
        viewPager.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imagePagerAdapter = new ImagePagerAdapter();
        viewPager.setAdapter(imagePagerAdapter);
        addView(viewPager);
    }

    class ImagePagerAdapter extends PagerAdapter {

        List<View> viewList = new ArrayList<>();

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View contentView = null;
            if (viewList.size() > position) {
                contentView = viewList.get(position);
            }
            if (contentView == null) {
                contentView = LayoutInflater.from(getContext()).inflate(R.layout.layout_pic, container, false);
                container.addView(contentView);
                viewList.add(contentView);
            }
            PhotoView photoView = contentView.findViewById(R.id.photoview);
            photoView.setZoomable(false);
            Glide.with(ImageBrowser.this).load(imageList.get(position)).into(photoView);
            return contentView;
        }
    }
}
