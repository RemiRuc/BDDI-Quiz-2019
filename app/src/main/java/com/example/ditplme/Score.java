package com.example.ditplme;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class Score extends AppCompatActivity {

    public static int recupResultat;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedCategory;

    TextView note, commentaire, nameUser;

    private final String TAG = Score.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        sharedPreferences = getBaseContext().getSharedPreferences("PREFS", MODE_PRIVATE);
        sharedCategory = getBaseContext().getSharedPreferences("PREFS_CATEGORY", MODE_PRIVATE);
        String name = sharedPreferences.getString("PREFS_NAME", "inconnu");
        String mail = sharedPreferences.getString("PREFS_MAIL",null);
        String category = sharedCategory.getString("PREFS_CAT",null);

        nameUser = (TextView) findViewById(R.id.nameUser);
        nameUser.setText(name);




        note = (TextView) findViewById(R.id.note);

        Bundle bundle = getIntent().getExtras();
        recupResultat = bundle.getInt("RESULTAT");

        note.setText(Integer.toString(recupResultat) + "/10");

        if (recupResultat <= 3) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 1");
        } if (recupResultat > 3 && recupResultat <= 5) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("Après avoir évalué tes réponses, nous sommes dans le regret de t’annoncer que tu n’es pas en mesure d’obtenir ton diplôme.\n Cependant, nous pensons que tu es fait pour exercer le métier de boulanger...");
        } if (recupResultat > 5 && recupResultat <= 7) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 3");
        } if (recupResultat > 7) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 4");
        }

        Call<SubscriptionResponse> call = ApiUtil.getServiceClass().createPlayer(name, mail, recupResultat, Integer.parseInt(category));
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

                    Intent intentSndActivity = new Intent(Score.this, MainMenu.class); // Intent explicite je lui dis exactement où il doit aller
                    startActivity(intentSndActivity); // Lance le deuxième interface

                } else {
                    Log.e(TAG, "erreur http : " + response.code());
                    Intent intentSndActivity = new Intent(Score.this, MainMenu.class); // Intent explicite je lui dis exactement où il doit aller
                    startActivity(intentSndActivity); // Lance le deuxième interface
                }
            }

            @Override
            public void onFailure(Call<SubscriptionResponse> call, Throwable t) {
                Log.e(TAG, "bug !" + t);
            }
        });

        Button retour = (Button) findViewById(R.id.return_button);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, ScoreList.class);
                startActivity(intent);
            }
        });
    }
}
