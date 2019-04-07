package cdictv.moni.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;

import cdictv.moni.R;
import cdictv.moni.bean.CarBean;
import cdictv.moni.bean.CarCradBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CarWeizhangActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView back;
    private TextView id_cartop;
    private EditText ed_carnum;
    private Button carid_qurey;
    Handler handler = new Handler();
    Gson gson = new Gson();
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_weizhang);
        initView();
    }

    private void initView() {

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);
        id_cartop = (TextView) findViewById(R.id.id_cartop);
        id_cartop.setOnClickListener(this);
        ed_carnum = (EditText) findViewById(R.id.ed_carnum);
        ed_carnum.setOnClickListener(this);
        carid_qurey = (Button) findViewById(R.id.carid_qurey);
        carid_qurey.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.carid_qurey:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        final String carnum = ed_carnum.getText().toString().trim();
        if (TextUtils.isEmpty(carnum)) {
            Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        } else {
            //qureyCarId(carnum);
            dialog = ProgressDialog.show(this, "提示", "正在获取中");
            MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
            CarBean carBean = new CarBean();
            carBean.chepai = carnum;
            String ss = gson.toJson(carBean);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://www.easy-mock.com/mock/5c8f3515c42b1c0235654282/jiaotong/chepai")
                    .post(RequestBody.create(mediaType, ss))
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    Log.i("-----------", "onFailure: " + e.getMessage());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(CarWeizhangActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String body = response.body().string();
                    Log.i("-----------", "onResponse: " + body);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject object = new JSONObject(body);
                                String errorstu = object.getString("data");
                                if (errorstu.equals("参数不对")) {
                                    Toast.makeText(CarWeizhangActivity.this, "没有查询到" + carnum + "车的违章数据！", Toast.LENGTH_SHORT).show();
                                } else {
                                    CarCradBean bean = gson.fromJson(body, CarCradBean.class);
                                    Intent intent = new Intent(CarWeizhangActivity.this, QrueyResultActivity.class);
                                    intent.putExtra("bean", (Serializable) bean);
                                    CarWeizhangActivity.this.startActivity(intent);
                                    dialog.dismiss();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (JsonSyntaxException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            });

        }
    }

    private void qureyCarId(final String carid) {

    }
}
