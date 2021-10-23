package com.example.repositorydovene;

import com.example.repositorydovene.model.Repos;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RepositoryDoveneApi {
    public interface RepositoryDoveneService{
        /*@GET("users/dovene/repos")
        Call<List<Repos>> getRepos();*/
        @GET("users/{user}/repos")

        Call<List<Repos>> getRepos(@Path("user") String user);


    }
    private final static String BASE_URL="https://api.github.com/";
    private static RepositoryDoveneApi INSTANCE = null;
    private RepositoryDoveneApi() {}
    public static RepositoryDoveneApi getInstance(){
        if (INSTANCE == null){
            INSTANCE = new RepositoryDoveneApi();
        }
        return INSTANCE;
    }
    public Retrofit getClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}
