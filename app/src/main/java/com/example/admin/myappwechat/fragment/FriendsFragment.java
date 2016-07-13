package com.example.admin.myappwechat.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.ui.ShakeActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/7.
 */
public class FriendsFragment extends BaseFragment {

    @Bind(R.id.rl2_frinds)
    RelativeLayout rl2Frinds;

    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.viewpager_fraind, null);
        return view;
    }

    @Override
    protected void initDate() {

    }

    @OnClick(R.id.rl2_frinds)
    public void onClick() {
        Intent intent = new Intent(getContext(),ShakeActivity.class);
        startActivity(intent);
    }
}
