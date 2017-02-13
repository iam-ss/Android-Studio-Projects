package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by singham on 30/1/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] tabTitle;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;

        tabTitle = new String[]{
                mContext.getString(R.string.category_numbers),
                mContext.getString(R.string.tab_family),
                mContext.getString(R.string.category_colors),
                mContext.getString(R.string.category_phrases)
        };
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhraseFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}