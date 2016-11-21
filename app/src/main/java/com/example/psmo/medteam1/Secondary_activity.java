package com.example.psmo.medteam1;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.Toast;

public class Secondary_activity extends AppCompatActivity {

    private Intent fromAct1;
    private int liczba;
    private String algType;
    ImageView imageView;
    Matrix matrix = new Matrix();
    Float scale = 1f;
    ScaleGestureDetector SGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle p = getIntent().getExtras();
        liczba = p.getInt("key", -1);
        algType = p.getString("algType");
        setContentView(R.layout.second_activity);
        //setContentView(R.layout.activity_alg_step);

        //zaladowac xml'a

    }

    @Override
    protected void onResume() {
        super.onResume();
        fromAct1= getIntent();
        liczba= fromAct1.getIntExtra("key", -1);
        Toast.makeText(this,algType + " " + liczba,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed()
    {
        fromAct1.putExtra("param1",liczba);
        setResult(RESULT_OK,fromAct1);
        //finish();
        super.onBackPressed();
    }
}
