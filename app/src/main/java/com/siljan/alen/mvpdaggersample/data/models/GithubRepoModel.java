package com.siljan.alen.mvpdaggersample.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class GithubRepoModel {
    @SerializedName("id")
    @Expose
    private long mID;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("full_name")
    @Expose
    private String mFullName;
    @SerializedName("owner")
    @Expose
    private GithubUserModel mGithubUser;
    @SerializedName("private")
    @Expose
    private boolean mIsPrivateRepo;
    @SerializedName("description")
    @Expose
    private String mRepoDescr;

    public long getID() {
        return mID;
    }

    public void setID(long mID) {
        this.mID = mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public GithubUserModel getGithubUser() {
        return mGithubUser;
    }

    public void setGithubUser(GithubUserModel mGithubUser) {
        this.mGithubUser = mGithubUser;
    }

    public boolean isIsPrivateRepo() {
        return mIsPrivateRepo;
    }

    public void setIsPrivateRepo(boolean mIsPrivateRepo) {
        this.mIsPrivateRepo = mIsPrivateRepo;
    }

    public String getRepoDescr() {
        return mRepoDescr;
    }

    public void setRepoDescr(String mRepoDescr) {
        this.mRepoDescr = mRepoDescr;
    }
}
