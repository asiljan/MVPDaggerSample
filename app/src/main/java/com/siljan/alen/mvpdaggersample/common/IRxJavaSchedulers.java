package com.siljan.alen.mvpdaggersample.common;

import rx.Scheduler;

/**
 * Created by Alen Siljan on 26.2.2017..
 * alen.siljan@gmail.com
 */

public interface IRxJavaSchedulers {
    Scheduler io();

    Scheduler mainThread();
}
