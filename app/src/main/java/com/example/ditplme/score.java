package com.example.ditplme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity {

    public static int recupResultat;

    TextView note, commentaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        note = (TextView) findViewById(R.id.note);

        Bundle bundle = getIntent().getExtras();
        recupResultat = bundle.getInt("RESULTAT");

        note.setText(Integer.toString(recupResultat) + "/10");

        if (recupResultat <= 3) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 1");
        } if (recupResultat > 3 && recupResultat <= 5) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 2");
        } if (recupResultat > 5 && recupResultat <= 7) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 3");
        } if (recupResultat > 7) {
            commentaire = (TextView) findViewById(R.id.commentaire);
            commentaire.setText("phrase 4");
        }

    }
}
