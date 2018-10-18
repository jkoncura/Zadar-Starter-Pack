package com.neta.android.zadar_starterpack;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neta.android.zadar_starterpack.fragments.BeachesFragment;
import com.neta.android.zadar_starterpack.fragments.CuisineFragment;
import com.neta.android.zadar_starterpack.fragments.NightLifeFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mViewPagerAdapter.addFragment(new CuisineFragment(),getString(R.string.category_cuisine));
        mViewPagerAdapter.addFragment(new BeachesFragment(),getString(R.string.category_beaches));
        mViewPagerAdapter.addFragment(new NightLifeFragment(),getString(R.string.category_nightlife));

        mViewPager.setAdapter(mViewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
}

