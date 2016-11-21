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
    private Button jButton2;
    private Button jButton3;
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
        jButton2=(Button) findViewById(R.id.button2);
        jButton2.setOnClickListener(this);
        jButton3=(Button) findViewById(R.id.button3);
        jButton3.setOnClickListener(this);
    }

    private final String ginekologia = "Ginekologia";
    private final String pediatria = "Pediatria";
    private final String onkologia = "Onkologia";
    @Override
    public void onClick (View v) {
        Intent go2Act2 = null;
        Bundle b = new Bundle();
        int i = v.getId();
        if (i == R.id.button) {
            go2Act2 = new Intent(MainActivity.this, ListaAlgorytmow.class);
            b.putString("algType", ginekologia);

        } else if (i == R.id.button2) {
            go2Act2 = new Intent(MainActivity.this, ListaAlgorytmow.class);
            b.putString("algType", pediatria);

        } else if (i == R.id.button3) {
            go2Act2 = new Intent(MainActivity.this, ListaAlgorytmow.class);
            b.putString("algType", onkologia);
        }
        go2Act2.putExtras(b);
        startActivity(go2Act2);
    }
}

