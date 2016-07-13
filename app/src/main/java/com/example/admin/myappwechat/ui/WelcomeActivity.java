package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.admin.myappwechat.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/5.
 */
public class WelcomeActivity extends Activity {

    @Bind(R.id.main_login_btn)
    Button mainLoginBtn;
    @Bind(R.id.main_regist_btn)
    Button mainRegistBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.main_login_btn, R.id.main_regist_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_login_btn:
                Intent intent1 = new Intent(WelcomeActivity.this,LogActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.main_regist_btn:
                Intent intent2 = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
