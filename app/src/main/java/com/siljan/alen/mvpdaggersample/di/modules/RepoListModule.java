package com.siljan.alen.mvpdaggersample.di.modules;

import android.content.Context;

import com.siljan.alen.mvpdaggersample.di.scopes.FragmentScope;
import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.mvp.interactors.impl.RepoListInteractorImpl;
import com.siljan.alen.mvpdaggersample.mvp.presenters.IRepoListPresenter;
import com.siljan.alen.mvpdaggersample.mvp.presenters.impl.RepoListPresenterImpl;
import com.siljan.alen.mvpdaggersample.mvp.views.RepoListView;
import com.siljan.alen.mvpdaggersample.repos.adapters.ReposListAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@Module
public class RepoListModule {

    private final RepoListView mRepoListView;

    public RepoListModule(RepoListView repoListView) {
        this.mRepoListView = repoListView;
    }

    @Provides
    @FragmentScope
    RepoListView provideRepoListView() {
        return mRepoListView;
    }

    @Provides
    @FragmentScope
    IRepoListInteractor provideRepoListInteractor(RepoListInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @FragmentScope
    IRepoListPresenter provideRepoListPresenter(RepoListPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @FragmentScope
    public ReposListAdapter provideListAdapter(Context context, Picasso picasso) {
        return new ReposListAdapter(context, picasso);
    }
}
