package com.example.repositorydovene.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.repositorydovene.R;
import com.example.repositorydovene.RepositoryDoveneApi;
import com.example.repositorydovene.model.Repos;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editName;
    private Button btnDisplay;
    public ArrayList<Repos> myRepoList =new ArrayList<>();
    public static String REPOS_LIST_EXTRA = "reposListExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName =findViewById(R.id.editRepositoryName);
        btnDisplay=findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callService();
            }
        });
    }

    public void callService() {
        RepositoryDoveneApi.RepositoryDoveneService service = RepositoryDoveneApi.getInstance().getClient().create(RepositoryDoveneApi.RepositoryDoveneService.class);
        Call<List<Repos>> call = service.getRepos(editName.getText().toString());
        call.enqueue(new Callback<List<Repos>>() {
            @Override
            public void onResponse(Call<List<Repos>> call, Response<List<Repos>> response) {
                updateView(response);
            }

            @Override
            public void onFailure(Call<List<Repos>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "404 ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateView(Response<List<Repos>> response) {
        if (response.body().size() > 0) {
            myRepoList = (ArrayList<Repos>) response.body();
           // Log.e("la liste", String.valueOf(myRepoList.size()));
            displayRepos();

        }
    }

    private void displayRepos(){
            Intent intent = new Intent(MainActivity.this, DisplayDoveneRepositoryActivity.class);
            intent.putExtra(REPOS_LIST_EXTRA, myRepoList);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "OK Reponse du serveur", Toast.LENGTH_SHORT).show();

    }


}