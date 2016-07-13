package com.example.admin.myappwechat.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by admin on 2016/7/7.
 */
public class WeChatPageAdapter extends PagerAdapter {

    private final ArrayList<View> views;
    private final Context context;

    public WeChatPageAdapter(ArrayList<View> views, Context context) {
        this.views = views;
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
         container.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
