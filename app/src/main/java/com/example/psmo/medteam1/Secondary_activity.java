package com.example.psmo.medteam1;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Secondary_activity extends AppCompatActivity implements View.OnClickListener {

    private Intent fromAct1;
    private int liczba;
    private Button jButton1;
    private String algType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle p = getIntent().getExtras();
        liczba = p.getInt("key", -1);
        algType = p.getString("algType");
        jButton1=(Button) findViewById(R.id.button);
        jButton1.setOnClickListener(this);

        List<AlgorithmElement> list = null;
        try {

            InputStream is = getAssets().open("file.xml");
            list = new XmlParser().parse(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        fromAct1= getIntent();
        liczba= fromAct1.getIntExtra("key", -1);


    }

    @Override
    public void onBackPressed()
    {
        fromAct1.putExtra("param1",liczba);
        setResult(RESULT_OK,fromAct1);
        //finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
                Bundle bundle =new Bundle();
                Intent go2Act2 = new Intent(Secondary_activity.this, Algorithm_activity.class);
                go2Act2.putExtra("parentID",0);
                startActivity(go2Act2);

    }
}
