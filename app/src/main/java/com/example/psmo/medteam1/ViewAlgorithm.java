package com.example.psmo.medteam1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Radek on 12.12.2016.
 */

public class ViewAlgorithm extends Algorithm_activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_algorithm);

        Button next = (Button) findViewById(R.id.button5);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });
        this.setTitle(getIntent().getStringExtra("algName"));
    }
}
