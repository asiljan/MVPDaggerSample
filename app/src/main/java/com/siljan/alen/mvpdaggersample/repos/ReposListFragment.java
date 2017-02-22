package com.siljan.alen.mvpdaggersample.repos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siljan.alen.mvpdaggersample.R;
import com.siljan.alen.mvpdaggersample.common.BaseFragment;
import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.di.components.GithubAppComponent;
import com.siljan.alen.mvpdaggersample.di.modules.RepoListModule;
import com.siljan.alen.mvpdaggersample.mvp.presenters.IRepoListPresenter;
import com.siljan.alen.mvpdaggersample.mvp.views.RepoListView;
import com.siljan.alen.mvpdaggersample.repos.adapters.ReposListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class ReposListFragment extends BaseFragment implements RepoListView {

    public static final String TAG = "repo_list_fragment";

    @BindView(R.id.recyclerView)
    RecyclerView mRepoList;

    @Inject
    ReposListAdapter mListAdapter;
    @Inject
    IRepoListPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void injectDependencies(GithubAppComponent appComponent) {
        appComponent.newRepoListComponent(new RepoListModule(this)).inject(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        super.onDestroy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_repos_list, container, false);

        bindViews();

        initListView();

        return mView;
    }

    private void initListView() {
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        mRepoList.setHasFixedSize(true);
        mRepoList.setLayoutManager(lm);
        mRepoList.setAdapter(mListAdapter);
    }

    @Override
    public void onRepositoriesFetched(List<GithubRepoModel> repositories) {
        mListAdapter.updateList(repositories);
    }

    @Override
    public void onError(String msg) {
        //// TODO: 20.2.2017. implement error handling
    }

    @Override
    public void onShowLoadingLayout() {
        showLoadingLayout();
    }

    @Override
    public void onHideLoadingLayout() {
        hideLoadingLayout();
    }
}
