package com.siljan.alen.mvpdaggersample.mvp.interactors;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;

import java.util.List;

import rx.Observable;

/**
 * This is just simple interface for RepoList model that provides
 * list of github repositories as an Observable(We do not know if it comes
 * from a mock data or from an API, etc.).
 *
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface IRepoListInteractor {
    Observable<List<GithubRepoModel>> getGithubRepos();
}
