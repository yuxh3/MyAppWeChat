package com.example.admin.myappwechat.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.ui.LogActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/7.
 */
public class SettingFragment extends BaseFragment {

    @Bind(R.id.btn_setting)
    Button btnSetting;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.viewpager_setting, null);
        return view;
    }

    @Override
    protected void initDate() {

    }

    private void DialogBuilder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view1 = View.inflate(getContext(), R.layout.activity_setting, null);
        builder.setView(view1);
        final Dialog dialog = builder.create();
        view1.findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LogActivity.class);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        view1.findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setWindowAnimations(R.style.SettingAnimBottom);

        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.gravity = Gravity.BOTTOM;
        dialog.getWindow().setAttributes(params);
        dialog.show();
    }


    @OnClick(R.id.btn_setting)
    public void onClick() {
        DialogBuilder();
    }
}




