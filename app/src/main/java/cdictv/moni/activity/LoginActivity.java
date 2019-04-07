package cdictv.moni.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cdictv.moni.R;
import cdictv.moni.bean.UserBean;
import cdictv.moni.network.Mycall;
import cdictv.moni.network.OkhttpApi;
import cdictv.moni.util.Sputil;
import cdictv.moni.util.ZhengzeUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imgview;
    private TextView textLogo;
    private TextView network;
    private EditText edName;
    private EditText edPassword;
    private CheckBox checkJz;
    private CheckBox checkZd;
    private Button logo;
    private Button regist;
    private String name;
    private String password;
    UserBean mUserBean;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //保存密码
        initViwe();
        boolean flag = Sputil.getBoolean("baocun");
        checkJz.setChecked(flag);
        if (flag) {
            edName.setText(Sputil.getString("user"));
            edPassword.setText(Sputil.getString("pass"));
            //自动登录
            if (Sputil.getBoolean("zhidong")) {
                checkZd.setChecked(true);
//                Toast.makeText(LoginActivity.this,"自动登录",Toast.LENGTH_LONG).show();

                login();
//               自动登录，这里是去开网络请求去登录，很有可能，他登录的接口会返回一个token，你们之后的
//                接口调用就需要传这个值

//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                Sputil.putString("name",mUserBean.data.username);
//                finish();
            } else {
                checkZd.setChecked(false);
            }
        }
        initLister();

    }

    private void getStringNamePass() {
        name = edName.getText().toString().trim();
        password = edPassword.getText().toString().trim();
        Log.d("tag", "getStringNamePass: " + name);
        Log.d("tag", "getStringNamePass: " + password);
    }

    private void initLister() {

        logo.setOnClickListener(this);

    }

    private void initViwe() {
        imgview = (ImageView) findViewById(R.id.imgview);
        textLogo = (TextView) findViewById(R.id.text_logo);
        network = (TextView) findViewById(R.id.network);
        edName = (EditText) findViewById(R.id.ed_name);
        edPassword = (EditText) findViewById(R.id.ed_password);
        checkJz = (CheckBox) findViewById(R.id.check_jz);
        checkZd = (CheckBox) findViewById(R.id.check_zd);
        logo = (Button) findViewById(R.id.logo);
        regist = (Button) findViewById(R.id.regist);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.logo:
                login();
        }
    }


    private void login() {
        getStringNamePass();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(LoginActivity.this,
                    "账户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(LoginActivity.this,
                    "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!name.matches(ZhengzeUtil.UERZJ)) {
            Toast.makeText(LoginActivity.this,
                    "用户名请输入为字母首位且4-8位数字字母", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.matches(ZhengzeUtil.PWDZJ)) {
            Toast.makeText(LoginActivity.this,
                    "密码请输入不能以0开头切6-12位的数字",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        mProgressDialog = ProgressDialog.show(
                LoginActivity.this,"提示","正在请求");
//        这里的网络请求 需要加 进度dialog。 自己加一下
        OkhttpApi.login(name, password, new Mycall() {
            @Override
            public void success(String json) {

                Log.d("===", json);
//  gson的解析，需要捕获一下异常 ，在解析失败的时候 需要提示 ，不用    json.contains("username")这样判断

                try {
                    Gson gson = new Gson();
                    mUserBean = gson.fromJson(json, UserBean.class);
                    if (checkJz.isChecked()) {
                        Log.d("++", "success: 保存");
                        Sputil.putString("user", name);
                        Sputil.putString("pass", password);
                        Sputil.putBoolean("baocun", true);
                        if (checkZd.isChecked()) {
                            Sputil.putBoolean("zhidong", true);
                        } else {
                            Sputil.revome("zhidong");
                        }
                    } else {
                        Sputil.revome("user");
                        Sputil.revome("pass");
                        Sputil.revome("baocun");
                    }
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    Sputil.putString("name", mUserBean.data.username);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this, "用户名或密码错", Toast.LENGTH_LONG).show();
                }finally {
                    mProgressDialog.dismiss();
                }
            }


            @Override
            public void faild(IOException e) {

            }
        });

    }
}

