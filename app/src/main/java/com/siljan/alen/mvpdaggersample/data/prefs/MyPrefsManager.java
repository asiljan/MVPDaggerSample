package com.siljan.alen.mvpdaggersample.data.prefs;

import javax.inject.Inject;

/**
 * Created by Alen Siljan on 21.2.2017..
 * alen.siljan@gmail.com
 */

public class MyPrefsManager {

    private static final String KEY_FIRST_RUN = "first_run";

    private SharedPreferencesManager mPreferencesManager;

    @Inject
    public MyPrefsManager(SharedPreferencesManager manager) {
        this.mPreferencesManager = manager;
    }

    //// TODO: 21.2.2017. preferences related methods, i.e. store user auth token
}
