package com.example.nono.oxfamv2;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * Created by Nono on 26-01-18.
 */

public class Secure extends AppCompatActivity {

    private static final String TAG = "Secure";
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_activity);
        Log.d(TAG, "onCreate : Starting");

        StockDB stock = new StockDB(this);

        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new StockManagment(), "Stock");
        adapter.addFragment(new Promotions(), "Promotions");

        viewPager.setAdapter(adapter);
    }
}
