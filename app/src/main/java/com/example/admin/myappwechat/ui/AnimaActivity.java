package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.myappwechat.R;

/**
 * Created by admin on 2016/7/6.
 */
public class AnimaActivity extends Activity {

    private ImageView mLeft;
    private ImageView mRight;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anima);


        mLeft = (ImageView)findViewById(R.id.imageLeft);
        mRight = (ImageView)findViewById(R.id.imageRight);
        mText = (TextView)findViewById(R.id.anim_text);

        AnimationSet set = new AnimationSet(true);

        TranslateAnimation ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-1f,
                Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0);
        ta.setDuration(2000);
        set.setStartOffset(800);
        set.addAnimation(ta);
        set.setFillAfter(true);
        mLeft.startAnimation(set);


        AnimationSet set1 = new AnimationSet(true);
        TranslateAnimation ta1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,1f,
                Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0);
        ta1.setDuration(1500);
        set1.setStartOffset(800);
        set1.addAnimation(ta1);
        set1.setFillAfter(true);
        mRight.startAnimation(set1);



        AnimationSet set2 = new AnimationSet(true);
        ScaleAnimation ta2 = new ScaleAnimation(1.0f,3.0f,1.0f,3.0f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        AlphaAnimation al = new AlphaAnimation(1.0f,0.0001f);
        ta2.setDuration(1000);
        al.setDuration(1500);
        set2.addAnimation(ta2);
        set2.addAnimation(al);
        set2.setFillAfter(true);
        mText.startAnimation(set2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(AnimaActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2300);
    }
}
