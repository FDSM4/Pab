package com.example.itachi.com.pab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ITACHI on 21-01-2018.
 */
public class Tabpageradaptor extends FragmentStatePagerAdapter {
    String[] tabarray = new String[]{"CAKES","NORTH INDIAN FOOD","SNACKS","PICK N DROP"};
    public Tabpageradaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CAKE cak = new CAKE();
                return cak;
            case 1:
                NORTH nr = new NORTH();
                return nr;
            case 2:
                SNACK sk = new SNACK();
                return sk;
            case 3:
                PND pn = new PND();
                return pn;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}