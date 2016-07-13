package com.example.admin.myappwechat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.bean.ChatMsgEntity;

import java.util.ArrayList;

/**
 * Created by admin on 2016/7/8.
 */
public class MyChatAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<ChatMsgEntity> mDataArrays;
    private LayoutInflater mInflater;


    public static interface IMsgViewType
    {
        int IMVT_COM_MSG = 0;
        int IMVT_TO_MSG = 1;
    }
    public MyChatAdapter(Context context, ArrayList<ChatMsgEntity> mDataArrays) {
        this.context = context;
        this.mDataArrays = mDataArrays;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataArrays.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataArrays.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        ChatMsgEntity mEntity = mDataArrays.get(position);
        if (mEntity.getMsgType()){
            return IMsgViewType.IMVT_COM_MSG;
        }else {
            return IMsgViewType.IMVT_TO_MSG;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHodler hodler = null;
        ChatMsgEntity mEntity = mDataArrays.get(position);
        if (convertView == null){
            if (mEntity.getMsgType()){
                convertView = mInflater.inflate(R.layout.wechat_item,null);
            }else {
                convertView = mInflater.inflate(R.layout.wechat_item2,null);
            }

            hodler = new ViewHodler();
            hodler.tv_data = (TextView) convertView.findViewById(R.id.tv_data);
            hodler.msg1 = (TextView) convertView.findViewById(R.id.tv_msg1);
            hodler.isMsg = mEntity.getMsgType();

            convertView.setTag(hodler);
        }else {
            hodler = (ViewHodler) convertView.getTag();
        }

        hodler.tv_data.setText(mEntity.getDate());
        hodler.msg1.setText(mEntity.getText());
        return convertView;
    }

    static class ViewHodler{
        public TextView tv_data;
        public TextView msg1;
        public boolean isMsg = true;
    }
}
