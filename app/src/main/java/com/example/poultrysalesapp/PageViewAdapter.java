package com.example.poultrysalesapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

class PageViewAdapter extends FragmentPagerAdapter
{

    private final List<Fragment> mfragmentList = new ArrayList<>();

    public PageViewAdapter(FragmentManager fm)
    {
//        super(fm);
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //return null;
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        //return 0;
        return mfragmentList.size();
    }

    public void addFragment(Fragment fragment)
    {
        mfragmentList.add(fragment);
    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//
//        Fragment fragment = null;
//        switch (position)
//        {
//            case 0: fragment = new FragmentType1();
//                    break;
//
//            case 1: fragment = new FragmentType2();
//                break;
//
//            case 2: fragment = new FragmentType3();
//                break;
//        }
//
//        return fragment;
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
}
