package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.myappwechat.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/11.
 */
public class DetilsHeadViewActiity extends Activity {


    @Bind(R.id.btn_back)
    Button btnBack;
    @Bind(R.id.iv_image)
    ImageView ivImage;
    @Bind(R.id.bt_send)
    Button btSend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiaohei);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_back, R.id.iv_image, R.id.bt_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:

                finish();
                break;
            case R.id.iv_image:
                Intent intent = new Intent(DetilsHeadViewActiity.this,InfoXiaoheiHead.class);
                startActivity(intent);
                break;
            case R.id.bt_send:
                finish();
                break;
        }
    }
}
