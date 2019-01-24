package com.example.ditplme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ditplme.retro.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class score extends AppCompatActivity {

    public static int recupResultat;

    TextView note;

    private final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        note = (TextView) findViewById(R.id.note);

        Bundle bundle = getIntent().getExtras();
        recupResultat = bundle.getInt("RESULTAT");

        note.setText(Integer.toString(recupResultat) + "/10");

        Call<SubscriptionResponse> call = ApiUtil.getServiceClass().createPlayer("Yo", "f@n", 9, 1);
        call.enqueue(new Callback<SubscriptionResponse>() {

            @Override
            public void onResponse(Call<SubscriptionResponse> call, Response<SubscriptionResponse> response) {

                if(response.isSuccessful()){
                    Log.d(TAG, "ajouté !");

                    if(response.body() != null) {
                        Log.d(TAG, "alors : " + response.body().toString());
                        Log.d(TAG, "STATUS : " + response.body().status);
                        Log.d(TAG, "PLAYERS : " + response.body().listPlayers);

                    }

                    Intent intentSndActivity = new Intent(score.this, MainMenu.class); // Intent explicite je lui dis exactement où il doit aller
                    startActivity(intentSndActivity); // Lance le deuxième interface

                } else {
                    Log.e(TAG, "erreur http : " + response.code());
                    Intent intentSndActivity = new Intent(score.this, MainMenu.class); // Intent explicite je lui dis exactement où il doit aller
                    startActivity(intentSndActivity); // Lance le deuxième interface
                }
            }

            @Override
            public void onFailure(Call<SubscriptionResponse> call, Throwable t) {
                Log.e(TAG, "bug !" + t);
            }
        });
    }
}
