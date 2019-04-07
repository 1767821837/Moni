package cdictv.moni.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;
import cdictv.moni.adatper.PersongAdatper;
import cdictv.moni.fagement.CzlsFragment;
import cdictv.moni.fagement.FazhiFragment;
import cdictv.moni.fagement.Xinxifragment;

public class PersonActivity extends AppCompatActivity {

    private ImageView back;
    private TabLayout tablyout;
    private ViewPager viewpager;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private PersongAdatper mPersongAdatper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        mFragments=new ArrayList<>();
        mTitles=new ArrayList<>();
        initView();
        getData();
        initAdatper();

    }

    private void getData() {
    mTitles.add("个人信息");
    mTitles.add("充值记录");
    mTitles.add("阀值设置");
    mFragments.add(new Xinxifragment());
    mFragments.add(new CzlsFragment());
    mFragments.add(new FazhiFragment());
    }

    private void initAdatper() {
        mPersongAdatper = new PersongAdatper(getSupportFragmentManager(),
                mFragments,mTitles,PersonActivity.this);
        tablyout.setupWithViewPager(viewpager);
        viewpager.setAdapter(mPersongAdatper);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablyout));
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);
        tablyout = (TabLayout) findViewById(R.id.tablyout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
    }
}
