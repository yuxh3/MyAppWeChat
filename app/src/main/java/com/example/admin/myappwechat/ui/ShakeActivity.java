package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.Toast;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.utils.ShakeListener;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/12.
 */
public class ShakeActivity extends Activity {

    @Bind(R.id.btn_back)
    Button btnBack;
    @Bind(R.id.rl_top)
    RelativeLayout rlTop;
    @Bind(R.id.shakeImgUp)
    RelativeLayout shakeImgUp;
    @Bind(R.id.shakeImgDown)
    RelativeLayout shakeImgDown;
    @Bind(R.id.handle)
    Button handle;
    @Bind(R.id.slidingDrawer1)
    SlidingDrawer slidingDrawer1;
    private Vibrator mVibrator;
    private ShakeListener mShakeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        ButterKnife.bind(this);

        mVibrator = (Vibrator) getApplication().getSystemService(VIBRATOR_SERVICE);

        initData();

    }

    public void initData() {
        slidingDrawer1.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {

                handle.setBackgroundResource(R.drawable.btn_slid_drown);
                TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1.0f);
                animation.setDuration(300);
                animation.setFillAfter(true);
                rlTop.startAnimation(animation);

            }
        });
        slidingDrawer1.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {

                handle.setBackgroundResource(R.drawable.btn_slid_up);
                TranslateAnimation titledn = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, -1.0f, Animation.RELATIVE_TO_SELF, 0f);
                titledn.setDuration(300);
                titledn.setFillAfter(true);
                rlTop.startAnimation(titledn);
            }
        });

        mShakeListener = new ShakeListener(this);
        mShakeListener.setOnShakeListener(new ShakeListener.OnShakeListener() {
            @Override
            public void onShake() {
                startAnim();
                mShakeListener.stop();
                startVibrato();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast mToast;
                        mToast = Toast.makeText(ShakeActivity.this,"抱歉，暂时没有找到\n在同一时刻摇一摇的人。\n再试一次吧！",Toast.LENGTH_SHORT);
                        mToast.show();
                        //Utils.showToast(ShakeActivity.this, "抱歉，暂时没有找到\n在同一时刻摇一摇的人。\n再试一次吧！");
                        mVibrator.cancel();
                        mShakeListener.start();
                    }
                }, 2000);
            }
        });

    }

    public void startAnim () {   //定义摇一摇动画动画
        AnimationSet animup = new AnimationSet(true);
        TranslateAnimation mytranslateanimup0 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-0.7f);
        mytranslateanimup0.setDuration(1000);
        TranslateAnimation mytranslateanimup1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+0.7f);
        mytranslateanimup1.setDuration(1000);
        mytranslateanimup1.setStartOffset(1000);
        animup.addAnimation(mytranslateanimup0);
        animup.addAnimation(mytranslateanimup1);
        shakeImgUp.startAnimation(animup);

        AnimationSet animdn = new AnimationSet(true);
        TranslateAnimation mytranslateanimdn0 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+0.7f);
        mytranslateanimdn0.setDuration(1000);
        TranslateAnimation mytranslateanimdn1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-0.7f);
        mytranslateanimdn1.setDuration(1000);
        mytranslateanimdn1.setStartOffset(1000);
        animdn.addAnimation(mytranslateanimdn0);
        animdn.addAnimation(mytranslateanimdn1);
        shakeImgDown.startAnimation(animdn);
    }
    public void startVibrato(){		//定义震动
        mVibrator.vibrate( new long[]{500,200,500,200}, -1); //第一个｛｝里面是节奏数组， 第二个参数是重复次数，-1为不重复，非-1俄日从pattern的指定下标开始重复
    }

    @OnClick(R.id.btn_back)
    public void onClick() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if (mShakeListener != null){
            mShakeListener.stop();
        }
    }
}
