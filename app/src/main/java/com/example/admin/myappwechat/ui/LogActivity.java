package com.example.admin.myappwechat.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin.myappwechat.R;
import com.example.admin.myappwechat.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by admin on 2016/7/5.
 */
public class LogActivity extends Activity {

    @Bind(R.id.login_reback_btn)
    Button loginRebackBtn;
    @Bind(R.id.forget_passwd)
    Button forgetPasswd;
    @Bind(R.id.login_login_btn)
    Button loginLoginBtn;
    @Bind(R.id.login_user_edit)
    EditText mUrse;
    @Bind(R.id.login_passwd_edit)
    EditText mPassword;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);

        sp = getSharedPreferences("config",Activity.MODE_PRIVATE);
        String urse = sp.getString("urse","");
        String pwsd = sp.getString("pwsd","");

        mUrse.setText(urse);
        mPassword.setText(pwsd);
        mUrse.setSelection(urse.length());
    }

    @OnClick({R.id.login_reback_btn, R.id.forget_passwd, R.id.login_login_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_reback_btn:
                finish();
                break;
            case R.id.forget_passwd:
                Utils.showToast(LogActivity.this,"你是一个笨蛋，密码都能忘记");
                break;
            case R.id.login_login_btn:

                if("yuhua".equals(mUrse.getText().toString()) && "123".equals(mPassword.getText().toString())){

                    sp = getSharedPreferences("config",Activity.MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("urse","yuhua");
                    edit.putString("pwsd","123");
                    edit.commit();
                    Intent intent = new Intent(LogActivity.this,LoadingActivity.class);
                    startActivity(intent);
                    Utils.showToast(LogActivity.this, "登录成功");
                    finish();
                }else if ("".equals(mUrse.getText().toString()) || "".equals(mPassword.getText().toString())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LogActivity.this);
                    builder.setIcon(getResources().getDrawable(R.drawable.login_error_icon));
                    builder.setTitle("登录错误");
                    builder.setMessage("微信账号或者密码不能为空，\n请输入后在登录！");
                    builder.create().show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LogActivity.this);
                    builder.setIcon(getResources().getDrawable(R.drawable.login_error_icon));
                    builder.setTitle("登录错误");
                    builder.setMessage("微信账号或者密码错误，\n请确认后在登录！");
                    builder.create().show();
                }
                break;
        }
    }

}
