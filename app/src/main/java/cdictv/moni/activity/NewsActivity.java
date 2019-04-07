package cdictv.moni.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;
import cdictv.moni.adatper.MessageAdatper;
import cdictv.moni.bean.MessageBean;
import cdictv.moni.network.Mycall;
import cdictv.moni.network.OkhttpApi;

public class NewsActivity extends AppCompatActivity {
    ProgressDialog mProgressDialog;
    private ImageView back;
    private ListView list_news;
    MessageBean mMessageBean;
    public List<MessageBean.NewslistBean> newslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        okttpData();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        list_news = (ListView) findViewById(R.id.list_news);
    }

    private void okttpData() {
        mProgressDialog = ProgressDialog.show(
                NewsActivity.this,"提示","正在请求");
        OkhttpApi.showOkhttp("http://api.tianapi.com/keji/?key=6edb9118c6ce61c710140aeb03b10e2c&num=50&rand=1",
                new Mycall() {
                    @Override
                    public void success(String json) {

                        Log.d("tag", "success: " + json);
                        Gson gson = new Gson();
                        try{
                            mMessageBean = gson.fromJson(json, MessageBean.class);
                            List list = mMessageBean.newslist;
                            newslist = new ArrayList<>();
                            newslist.addAll(list);
                            initList(newslist);
                        }catch (Exception e){

                        }finally {
                            mProgressDialog.dismiss();
                        }

                    }

                    @Override
                    public void faild(IOException e) {

                    }


                });
    }
    private void initList(List<MessageBean.NewslistBean> list) {
        list_news.setAdapter(new MessageAdatper(list,NewsActivity.this));
        list_news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(NewsActivity.this,WebActivity.class);
                intent.putExtra("title",newslist.get(position).title);
                intent.putExtra("uri",newslist.get(position).url);
                startActivity(intent);
            }
        });
    }
}
