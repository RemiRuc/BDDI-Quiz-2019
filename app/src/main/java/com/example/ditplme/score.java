package com.example.ditplme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class score extends AppCompatActivity {

    public static int recupResultat;

    TextView note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        note = (TextView) findViewById(R.id.note);

        Bundle bundle = getIntent().getExtras();
        recupResultat = bundle.getInt("RESULTAT");

        note.setText(Integer.toString(recupResultat) + "/10");
    }
}
