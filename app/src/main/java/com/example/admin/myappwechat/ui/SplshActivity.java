package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.admin.myappwechat.R;

public class SplshActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splsh);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplshActivity.this,WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

}
