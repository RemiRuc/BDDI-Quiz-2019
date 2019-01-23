package com.example.ditplme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategorySelection extends AppCompatActivity {

    Button developerBtn, graphistBtn;

    public static String selectedCategory = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_selection);

        developerBtn = (Button) findViewById(R.id.developer);
        graphistBtn = (Button) findViewById(R.id.graphist);

        developerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = "dev";
                Intent intent = new Intent(CategorySelection.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("selectedCategory", selectedCategory);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        graphistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedCategory = "graph";
                startActivity(new Intent(CategorySelection.this, MainActivity.class));
            }
        });
    }
}
