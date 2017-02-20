package com.siljan.alen.mvpdaggersample.di.components;

import com.siljan.alen.mvpdaggersample.di.modules.RepoListModule;
import com.siljan.alen.mvpdaggersample.di.scopes.FragmentScope;
import com.siljan.alen.mvpdaggersample.repos.ReposListFragment;

import dagger.Subcomponent;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@FragmentScope
@Subcomponent(modules = RepoListModule.class)
public interface RepoListComponent {
    void inject(ReposListFragment reposListFragment);
}
