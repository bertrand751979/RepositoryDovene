package com.example.repositorydovene.activity;

import static com.example.repositorydovene.activity.MainActivity.REPOS_LIST_EXTRA;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.repositorydovene.R;
import com.example.repositorydovene.adapter.ReposApater;
import com.example.repositorydovene.model.Repos;
import java.util.ArrayList;

public class DisplayDoveneRepositoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ReposApater adapterUser;
    private ArrayList<Repos>listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_dovene_repository);
        listUser = (ArrayList<Repos>) getIntent().getSerializableExtra(REPOS_LIST_EXTRA);
        recyclerView = findViewById(R.id.recyclerView_display_repository);
        setViewItem();
    }

    private void setViewItem(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapterUser = new ReposApater(listUser);
        recyclerView.setAdapter(adapterUser);
    }

}
