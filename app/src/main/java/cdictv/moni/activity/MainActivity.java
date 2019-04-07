package cdictv.moni.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cdictv.moni.R;
import cdictv.moni.util.Sputil;

public class MainActivity extends AppCompatActivity  {

    private ImageView left_menu;
    private TextView title;
    private TextView zhuxiao;
    private RelativeLayout tool_bar;
    private ImageView top_bac;
    private LinearLayout navigation_view;
    private LinearLayout gongjiaolayout;
    private LinearLayout cz;
    private LinearLayout reddeng;
    private LinearLayout lukuang;
    private LinearLayout person;
    private LinearLayout yule;
    private LinearLayout weizhang;
    private LinearLayout datafenxi;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initlinsener();
    }

    private void initlinsener() {
        //侧滑
        left_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    drawerLayout.closeDrawer(Gravity.LEFT);
                } else {
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
            }
        });
        //注销
        zhuxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sputil.putBoolean("zhidong",false);
                Sputil.putBoolean("baocun",false);
                Sputil.revome("user");
                Sputil.revome("pass");
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });
        //公交
        gongjiaolayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,gongjiaoActivity.class));
            }
        });
        //充值
        cz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,ZHGLActivity.class));
            }
        });
        //红绿灯
        reddeng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,HongLvDengActivity.class));
            }
        });
        //路况查询
        lukuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,LukangActivity.class));
            }
        });
        //个人中心
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,PersonActivity.class));
            }
        });
        //创意新闻
        yule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,NewsActivity.class));
            }
        });
        //违章管理
        weizhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(
                        MainActivity.this,CarWeizhangActivity.class));
            }
        });
        //数据分析
        datafenxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SJFXActivity.class));
            }
        });
    }

    private void initView() {
        cz=findViewById(R.id.zhgl);
        reddeng=findViewById(R.id.reddeng);
        gongjiaolayout=findViewById(R.id.gongja_layout);
        drawerLayout=findViewById(R.id.drawer_yout);
        left_menu = (ImageView) findViewById(R.id.left_menu);
        title = (TextView) findViewById(R.id.title);
        zhuxiao = (TextView) findViewById(R.id.zhuxiao);
        tool_bar = (RelativeLayout) findViewById(R.id.tool_bar);
        top_bac = (ImageView) findViewById(R.id.top_bac);
        lukuang=findViewById(R.id.lukuang);
        person=findViewById(R.id.person);
      yule=findViewById(R.id.yule);
      datafenxi=findViewById(R.id.data_fenxi);
      weizhang=findViewById(R.id.weizhang);
        navigation_view = (LinearLayout) findViewById(R.id.navigation_view);

    }

}
