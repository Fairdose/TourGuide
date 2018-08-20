package com.example.st_peter_hq.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentInflater extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentInflater (Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new BarFragment();
        } else if (position == 1) {
            return new FoodFragment();
        } else if (position == 2) {
            return new TouristicFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.tab_1);
        } else if (position == 1) {
            return mContext.getString(R.string.tab_2);
        } else if (position == 2) {
            return mContext.getString(R.string.tab_3);
        } else {
            return mContext.getString(R.string.tab_4);
        }
    }

}
