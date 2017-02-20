package com.siljan.alen.mvpdaggersample.mvp.listeners;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;

import java.util.List;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface RepoListListener {
    void onSuccess(List<GithubRepoModel> repositories);

    void onError(String msg);
}
