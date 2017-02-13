package com.example.android.outingtime;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by singham on 10/2/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] tabTitle;
    public CategoryAdapter(Context context, FragmentManager fm){
        super(fm);
        mContext = context;

        tabTitle = new String[]{
            mContext.getString(R.string.tab_mall),
            mContext.getString(R.string.tab_couples),
            mContext.getString(R.string.tab_rest),
            mContext.getString(R.string.tab_college)
        };
    }

    @Override
    public Fragment getItem(int position) {
        if(position== 0) return new MallFragment();
        else if(position == 1) return new CouplesFragment();
        else if(position == 2) return new RestaurantFragment();
        else return new CollegeFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position){
        return tabTitle[position];
    }
}