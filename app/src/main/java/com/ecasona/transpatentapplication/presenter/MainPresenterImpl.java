package com.ecasona.transpatentapplication.presenter;


import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ecasona.transpatentapplication.R;
import com.ecasona.transpatentapplication.model.MainModel;
import com.ecasona.transpatentapplication.model.MainModelImpl;
import com.ecasona.transpatentapplication.ui.activity.MainActivity;
import com.ecasona.transpatentapplication.view.MainView;

/**
 * Created by Administrator on 2016/11/10
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private MainModel mainModel;

    private int currentPlace = 0;
    private static final String TAG = MainPresenter.class.getSimpleName();

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModelImpl();
    }

    @Override
    public void initNavigationBar(BottomNavigationBar navigationBar) {
        for (BottomNavigationItem item : mainModel.initNavigation()) {
            navigationBar.addItem(item);
        }
        navigationBar.initialise();
    }

    @Override
    public void onItemClick(int resourceId, int i, DrawerLayout drawerLayout) {
        Log.e(TAG, "onItemClick: " + i);
        setContent(resourceId, i);
        currentPlace = i;
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void setContent(int resourceId, int i) {
        ((MainActivity) mainView).getSupportFragmentManager().beginTransaction().replace(resourceId, MainModelImpl.initFragments().get(i)).commit();
    }
}