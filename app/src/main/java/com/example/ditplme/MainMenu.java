package com.example.ditplme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        Button startquiz = (Button) findViewById(R.id.next_button);
        startquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = findViewById(R.id.field);
                EditText mail = findViewById(R.id.fieldMail);

                sharedPreferences = getBaseContext().getSharedPreferences("PREFS", MODE_PRIVATE);
                sharedPreferences
                        .edit()
                        .putString("PREFS_NAME", String.valueOf(name.getText()))
                        .putString("PREFS_MAIL", String.valueOf(mail.getText()))
                        .apply();

                Intent intent = new Intent(MainMenu.this, CategorySelection.class);
                startActivity(intent);
            }
        });

    }
}
