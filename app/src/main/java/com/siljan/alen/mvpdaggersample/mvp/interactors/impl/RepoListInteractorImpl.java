package com.siljan.alen.mvpdaggersample.mvp.interactors.impl;

import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.mvp.listeners.RepoListListener;

import javax.inject.Inject;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListInteractorImpl implements IRepoListInteractor {

    private RepoListListener mListener;

    @Inject
    public RepoListInteractorImpl() {

    }

    @Override
    public void fetchGithubRepos(RepoListListener listListener) {
        this.mListener = listListener;
    }
}
