package cdictv.moni.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;
import cdictv.moni.adatper.CarCardAdapter;
import cdictv.moni.adatper.CarWeizhangAdapter;
import cdictv.moni.bean.CarCradBean;

public class QrueyResultActivity extends AppCompatActivity {

    List<CarCradBean.DataBean> beans = new ArrayList<>();
    List<CarCradBean.DataBean.XiangqingBean> xiangqingBeans = new ArrayList<>();
    private ImageView car_back;
    private ListView car_card;
    private ListView weizahangxiangqing;
    CarWeizhangAdapter adapter2;
    CarCardAdapter adapter1;
    List<CarCradBean> beanlist = new ArrayList<>();
    private CarCradBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qruey_result);
        initView();

        beans.add(bean.data);
        xiangqingBeans.addAll(bean.data.xiangqing);
        //bean.data.xiangqing;
        adapter2 = new CarWeizhangAdapter(xiangqingBeans, QrueyResultActivity.this, beans);
        adapter1 = new CarCardAdapter(QrueyResultActivity.this, beans);
        weizahangxiangqing.setAdapter(adapter2);
        car_card.setAdapter(adapter1);
        car_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(QrueyResultActivity.this, CarWeizhangActivity.class);
                startActivity(intent1);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        CarCradBean bean = (CarCradBean) intent.getSerializableExtra("bean");
        if (adapter1.getCount() != beans.size()) {
            adapter1.notifyDataSetChanged();
        }
        adapter2.notifyDataSetChanged();

    }

    private void initView() {
        car_back = (ImageView) findViewById(R.id.car_back);
        car_card = (ListView) findViewById(R.id.car_card);
        weizahangxiangqing = (ListView) findViewById(R.id.weizahangxiangqing);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        bean = (CarCradBean) intent.getSerializableExtra("bean");
        beanlist.add(bean);
        beans.add(bean.data);
        Log.i("*****", "onNewIntent: ");
    }
}
