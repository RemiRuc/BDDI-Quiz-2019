package com.example.ditplme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ditplme.retro.ApiUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreList extends AppCompatActivity {

    private final String TAG = ScoreList.class.getSimpleName();

    ListView mListView;

    private ArrayList<String> pseudos;
    private int[] scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_list);

        pseudos = new ArrayList<>();
        //JE LIS LES DONNEES

        ApiUtil.getServiceClass().getAllPlayers().enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                if(response.isSuccessful()){
                    List<Player> postList = response.body();
                    Log.d(TAG, "LISTT : "+response.body());

                    for(int i = 0; i < response.body().size()  ; i++) {

                        Log.d(TAG, "OBJECT  : "+response.body().get(i));

                         pseudos.add(response.body().get(i).toString());
                        //scores[i] = response.body().get(i).getScore();
                    }


                    mListView = (ListView) findViewById(R.id.listview);

                    //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
                    //Contenant une TextView avec comme identifiant "@android:id/text1"

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ScoreList.this,
                            android.R.layout.simple_list_item_1, pseudos);
                    mListView.setAdapter(adapter);
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

        Button retourFirstPage = (Button) findViewById(R.id.return_first_page);

        retourFirstPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScoreList.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}
