package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.adapter.MyChatAdapter;
import com.example.admin.myappwechat.bean.ChatMsgEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/7/8.
 */
public class WeChatDatilActivity extends Activity {
    @Bind(R.id.btn_back)
    Button btnBack;
    @Bind(R.id.right_btn)
    ImageButton rightBtn;
    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.et_sendmessage)
    EditText etSendmessage;
    @Bind(R.id.bt_send)
    Button btSend;
    private String[] msgArray = new String[]{"有大吗", "有！你呢？", "我也有", "那上吧",
            "打啊！你放大啊", "你tm咋不放大呢？留大抢人头那！Cao的。你个菜b",
            "2B不解释", "尼滚....",};

    private String[] dataArray = new String[]{"2012-09-01 18:00", "2012-09-01 18:10",
            "2012-09-01 18:11", "2012-09-01 18:20",
            "2012-09-01 18:30", "2012-09-01 18:35",
            "2012-09-01 18:40", "2012-09-01 18:50"};

    private ArrayList<ChatMsgEntity> mDataArrays = new ArrayList<>();
    private MyChatAdapter adapter;
    private PopupWindow popupWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datil_activity);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ButterKnife.bind(this);
        initDate();
    }

    private void initDate() {

        for (int i = 0; i < dataArray.length; i++) {
            ChatMsgEntity entity = new ChatMsgEntity();
            if (i % 2 == 0) {
                entity.setName("小壮");
                entity.setMsgType(true);
            } else {
                entity.setName("小鱼");
                entity.setMsgType(false);
            }
            entity.setDate(dataArray[i]);
            entity.setText(msgArray[i]);

            mDataArrays.add(entity);
        }

        adapter = new MyChatAdapter(WeChatDatilActivity.this, mDataArrays);
        listview.setAdapter(adapter);


    }

    @OnClick({R.id.btn_back, R.id.right_btn,R.id.bt_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.right_btn:
                View view1 = View.inflate(WeChatDatilActivity.this,R.layout.pop_people,null);
                if (popupWindow == null){
                    popupWindow = new PopupWindow(view1,260,440);
                }
                popupWindow.setFocusable(true);
                popupWindow.setTouchable(true);
                popupWindow.setAnimationStyle(R.style.popwin_anim_style);
                popupWindow.showAsDropDown(rightBtn,-180,8);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
                view1.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        if (popupWindow != null | popupWindow.isShowing()) {
                            popupWindow.dismiss();
                            popupWindow = null;
                        }
                        return false;
                    }
                });
                break;
            case R.id.bt_send:
                send();
                break;
        }
    }

    public void xiaoyu(View view) {

        Intent intent = new Intent(WeChatDatilActivity.this,DetilsHeadViewActiity.class);
        startActivity(intent);
    }

    private void send() {

        String conString = etSendmessage.getText().toString();
        int cont = 0;
        if (conString.length() >0){
            ChatMsgEntity entity = new ChatMsgEntity();
            if (cont % 2 == 0) {
                entity.setText(conString);
                entity.setMsgType(true);
                mDataArrays.add(entity);
                adapter.notifyDataSetChanged();
                etSendmessage.setText("");
                listview.setSelection(listview.getCount() - 1);
            }else {
                entity.setText(conString);
                entity.setMsgType(false);
                mDataArrays.add(entity);
                adapter.notifyDataSetChanged();
                etSendmessage.setText("");
                listview.setSelection(listview.getCount() - 1);
            }
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            String data1 = dateFormat.format(date);
            entity.setDate(data1);
            cont++;
           // hideKb();
        }


    }

//
//    这是隐藏键盘
//    private void hideKb(){
//        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
//
//        if (imm.isActive() && getCurrentFocus() != null){
//            if (getCurrentFocus().getWindowToken() != null){
//                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
//                        InputMethodManager.HIDE_NOT_ALWAYS);
//            }
//        }
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

        if (imm.isActive() && getCurrentFocus() != null){
            if (getCurrentFocus().getWindowToken() != null){
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
        return super.onTouchEvent(event);
    }
}
