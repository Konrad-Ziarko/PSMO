package com.example.przem.contr1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Secondary_activity extends AppCompatActivity {

    private Intent fromAct1;
    private  int mnoznik,liczba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_activity);
        fromAct1=new Intent();
        mnoznik=23;
    }

    @Override
    protected void onResume() {
        super.onResume();
        fromAct1= getIntent();
        liczba= fromAct1.getIntExtra("param1",0);
        Toast.makeText(this,String.valueOf(liczba).toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed()
    {
        liczba=liczba*mnoznik;
        fromAct1.putExtra("param1",liczba);
        setResult(RESULT_OK,fromAct1);
        //finish();
        super.onBackPressed();
    }
}
