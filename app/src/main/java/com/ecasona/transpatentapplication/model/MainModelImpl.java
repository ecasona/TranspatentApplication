package com.ecasona.transpatentapplication.model;


import android.support.v4.app.Fragment;

import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ecasona.transpatentapplication.R;
import com.ecasona.transpatentapplication.ui.fragment.AFragment;
import com.ecasona.transpatentapplication.ui.fragment.BFragment;
import com.ecasona.transpatentapplication.ui.fragment.CFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/10
 */

public class MainModelImpl implements MainModel {

    @Override
    public List<BottomNavigationItem> initNavigation() {
        List<BottomNavigationItem> list = new ArrayList<>();
        list.add(new BottomNavigationItem(R.mipmap.ic_launcher, "main"));
        return list;
    }

    public static List<Fragment> initFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(AFragment.newInstance());
        fragments.add(BFragment.newInstance());
        fragments.add(CFragment.newInstance());
        return fragments;
    }
}