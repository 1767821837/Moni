package cdictv.moni.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cdictv.moni.R;

//没有作用的一个类
public class Activity_Guide extends AppCompatActivity implements  Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__guide);
//        new  Thread(this).start();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(2300);
            startActivity(new Intent(Activity_Guide.this,LoginActivity.class));
            finish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
