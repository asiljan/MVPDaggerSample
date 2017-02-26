package com.siljan.alen.mvpdaggersample.networking;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface GithubApiService {
    String REPOS_ENDPOINT = "repositories";


    @GET(REPOS_ENDPOINT)
    rx.Observable<List<GithubRepoModel>> getAllGithubRepos();
}
