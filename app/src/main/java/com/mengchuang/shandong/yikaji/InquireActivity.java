package com.mengchuang.shandong.yikaji;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
/**
 * 登陆页面
 */
public class InquireActivity extends Activity {
    private EditText et_usertel;
    private EditText et_password;
    private Button btn_login;
    private Button btn_qtlogin;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dialog = new ProgressDialog(InquireActivity.this);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_qtlogin = (Button) findViewById(R.id.btn_qtlogin);
        // 监听多个输入框
        et_usertel.addTextChangedListener(new TextChange());
        et_password.addTextChangedListener(new TextChange());

        btn_login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.setMessage("正在登录...");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();

                final String password = et_password.getText().toString().trim();
                String usertel = et_usertel.getText().toString().trim();
                Map<String, String> map = new HashMap<String, String>();

                map.put("usertel", usertel);
                map.put("password", password);
                startActivity(new Intent(InquireActivity.this,
                        RegisterActivity.class));
                //服务器验证用户名和密码；
//                LoadDataFromServer task = new LoadDataFromServer(
//                        LoginActivity.this, Constant.URL_Login, map);
//
//                task.getData(new DataCallBack() {
//
//                    @Override
//                    public void onDataCallBack(JSONObject data) {
//                        try {
//                            int code = data.getInteger("code");
//                            if (code == 1) {
//
//                                JSONObject json = data.getJSONObject("user");
//                                login(json);
//                            } else if (code == 2) {
//                                dialog.dismiss();
//                                Toast.makeText(LoginActivity.this,
//                                        "账号或密码错误...", Toast.LENGTH_SHORT)
//                                        .show();
//                            } else if (code == 3) {
//                                dialog.dismiss();
//                                Toast.makeText(LoginActivity.this,
//                                        "服务器端注册失败...", Toast.LENGTH_SHORT)
//                                        .show();
//                            } else {
//                                dialog.dismiss();
//                                Toast.makeText(LoginActivity.this,
//                                        "服务器繁忙请重试...", Toast.LENGTH_SHORT)
//                                        .show();
//                            }
//
//                        } catch (JSONException e) {
//                            dialog.dismiss();
//                            Toast.makeText(LoginActivity.this, "数据解析错误...",
//                                    Toast.LENGTH_SHORT).show();
//                            e.printStackTrace();
//                        }
//                    }
//                });
            }
//
        });
        btn_qtlogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(InquireActivity.this,
                        RegisterActivity.class));
            }

        });
    }

    // EditText监听器
    class TextChange implements TextWatcher {

        @Override
        public void afterTextChanged(Editable arg0) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

        }

        @Override
        public void onTextChanged(CharSequence cs, int start, int before,
                                  int count) {

            boolean Sign2 = et_usertel.getText().length() > 0;
            boolean Sign3 = et_password.getText().length() > 0;

            if (Sign2 & Sign3) {
                btn_login.setTextColor(0xFFFFFFFF);
                btn_login.setEnabled(true);
            }
            // 在layout文件中，对Button的text属性应预先设置默认值，否则刚打开程序的时候Button是无显示的
            else {
                btn_login.setTextColor(0xFFD0EFC6);
                btn_login.setEnabled(false);
            }
        }

    }

    private void login(final JSONObject json) {

        try {
            final String nick = json.getString("nick");
            final String hxid = json.getString("hxid");
            final String password = json.getString("password");
            // String fxid = json.getString("fxid");
            // String tel = json.getString("tel");
            // String sex = json.getString("sex");
            // String sign = json.getString("sign");
            // String avatar = json.getString("avatar");
            // String region = json.getString("region");
            // 调用sdk登陆方法登陆聊天服务器
        } catch (JSONException e1) {

            e1.printStackTrace();
        }

    }

    private void processContactsAndGroups(final JSONObject json) {
        // demo中简单的处理成每次登陆都去获取好友username，开发者自己根据情况而定
    }

    /**
     * 设置hearder属性，方便通讯中对联系人按header分类显示，以及通过右侧ABCD...字母栏快速定位联系人
     *
     */
    @SuppressLint("DefaultLocale")
//    protected void setUserHearder(String username, User user) {
//
//    }

    private void saveMyInfo(JSONObject json) {

    }

}
