package com.example.repositorydovene.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.repositorydovene.R;
import com.example.repositorydovene.model.Repos;
import com.example.repositorydovene.viewHolder.ReposViewHolder;

import java.util.ArrayList;

public class ReposApater extends RecyclerView.Adapter<ReposViewHolder> {
    private ArrayList<Repos> listReposAdapter;

    public ReposApater(ArrayList<Repos> listUserAdapter) {
        this.listReposAdapter = listUserAdapter;
    }

    public void setListReposAdapter(ArrayList<Repos> listReposAdapter) {
        this.listReposAdapter = listReposAdapter;
    }

    @NonNull
    @Override
    public ReposViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.raw_repository,parent,false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReposViewHolder holder, int position) {
        holder.bind(listReposAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return listReposAdapter.size();
    }
}
