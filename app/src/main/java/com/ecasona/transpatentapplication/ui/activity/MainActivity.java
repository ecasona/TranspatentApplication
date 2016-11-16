package com.ecasona.transpatentapplication.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ecasona.transpatentapplication.R;
import com.ecasona.transpatentapplication.base.BaseActivity;
import com.ecasona.transpatentapplication.presenter.MainPresenter;
import com.ecasona.transpatentapplication.presenter.MainPresenterImpl;
import com.ecasona.transpatentapplication.ui.fragment.AFragment;
import com.ecasona.transpatentapplication.utils.StatusBarCompat;
import com.ecasona.transpatentapplication.view.MainView;

public class MainActivity extends BaseActivity implements MainView, AdapterView.OnItemClickListener, AFragment.OnFragmentInteractionListener {


    private MainPresenter mainPresenter;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setPadding(0, StatusBarCompat.getStatusBarHeight(this), 0, 0);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ListView listView = (ListView) findViewById(R.id.drawer_view);
        listView.setAdapter(new ArrayAdapter<>(MainActivity.this, R.layout.item_drawer_list, R.id.tv_title, new String[]{"1", "2", "3"}));
        listView.setOnItemClickListener(this);

        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.action_settings, R.string.action_more);
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);

        BottomNavigationBar navigationBar = (BottomNavigationBar) findViewById(R.id.navigationBar);
        mainPresenter.initNavigationBar(navigationBar);

        mainPresenter.setContent(R.id.content, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_more) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mainPresenter.onItemClick(R.id.content, i, drawerLayout);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
