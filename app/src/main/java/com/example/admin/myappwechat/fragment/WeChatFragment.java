package com.example.admin.myappwechat.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.ui.WeChatDatilActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/7.
 */
public class WeChatFragment extends BaseFragment {


    @Bind(R.id.right_btn)
    ImageButton rightBtn;
    @Bind(R.id.rl_wechat)
    RelativeLayout rlWechat;
    private PopupWindow pop;
    private View view1;


    @Override
    public View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.viewpager_wechat, null);
        return view;
    }

    @Override
    protected void initDate() {
    }


    @OnClick({R.id.right_btn, R.id.rl_wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right_btn:
                view1 = View.inflate(getContext(), R.layout.pop_fragment, null);
                if (pop == null){
                    pop = new PopupWindow(view1,260,340);
                }
                pop.setFocusable(true);
                pop.setTouchable(true);
                pop.setAnimationStyle(R.style.popwin_anim_style);
                pop.showAsDropDown(rightBtn,-180,10);
                pop.setOutsideTouchable(true);
                pop.setBackgroundDrawable(new ColorDrawable(0x00000000));
                view1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (pop != null | pop.isShowing()) {
                            pop.dismiss();
                            pop = null;
                        }
                        return false;
                    }
                });
                break;
            case R.id.rl_wechat:

                Intent intent = new Intent(getContext(),WeChatDatilActivity.class);
                startActivity(intent);
                break;
        }
    }

}
