package com.example.poultrysalesapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter
{
    private Context mContext;
    private int[] imgIds = new int[]{R.drawable.poultryimg, R.drawable.poultryiconi, R.drawable.poultryiconj, R.drawable.poultryicone, R.drawable.poultryiconf};


//    public ImageAdapter(Context mContext, int[] imgIds) {
//        this.mContext = mContext;
//        this.imgIds = imgIds;
//    }


    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
//        return 0;
        return imgIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return false;
        return  view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imgIds[position]);
        container.addView(imageView,0);
        return imageView;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((ImageView)object);

    }
}
