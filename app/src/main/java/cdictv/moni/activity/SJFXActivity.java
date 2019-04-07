package cdictv.moni.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;
import cdictv.moni.adatper.SJFX_VP_Adapter;
import cdictv.moni.fagement.Bar1Fragment;
import cdictv.moni.fagement.Bar2Fragment;
import cdictv.moni.fagement.Bar3Fragment;
import cdictv.moni.fagement.Pic2Fragment;
import cdictv.moni.fagement.PicFragment;

public class SJFXActivity extends AppCompatActivity {
    private ImageView back;
    private ViewPager viewPager;
    private SJFX_VP_Adapter sjfx_vp_adapter;
    private List<Fragment> fragmentList=new ArrayList<>();
    private RadioButton r1;
    private RadioButton r2;
    private RadioButton r3;
    private RadioButton r4;
    private RadioButton r5;
    private RadioButton r6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjfx);
        init();
        getFragment();
        setVPadapter();

    }

    private void getFragment() {
        fragmentList.add(new PicFragment(SJFXActivity.this, R.layout.sjfx_pic_layout));
        fragmentList.add(new Pic2Fragment(SJFXActivity.this,R.layout.sjfx_pic_layout));
        fragmentList.add(new Bar1Fragment(SJFXActivity.this,R.layout.sjfx_bar1_layout));
        fragmentList.add(new Bar2Fragment(SJFXActivity.this,R.layout.sjfx_bar2_layout));
        fragmentList.add(new Bar3Fragment(SJFXActivity.this,R.layout.sjfx_bar3_layout));
    }

    private void setVPadapter() {
        sjfx_vp_adapter = new SJFX_VP_Adapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(sjfx_vp_adapter);

    }

    private void init() {
        back = findViewById(R.id.back);
        viewPager = findViewById(R.id.viewPager);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
    }
}
