package com.example.splash;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<String> mTitles = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewpager;

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
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());
        mTitles.add("first");
        mTitles.add("second");
    }
}
