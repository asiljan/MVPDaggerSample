package com.siljan.alen.mvpdaggersample.repos.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.siljan.alen.mvpdaggersample.R;
import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.listItemRepoName)
    TextView mRepoName;
    @BindView(R.id.listItemRepoAvatar)
    ImageView mRepoAvatar;
    @BindView(R.id.listItemRepoDescr)
    TextView mRepoDescr;

    public RepoListViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bindData(GithubRepoModel repoModel, Picasso picasso) {
        mRepoName.setText(String.format("%s", repoModel.getName()));
        mRepoDescr.setText(String.format("%s", repoModel.getRepoDescr()));

        picasso
                .load(repoModel.getGithubUser().getAvatarUrl())
                .into(mRepoAvatar);
//                .placeholder(R.drawable.)
    }
}
