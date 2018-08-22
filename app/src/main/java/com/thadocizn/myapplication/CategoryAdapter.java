package com.thadocizn.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context context;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.category_church);
        } else if (position == 1) {
            return context.getString(R.string.category_restaurant);
        } else if (position == 2) {
            return context.getString(R.string.category_hotel);
        } else {
            return context.getString(R.string.category_events);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ChurchFragment();
        } else if (position == 1) {
            return new RestaurantFragment();
        } else if (position == 2) {
            return new HotelFragment();
        } else {
            return new EventFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
