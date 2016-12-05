package com.example.psmo.medteam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Bundle p = getIntent().getExtras();
        nrAlgorytmu = p.getInt("key", -1);
        jakiPlikZXML = p.getString("jakiPlikZXML");
        jakiPlikZObrazem = p.getString("jakiPlikObrazem");
        algType = p.getString("algType");
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
        //finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        Bundle bundle =new Bundle();
        Intent go2Act2 = new Intent(Secondary_activity.this, Algorithm_activity.class);
        //
        nrAlgorytmu = 0;
        bundle.putString("jakiPlikZXML", jakiPlikZXML);
        bundle.putInt("parentID", nrAlgorytmu);
        go2Act2.putExtras(bundle);
        startActivity(go2Act2);
        //go2Act2.putExtra("parentID", nrAlgorytmu);
        //startActivity(go2Act2);




        /*undle b = new Bundle();
        b.putInt("key", allAlgorithms.get(position).getId());
        b.putString("algType", algType);
        b.putString("jakiPlikZXML", allAlgorithms.get(position).getFile());
        b.putString("jakiPlikObrazem", allAlgorithms.get(position).getImage());
        myIntent.putExtras(b);
        ListaAlgorytmow.this.startActivity(myIntent);*/
    }
}
