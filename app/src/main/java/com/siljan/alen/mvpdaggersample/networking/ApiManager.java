package com.siljan.alen.mvpdaggersample.networking;

import android.support.annotation.NonNull;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.networking.callbacks.GithubRepositoriesCallback;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class ApiManager {

    private static final int CODE_SUCCESS_200 = 200;
    private static final int CODE_SUCCESS_201 = 201;

    GithubApiService mApiService;

    @Inject
    public ApiManager(GithubApiService apiService) {
        this.mApiService = apiService;
    }

    public Subscription fetchGithubRepositories(@NonNull final GithubRepositoriesCallback repositoriesCallback) {
        return mApiService.getAllGithubRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends List<GithubRepoModel>>>() {
                    @Override
                    public Observable<? extends List<GithubRepoModel>> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                }).subscribe(new Subscriber<List<GithubRepoModel>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        repositoriesCallback.onError(e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(List<GithubRepoModel> githubRepoModels) {
                        repositoriesCallback.onSuccess(githubRepoModels);
                    }
                });
    }

//    /**
//     * The method fetches all github repositories from an API
//     *
//     * @param repositoriesCallback GithubRepositoriesCallback
//     */
//    public void fetchGithubRepositories(@NonNull final GithubRepositoriesCallback repositoriesCallback) {
//        Call<List<GithubRepoModel>> call = mApiService.getAllRepos();
//        call.enqueue(new Callback<List<GithubRepoModel>>() {
//            @Override
//            public void onResponse(Call<List<GithubRepoModel>> call, Response<List<GithubRepoModel>> response) {
//                if (responseOK(response.isSuccessful(), response.code())) {
//                    repositoriesCallback.onSuccess(response.body());
//                } else {
//                    //// TODO: 20.2.2017. implement proper onError handling
//                    repositoriesCallback.onError("ERROR");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<GithubRepoModel>> call, Throwable t) {
//
//            }
//        });
//    }

    private boolean responseOK(boolean isSuccess, int code) {
        return isSuccess && (code == CODE_SUCCESS_200 || code == CODE_SUCCESS_201);
    }
}
