package com.siljan.alen.mvpdaggersample.networking.callbacks;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;

import java.util.List;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface GithubRepositoriesCallback {
    void onSuccess(List<GithubRepoModel> repositories);

    void onError(String msg);
}
