package com.example.bottomnavigatinwithviewpager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigationView;

    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_item0:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.action_item1:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.action_item2:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.action_item3:
                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.action_item4:
                        mViewPager.setCurrentItem(4);
                        break;


                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }


                    mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                    prevMenuItem = mBottomNavigationView.getMenu().getItem(position);


            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(HomeFragment.newInstance());
        adapter.addFragment(DownloadFragment.newInstance());
        adapter.addFragment(AddFragment.newInstance());
        adapter.addFragment(UploadFragment.newInstance());
        adapter.addFragment(AttachFragment.newInstance());
        viewPager.setAdapter(adapter);
    }

}
