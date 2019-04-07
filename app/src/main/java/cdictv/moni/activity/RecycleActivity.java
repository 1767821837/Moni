package cdictv.moni.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cdictv.moni.R;
import cdictv.moni.network.Mycall;
import cdictv.moni.network.OkhttpApi;

public class RecycleActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_phone;
    private EditText et_pass;
    private Button but_login;
    private Button regist;
    boolean passboo = false;
    boolean nameboo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        initView();
    }

    private void initView() {
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pass = (EditText) findViewById(R.id.et_pass);
        but_login = (Button) findViewById(R.id.but_login);
        regist = (Button) findViewById(R.id.regist);
        but_login.setOnClickListener(this);
        regist.setOnClickListener(this);

        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (passboo && nameboo) {
                    but_login.setEnabled(true);
                    but_login.setBackgroundResource(R.drawable.butregist);
                } else {
                    but_login.setEnabled(false);
                    but_login.setBackgroundResource(R.drawable.butlogin);
                }

                if (s.toString().length() > 0) {
                    nameboo = true;
                } else {
                    nameboo = false;
                }
            }
        });

        et_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (passboo && nameboo) {
                    but_login.setEnabled(true);
                    but_login.setBackgroundResource(R.drawable.butregist);
                } else {
                    but_login.setEnabled(false);
                    but_login.setBackgroundResource(R.drawable.butlogin);
                }

                if (s.toString().length() >5) {
                    passboo = true;
                } else {
                    passboo = false;
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_login:
                submit();
                break;
            case R.id.regist:

                break;
        }
    }

    private void submit() {
        // validate
        String phone = et_phone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pass = et_pass.getText().toString().trim();
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        OkhttpApi.login(phone, pass, new Mycall() {
            @Override
            public void success(String json) {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    JSONObject object = jsonObject.getJSONObject("data");
                    String name = object.getString("username");
                    if ("张三".equals(name)) {
                        Toast.makeText(RecycleActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RecycleActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RecycleActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void faild(IOException e) {

            }
        });

    }
}
