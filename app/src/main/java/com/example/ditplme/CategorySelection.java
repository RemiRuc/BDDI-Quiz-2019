package com.example.ditplme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CategorySelection extends AppCompatActivity {

    ImageView developerBtn, graphistBtn;

    SharedPreferences sharedCategory;

    public static int selectedCategory = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selection);

        developerBtn = (ImageView) findViewById(R.id.developer);
        graphistBtn = (ImageView) findViewById(R.id.graphist);

        developerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedCategory = 0;
                Intent intent = new Intent(CategorySelection.this, MainActivity.class);
                intent.putExtra("CATEGORY", selectedCategory);
                startActivity(intent);

                sharedCategory = getBaseContext().getSharedPreferences("PREFS_CATEGORY", MODE_PRIVATE);
                sharedCategory
                        .edit()
                        .putString("PREFS_CAT", String.valueOf(selectedCategory))
                        .apply();
            }
        });

        graphistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = 1;
                Intent intent = new Intent(CategorySelection.this, MainActivity.class);
                intent.putExtra("CATEGORY", selectedCategory);
                startActivity(intent);

                sharedCategory = getBaseContext().getSharedPreferences("PREFS_CATEGORY", MODE_PRIVATE);
                sharedCategory
                        .edit()
                        .putString("PREFS_CAT", String.valueOf(selectedCategory))
                        .apply();
            }
        });
    }
}
