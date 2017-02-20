package com.siljan.alen.mvpdaggersample.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.siljan.alen.mvpdaggersample.MyApplication;
import com.siljan.alen.mvpdaggersample.di.components.GithubAppComponent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected Unbinder mUbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies(MyApplication.getInstance().getAppComponent());
    }

    protected void bindViews() {
        ButterKnife.bind(this, mView);
    }

    protected abstract void injectDependencies(GithubAppComponent appComponent);

    protected void showLoadingLayout() {

    }

    protected void hideLoadingLayout() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUbinder != null) {
            mUbinder.unbind();
        }
    }
}
