package com.example.ditplme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ditplme.retro.ApiUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreList extends AppCompatActivity {

    private final String TAG = ScoreList.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_list);

        //JE LIS LES DONNEES

        ApiUtil.getServiceClass().getAllPlayers().enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                if(response.isSuccessful()){
                    List<Player> postList = response.body();
                    Log.d(TAG, "LISTT : "+response.body());
                }else{
                    Log.d(TAG, "LISTT : "+response.code());
                }
            }
            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                //showErrorMessage();
                Log.d(TAG, "error loading from API" + t.getCause());
            }
        });
    }
}
