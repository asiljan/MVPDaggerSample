package com.siljan.alen.mvpdaggersample.mvp.interactors;

import com.siljan.alen.mvpdaggersample.mvp.listeners.RepoListListener;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface IRepoListInteractor {
    void fetchGithubRepos(RepoListListener listListener);
}
