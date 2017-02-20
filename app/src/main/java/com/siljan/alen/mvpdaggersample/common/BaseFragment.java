package com.siljan.alen.mvpdaggersample.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RelativeLayout;

import com.siljan.alen.mvpdaggersample.MyApplication;
import com.siljan.alen.mvpdaggersample.R;
import com.siljan.alen.mvpdaggersample.di.components.GithubAppComponent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @BindView(R.id.loadingBarHolder)
    RelativeLayout mLoadingLayout;

    protected View mView;
    protected Unbinder mUbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies(MyApplication.getInstance().getAppComponent());
    }

    protected void bindViews() {
        mUbinder = ButterKnife.bind(this, mView);
    }

    protected abstract void injectDependencies(GithubAppComponent appComponent);

    protected void showLoadingLayout() {
        if (mLoadingLayout != null) {
            mLoadingLayout.setVisibility(View.VISIBLE);
        }
    }

    protected void hideLoadingLayout() {
        if (mLoadingLayout != null) {
            mLoadingLayout.setVisibility(View.GONE);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUbinder != null) {
            mUbinder.unbind();
        }
    }
}
