package cdictv.moni.adatper;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class PersongAdatper extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    private List<String> mTitles;
    Context mContext;
    public PersongAdatper(FragmentManager fm,List<Fragment> fragments,
                          List<String> titles,Context context) {
        super(fm);
        mFragments=fragments;
        mTitles=titles;
        mContext=context;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
