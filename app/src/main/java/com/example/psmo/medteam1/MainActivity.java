package com.example.psmo.medteam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText jeditText1;
    private Button jButton1;
    private TextView jTextView1;
    private RadioButton jradiobutton1;
    private RadioButton jradiobutton2;
    private RadioGroup jrg;
    private CheckBox jCheckBox1;
    private int liczba1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jButton1=(Button) findViewById(R.id.button);
        jButton1.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {
       switch (v.getId()){
           case R.id.button:
               Intent go2Act2 = new Intent(MainActivity.this, Ginekologia_lista.class);
               startActivity(go2Act2);
               break;
       }
    }
}

