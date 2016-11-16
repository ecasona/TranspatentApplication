package com.ecasona.transpatentapplication.presenter;

import android.support.v4.widget.DrawerLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;

/**
 * Created by aiy on 2016/11/10.
 * <p>
 * des:
 */

public interface MainPresenter {

    void initNavigationBar(BottomNavigationBar navigationBar);

    void onItemClick(int resourceId,int i, DrawerLayout drawerLayout);

    void setContent(int resourceId,int i);
}
