package cdictv.moni.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;
import cdictv.moni.bean.LukukangBean;
import cdictv.moni.network.Mycall;
import cdictv.moni.network.OkhttpApi;
import cdictv.moni.util.DateUtil;

public class LukangActivity extends AppCompatActivity {
    private Handler mHandler=new Handler();

    private TextView hcks1;
    private TextView hcks2;
    private TextView xueyuan;
    private TextView xingfu;
    private TextView lianxiang;
    private TextView yiyuan;
    private TextView tcc;
    private TextView hcgs;
    private TextView hcks3;
    private ImageView reshesh;
    private TextView shijian;
    private TextView xingqi;
    private TextView wendu;
    private TextView shidu;
    private TextView pm;
    Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this,3000);
            getdata();
            xuanyan();
        }
    };
    private LukukangBean.DataBean mDataBean;
    private List<LukukangBean.DataBean.LukuangBean> mBeanList;

    private void getdata() {
        OkhttpApi.showOkhttp("https://www.easy-mock.com/mock/5c8f3515c42b1c023565428" +
                "2/jiaotong/lukuangchaxun", new Mycall() {
            @Override
            public void success(String json) {
                Log.d("tag",json);
                try {
                    Gson gson=new Gson();
                    LukukangBean lukukangBean=gson.fromJson(json,LukukangBean.class);
                    mDataBean = lukukangBean.data;
                    wendu.setText("温度："+mDataBean.wendu+"℃");
                    pm.setText("PM2.5:"+mDataBean.pm+"ug/m3");
                    shidu.setText("相对湿度:"+mDataBean.shidu+"%");
               List<LukukangBean.DataBean.LukuangBean> lukuangBeanList= lukukangBean.data.lukuang;
                  mBeanList.clear();
                  mBeanList.addAll(lukuangBeanList);

                }catch (Exception e){
                     Toast.makeText(getApplicationContext(),"请求失败",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void faild(IOException e) {

            }
        });
    }

    private void xuanyan() {
        shijian.setText(DateUtil.showData());
        xingqi.setText(DateUtil.showWeek());

        for (LukukangBean.DataBean.LukuangBean bean: mBeanList) {
            switch (bean.state){
                case 1:
                    if(bean.id==1){
                        xueyuan.setBackgroundColor(Color.parseColor("#6ab82e"));

                    }
                    if(bean.id==2){
                        lianxiang.setBackgroundColor(Color.parseColor("#6ab82e"));

                    }
                    if(bean.id==3){
                        yiyuan.setBackgroundColor(Color.parseColor("#6ab82e"));

                    }
                    if(bean.id==4){
                        xingfu.setBackgroundColor(Color.parseColor("#6ab82e"));

                    }
                    if (bean.id==5){
                        hcgs.setBackgroundColor(Color.parseColor("#6ab82e"));
                    }
                    if(bean.id==6){
                        hcks1.setBackgroundColor(Color.parseColor("#6ab82e"));
                        hcks2.setBackgroundColor(Color.parseColor("#6ab82e"));
                        hcks3.setBackgroundColor(Color.parseColor("#6ab82e"));

                    }
                    if(bean.id==7){
                        tcc.setBackgroundColor(Color.parseColor("#6ab82e"));

                    }
                            break;
                case 2:
                    if(bean.id==1){
                        xueyuan.setBackgroundColor(Color.parseColor("#ece93a"));

                    }
                    if(bean.id==2){
                        lianxiang.setBackgroundColor(Color.parseColor("#ece93a"));

                    }
                    if(bean.id==3){
                        yiyuan.setBackgroundColor(Color.parseColor("#ece93a"));
                        return;
                    }
                    if(bean.id==4){
                        xingfu.setBackgroundColor(Color.parseColor("#ece93a"));

                    }
                    if (bean.id==5){
                        hcgs.setBackgroundColor(Color.parseColor("#ece93a"));
                    }
                    if(bean.id==6){
                        hcks1.setBackgroundColor(Color.parseColor("#ece93a"));
                        hcks2.setBackgroundColor(Color.parseColor("#ece93a"));
                        hcks3.setBackgroundColor(Color.parseColor("#ece93a"));

                    }
                    if(bean.id==7){
                        tcc.setBackgroundColor(Color.parseColor("#ece93a"));

                    }
                    break;
                case 3:
                    if(bean.id==1){
                        xueyuan.setBackgroundColor(Color.parseColor("#f49b25"));

                    }
                    if(bean.id==2){
                        lianxiang.setBackgroundColor(Color.parseColor("#f49b25"));

                    }
                    if(bean.id==3){
                        yiyuan.setBackgroundColor(Color.parseColor("#f49b25"));

                    }
                    if(bean.id==4){
                        xingfu.setBackgroundColor(Color.parseColor("#f49b25"));

                    }
                    if (bean.id==5){
                        hcgs.setBackgroundColor(Color.parseColor("#f49b25"));
                    }
                    if(bean.id==6){
                        hcks1.setBackgroundColor(Color.parseColor("#f49b25"));
                        hcks2.setBackgroundColor(Color.parseColor("#f49b25"));
                        hcks3.setBackgroundColor(Color.parseColor("#f49b25"));

                    }
                    if(bean.id==7){
                        tcc.setBackgroundColor(Color.parseColor("#f49b25"));

                    }
                    break;
                case 4:
                    if(bean.id==1){
                        xueyuan.setBackgroundColor(Color.parseColor("#e33532"));

                    }
                    if(bean.id==2){
                        lianxiang.setBackgroundColor(Color.parseColor("#e33532"));

                    }
                    if(bean.id==3){
                        yiyuan.setBackgroundColor(Color.parseColor("#e33532"));

                    }
                    if(bean.id==4){
                        xingfu.setBackgroundColor(Color.parseColor("#e33532"));

                    }
                    if (bean.id==5){
                        hcgs.setBackgroundColor(Color.parseColor("#e33532"));
                    }
                    if(bean.id==6){
                        hcks1.setBackgroundColor(Color.parseColor("#e33532"));
                        hcks2.setBackgroundColor(Color.parseColor("#e33532"));
                        hcks3.setBackgroundColor(Color.parseColor("#e33532"));
                       ;
                    }
                    if(bean.id==7){
                        tcc.setBackgroundColor(Color.parseColor("#e33532"));

                    }
                    break;

                case 5:
                    if(bean.id==1){
                        xueyuan.setBackgroundColor(Color.parseColor("#b01e23"));

                    }
                    if(bean.id==2){
                        lianxiang.setBackgroundColor(Color.parseColor("#b01e23"));

                    }
                    if(bean.id==3){
                        yiyuan.setBackgroundColor(Color.parseColor("#b01e23"));

                    }
                    if(bean.id==4){
                        xingfu.setBackgroundColor(Color.parseColor("#b01e23"));

                    }
                    if (bean.id==5){
                        hcgs.setBackgroundColor(Color.parseColor("#b01e23"));
                    }
                    if(bean.id==6){
                        hcks1.setBackgroundColor(Color.parseColor("#b01e23"));
                        hcks2.setBackgroundColor(Color.parseColor("#b01e23"));
                        hcks3.setBackgroundColor(Color.parseColor("#b01e23"));

                    }
                    if(bean.id==7){
                        tcc.setBackgroundColor(Color.parseColor("#b01e23"));

                    }
                    break;

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lukang);
        mBeanList = new ArrayList<>();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mRunnable,3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mRunnable);
    }

    private void initView() {
        hcks1 = (TextView) findViewById(R.id.hcks1);
        hcks2 = (TextView) findViewById(R.id.hcks2);
        xueyuan = (TextView) findViewById(R.id.xueyuan);
        xingfu = (TextView) findViewById(R.id.xingfu);
        lianxiang = (TextView) findViewById(R.id.lianxiang);
        yiyuan = (TextView) findViewById(R.id.yiyuan);
        tcc = (TextView) findViewById(R.id.tcc);
        hcgs = (TextView) findViewById(R.id.hcgs);
        hcks3 = (TextView) findViewById(R.id.hcks3);
        reshesh = (ImageView) findViewById(R.id.reshesh);
        shijian = (TextView) findViewById(R.id.shijian);
        xingqi = (TextView) findViewById(R.id.xingqi);
        wendu = (TextView) findViewById(R.id.wendu);
        shidu = (TextView) findViewById(R.id.shidu);
        pm = (TextView) findViewById(R.id.pm);
        reshesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
