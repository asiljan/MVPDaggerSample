package com.siljan.alen.mvpdaggersample.repos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siljan.alen.mvpdaggersample.R;
import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.repos.viewholders.RepoListViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class ReposListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context mContext;
    Picasso mPicasso;

    private List<GithubRepoModel> mRepositories;

    public ReposListAdapter(Context context, Picasso picasso) {
        this.mContext = context;
        this.mPicasso = picasso;
        this.mRepositories = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_repo_list, parent, false);

        return new RepoListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        GithubRepoModel model = mRepositories.get(position);

        RepoListViewHolder viewHolder = (RepoListViewHolder) holder;
        viewHolder.bindData(model, mPicasso);
    }

    @Override
    public int getItemCount() {
        return mRepositories != null ? mRepositories.size() : 0;
    }

    public void updateList(List<GithubRepoModel> repositories) {
        mRepositories.clear();

        mRepositories.addAll(repositories);

        notifyDataSetChanged();
    }
}
