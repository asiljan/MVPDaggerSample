package com.siljan.alen.mvpdaggersample.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class GithubUserModel {
    @SerializedName("login")
    @Expose
    private String mLoginName;
    @SerializedName("id")
    @Expose
    private long mID;
    @SerializedName("avatar_url")
    @Expose
    private String mAvatarUrl;

    public String getLoginName() {
        return mLoginName;
    }

    public void setLoginName(String mLoginName) {
        this.mLoginName = mLoginName;
    }

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String mAvatarUrl) {
        this.mAvatarUrl = mAvatarUrl;
    }
}
