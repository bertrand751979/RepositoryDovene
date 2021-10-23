package com.example.repositorydovene.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositorydovene.R;
import com.example.repositorydovene.model.Repos;

public class ReposViewHolder extends RecyclerView.ViewHolder {
    private TextView vhName;
    private TextView vhUrl;
    public ReposViewHolder(@NonNull View view) {
        super(view);
        vhName=view.findViewById(R.id.raw_name);
        vhUrl=view.findViewById(R.id.raw_html_url);
    }

    public TextView getVhName() {
        return vhName;
    }

    public void setVhName(TextView vhName) {
        this.vhName = vhName;
    }

    public TextView getVhUrl() {
        return vhUrl;
    }

    public void setVhUrl(TextView vhUrl) {
        this.vhUrl = vhUrl;
    }

    public void bind(Repos user){
        vhName.setText(user.getName());
        vhUrl.setText(user.getHtml_url());
    }
}
