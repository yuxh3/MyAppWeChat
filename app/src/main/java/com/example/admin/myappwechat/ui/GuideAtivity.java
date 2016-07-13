package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.adapter.MyPageAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/7/5.
 */
public class GuideAtivity extends Activity {
    @Bind(R.id.whatsnew_viewpager)
    ViewPager mViewpager;
    @Bind(R.id.page1)
    ImageView page1;
    @Bind(R.id.page2)
    ImageView page2;
    @Bind(R.id.page3)
    ImageView page3;
    @Bind(R.id.page4)
    ImageView page4;
    @Bind(R.id.page5)
    ImageView page5;
    @Bind(R.id.page0)
    ImageView page0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidle);
        ButterKnife.bind(this);
        initDate();
    }

    public void initDate() {


        View view1 = View.inflate(GuideAtivity.this, R.layout.guidle0, null);
        View view2 = View.inflate(GuideAtivity.this, R.layout.guidle1, null);
        View view3 = View.inflate(GuideAtivity.this, R.layout.guidle2, null);
        View view4 = View.inflate(GuideAtivity.this, R.layout.guidle3, null);
        View view5 = View.inflate(GuideAtivity.this, R.layout.guidle4, null);
        View view6 = View.inflate(GuideAtivity.this, R.layout.guidle5, null);

        ArrayList<View> views = new ArrayList<View>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);
        views.add(view6);

        mViewpager.setAdapter(new MyPageAdapter(GuideAtivity.this, views));

        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                // Log.i("TAG", "position:" + position + "positionOffset" + positionOffset + "positionOffsetPixels" + positionOffsetPixels);

                switch (position) {
                    case 0:
                        page0.setImageResource(R.drawable.page_now);
                        page1.setImageResource(R.drawable.page);
                        break;
                    case 1:
                        page0.setImageResource(R.drawable.page);
                        page1.setImageResource(R.drawable.page_now);
                        page2.setImageResource(R.drawable.page);
                        break;
                    case 2:
                        page1.setImageResource(R.drawable.page);
                        page2.setImageResource(R.drawable.page_now);
                        page3.setImageResource(R.drawable.page);
                        break;
                    case 3:
                        page2.setImageResource(R.drawable.page);
                        page3.setImageResource(R.drawable.page_now);
                        page4.setImageResource(R.drawable.page);
                        break;
                    case 4:
                        page3.setImageResource(R.drawable.page);
                        page4.setImageResource(R.drawable.page_now);
                        page5.setImageResource(R.drawable.page);
                        break;
                    case 5:
                        page4.setImageResource(R.drawable.page);
                        page5.setImageResource(R.drawable.page_now);
                        break;
                }

            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });
    }

    public void startClick(View view) {
        Intent intent = new Intent(GuideAtivity.this, AnimaActivity.class);
        startActivity(intent);
        finish();
    }
}
