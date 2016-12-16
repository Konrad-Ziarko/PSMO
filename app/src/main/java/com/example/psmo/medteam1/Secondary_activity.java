package com.example.psmo.medteam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Secondary_activity extends AppCompatActivity implements View.OnClickListener {

    private Intent fromAct1;
    private int nrAlgorytmu;
    private Button jButton1;
    private String algType;
    private String jakiPlikZXML;
    private String jakiPlikZObrazem;
    private String algName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle p = getIntent().getExtras();
        nrAlgorytmu = p.getInt("key", -1);
        jakiPlikZXML = p.getString("jakiPlikZXML");
        jakiPlikZObrazem = p.getString("jakiPlikObrazem");
        algType = p.getString("algType");
        algName = p.getString("algName");
        jButton1=(Button) findViewById(R.id.button);
        jButton1.setOnClickListener(this);

        List<AlgorithmElement> list = null;
        try {

            InputStream is = getAssets().open(jakiPlikZXML);
            list = new XmlParser().parse(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        this.setTitle(algName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fromAct1= getIntent();
        nrAlgorytmu = fromAct1.getIntExtra("key", -1);
    }

    @Override
    public void onBackPressed()
    {
        fromAct1.putExtra("param1", nrAlgorytmu);
        setResult(RESULT_OK,fromAct1);
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Bundle bundle =new Bundle();
        Intent go2Act2 = new Intent(Secondary_activity.this, Algorithm_activity.class);
        nrAlgorytmu = 0;
        bundle.putString("jakiPlikZXML", jakiPlikZXML);
        bundle.putInt("parentID", nrAlgorytmu);
        go2Act2.putExtras(bundle);
        startActivity(go2Act2);

    }
}
