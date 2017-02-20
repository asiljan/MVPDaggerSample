package com.siljan.alen.mvpdaggersample.mvp.views;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public interface BaseView {
    void onShowLoadingLayout();

    void onHideLoadingLayout();

    void onError(String msg);
}
