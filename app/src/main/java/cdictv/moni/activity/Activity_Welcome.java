package cdictv.moni.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import cdictv.moni.R;
import cdictv.moni.util.Sputil;


//直接把这个作为启动页    取消掉Activity——Guide
public class Activity_Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__welcome);
//        new Thread(this).start();

//        已进入页面直接判断，不用开线程，不用延迟
//        传参数不要用中文
        Boolean flag = Sputil.getBoolean("first_launcher");
        if (flag) {
            Intent intent2 = new Intent(Activity_Welcome.this, LoginActivity.class);
            startActivity(intent2);
            finish();
        } else {
//            这里第一次启动 直接用handler的延迟执行
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //第一次进入app设置阀值
                    Sputil.putString("fazhi","50");
                    Intent intent1 = new Intent(Activity_Welcome.this, LoginActivity.class);
                    startActivity(intent1);
                    finish();
                }
            }, 2300);

        }
        Sputil.putBoolean("first_launcher", true);
//
//
    }

//    @Override
//    public void run() {
//        try {
//            Thread.sleep(1000);
//            Boolean flag=Sputil.getBoolean("第一次启动");
//            if(flag){
//                Intent intent2=new Intent(Activity_Welcome.this,LoginActivity.class);
//                startActivity(intent2);
//                finish();
//            }else{
//                Intent intent1=new Intent(Activity_Welcome.this,Activity_Guide.class);
//                startActivity(intent1);
//                finish();
//            }
//           Sputil.putBoolean("第一次启动",true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
