package com.siljan.alen.mvpdaggersample.navigation;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.siljan.alen.mvpdaggersample.common.enums.NavigationActionType;
import com.siljan.alen.mvpdaggersample.repos.ReposListFragment;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class AppNavigationManager {
    private static FragmentManager mFragmentManager;

    static void initNavigationManager(FragmentManager manager) {
        mFragmentManager = manager;
    }

    public static void defineNextAction(NavigationActionType navigationActionType) {
        switch (navigationActionType) {
            case START_SCREEN:
                showRepoListFragment();
                break;
        }
    }

    private static void showRepoListFragment() {
        ReposListFragment fragment = new ReposListFragment();
        FragmentTransaction fTransaction = mFragmentManager.beginTransaction();
        fTransaction.replace(MainActivity.FRAGMENT_HOLDER, fragment, ReposListFragment.TAG);
        fTransaction.addToBackStack(null);
        fTransaction.commit();
    }
}
