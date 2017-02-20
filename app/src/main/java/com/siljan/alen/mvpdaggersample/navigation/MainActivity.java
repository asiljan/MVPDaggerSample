package com.siljan.alen.mvpdaggersample.navigation;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siljan.alen.mvpdaggersample.R;
import com.siljan.alen.mvpdaggersample.common.enums.NavigationActionType;

public class MainActivity extends AppCompatActivity {

    public static final int FRAGMENT_HOLDER = R.id.fragment_holder;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        AppNavigationManager.initNavigationManager(mFragmentManager);


        AppNavigationManager.defineNextAction(NavigationActionType.START_SCREEN);
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager.getBackStackEntryCount() > 1) {
            super.onBackPressed();
        } else {
            this.finish();
        }
    }
}
