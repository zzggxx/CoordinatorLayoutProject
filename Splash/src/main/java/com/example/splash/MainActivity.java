package com.example.splash;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewpager;
    private SimpleFragment mSimpleFragment;
    private SimpleFragment mSimpleFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragmentsAndTitles();
        attachTabToViewPager();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.staff_main_tab);
        mViewpager = (ViewPager) findViewById(R.id.staff_main_vp);

        final AppBarLayout id_appbarlayout = (AppBarLayout) findViewById(R.id.id_appbarlayout);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSimpleFragment.mRecyclerview.scrollToPosition(0);
                        id_appbarlayout.setExpanded(true, true);
                    }
                });
            }
        }, 5000);
    }

    private void attachTabToViewPager() {
        ViewPagerFragmentAdapter fragmentAdapter =
                new ViewPagerFragmentAdapter(getSupportFragmentManager(), mFragmentList, mTitles);
        mViewpager.setAdapter(fragmentAdapter);
        mViewpager.setOffscreenPageLimit(mFragmentList.size());
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setupWithViewPager(mViewpager);
        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }

    private void initFragmentsAndTitles() {
        mSimpleFragment = new SimpleFragment();
        mSimpleFragment1 = new SimpleFragment();
        mFragmentList.add(mSimpleFragment);
        mFragmentList.add(mSimpleFragment1);
        mTitles.add("first");
        mTitles.add("second");
    }
}
