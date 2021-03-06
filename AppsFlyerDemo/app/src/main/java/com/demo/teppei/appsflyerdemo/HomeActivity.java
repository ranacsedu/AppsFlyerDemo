package com.demo.teppei.appsflyerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.demo.teppei.appsflyerdemo.R;

import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private static final String AF_DEV_KEY = "<HLSoWZFpzn84UNyH8kWFpN>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // initizlize AppsFlyer object
        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {
                    @Override
                    public void onInstallConversionDataLoaded(Map<String, String> conversionData) {
                        Log.v("AppsFlyer:","onInstallConversionDataLoaded:" + conversionData);
                        for (String attrName : conversionData.keySet()) {
                            Log.d(AppsFlyerLib.LOG_TAG, "conversion_attribute: " + attrName + " = " +
                                    conversionData.get(attrName));
                        }
                    }

                    @Override
                    public void onInstallConversionFailure(String errorMessage) {
                        Log.v("AppsFlyer:","onInstallConversionFailure:" + errorMessage);
                    }

                    @Override
                    public void onAppOpenAttribution(Map<String, String> attributionData) {
                        Log.v("AppsFlyer:","onAppOpenAttribution:" + attributionData);
                        for (String attrName : attributionData.keySet()) {
                            Log.d(AppsFlyerLib.LOG_TAG, "onAppOpen_attribute: " + attrName + " = " +
                                    attributionData.get(attrName));
                        }
                    }

                    @Override
                    public void onAttributionFailure(String errorMessage) {
                        Log.v("AppsFlyer:","onAttributionFailure:" + errorMessage);
                    }
                    //
                };
        Log.v("AppsFlyer:","Init AppsFlyer object" );
        //Log.i("AppsFlyer:","Init AppsFlyer object" );
        //Log.d("AppsFlyer:","Init AppsFlyer object" );
        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionDataListener, getApplicationContext());
        AppsFlyerLib.getInstance().startTracking(this.getApplication());
        //AppsFlyerLib.getInstance().startTracking(this.getApplication(),AF_DEV_KEY);
        AppsFlyerLib.getInstance().sendDeepLinkData(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Product"));
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
