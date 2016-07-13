package com.example.admin.myappwechat.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.fragment.AddressFragment;
import com.example.admin.myappwechat.fragment.FriendsFragment;
import com.example.admin.myappwechat.fragment.SettingFragment;
import com.example.admin.myappwechat.fragment.WeChatFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/5.
 */
public class MainActivity extends FragmentActivity {


    @Bind(R.id.rb_wechat)
    RadioButton rbWechat;
    @Bind(R.id.rb_address)
    RadioButton rbAddress;
    @Bind(R.id.rb_frind)
    RadioButton rbFrind;
    @Bind(R.id.rb_setting)
    RadioButton rbSetting;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.fl)
    FrameLayout fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        init();
        //AlerDialogBuilder();这方法不知道为什么展现不出来
    }

    private void init() {
        rbWechat.setChecked(true);
        getSupportFragmentManager().beginTransaction().add(R.id.fl, new WeChatFragment()).commit();
    }

    @OnClick({R.id.rb_wechat, R.id.rb_address, R.id.rb_frind, R.id.rb_setting})
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.rb_wechat:
               fragment = new WeChatFragment();
                break;
            case R.id.rb_address:
                fragment = new AddressFragment();
                break;
            case R.id.rb_frind:
                fragment = new FriendsFragment();
                break;
            case R.id.rb_setting:
                fragment = new SettingFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fl,fragment).commit();
    }

//    private void AlerDialogBuilder() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View view = View.inflate(MainActivity.this, R.layout.activity_exit,null);
//        final AlertDialog dialog = builder.create();
//        view.findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("TAG", "11111111111");
//                finish();
//            }
//        });
//        view.findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                dialog.dismiss();
//            }
//        });
//
//        dialog.setView(view);
//        builder.show();
//    }
}
