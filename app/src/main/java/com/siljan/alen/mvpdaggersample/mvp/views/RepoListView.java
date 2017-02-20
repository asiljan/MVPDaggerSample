package com.siljan.alen.mvpdaggersample.mvp.views;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;

import java.util.List;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface RepoListView extends BaseView {
    void onRepositoriesFetched(List<GithubRepoModel> repositories);
}
