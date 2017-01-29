package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by singham on 30/1/17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    //    public CategoryAdapter(FragmentManager fm,Context context) {
//        super(fm);
//        this.context = context;
//    }
//
    private String[] tabTitle = new String[]{
            "Numbers", "Family", "Colors", "Phrases"};

    //    private Context context;
    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }
//            context.getResources().getString(R.string.category_family),
//            context.getResources().getString(R.string.category_colors),
//            context.getResources().getString(R.string.category_phrases)
//    };

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
