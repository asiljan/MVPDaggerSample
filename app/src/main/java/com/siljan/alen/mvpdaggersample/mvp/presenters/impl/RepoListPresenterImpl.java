package com.siljan.alen.mvpdaggersample.mvp.presenters.impl;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.mvp.listeners.RepoListListener;
import com.siljan.alen.mvpdaggersample.mvp.presenters.IRepoListPresenter;
import com.siljan.alen.mvpdaggersample.mvp.views.RepoListView;
import com.siljan.alen.mvpdaggersample.networking.ApiManager;
import com.siljan.alen.mvpdaggersample.networking.callbacks.GithubRepositoriesCallback;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListPresenterImpl implements IRepoListPresenter {

    RepoListView mRepoView;
    ApiManager mApiManager;

    private Subscription mSubscription;

    @Inject
    public RepoListPresenterImpl(RepoListView repoListView, ApiManager apiManager) {
        this.mRepoView = repoListView;
        this.mApiManager = apiManager;
        this.mSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {
        mRepoView.onShowLoadingLayout();

        mSubscription = mApiManager.fetchGithubRepositories(new GithubRepositoriesCallback() {
            @Override
            public void onSuccess(List<GithubRepoModel> repositories) {
                mRepoView.onHideLoadingLayout();
                mRepoView.onRepositoriesFetched(repositories);
            }

            @Override
            public void onError(String msg) {
                mRepoView.onHideLoadingLayout();
                mRepoView.onError(msg);
            }
        });
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
