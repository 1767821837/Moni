package cdictv.moni.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cdictv.moni.R;


public class CarWeizhangImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_weizhang_image);
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
