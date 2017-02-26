package com.siljan.alen.mvpdaggersample.mvp.presenters.impl;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.mvp.presenters.IRepoListPresenter;
import com.siljan.alen.mvpdaggersample.mvp.views.RepoListView;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListPresenterImpl implements IRepoListPresenter {

    RepoListView mRepoView;
    IRepoListInteractor mInteractor;

    private Subscription mSubscription;

    @Inject
    public RepoListPresenterImpl(RepoListView repoListView, IRepoListInteractor interactor) {
        this.mRepoView = repoListView;
        this.mInteractor = interactor;
        this.mSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {
        mRepoView.onShowLoadingLayout();

        mSubscription = mInteractor.getGithubRepos()
                .subscribe(new Observer<List<GithubRepoModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mRepoView.onHideLoadingLayout();
                        mRepoView.onError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<GithubRepoModel> githubRepoModels) {
                        mRepoView.onHideLoadingLayout();
                        mRepoView.onRepositoriesFetched(githubRepoModels);
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
