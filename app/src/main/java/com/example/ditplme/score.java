package com.example.ditplme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity {

    public static int recupResultat;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedCategory;

    TextView note, commentaire, nameUser;

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

        Button retour = (Button) findViewById(R.id.return_button);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(score.this, MainMenu.class);
                startActivity(intent);
            }
        });
    }
}
