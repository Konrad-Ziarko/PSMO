package com.example.psmo.medteam1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ListaAlgorytmow extends AppCompatActivity {

    public String algType;
    private List<SingleAlgorithm> allAlgorithms = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle p = getIntent().getExtras();
        algType = p.getString("algType");
        setContentView(R.layout.activity_lista);
        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(linearLayoutManager);
        try {
            allAlgorithms = createList();
            AlgorithmAdapter ca = new AlgorithmAdapter(allAlgorithms);
            //AlgorithmAdapter ca = new AlgorithmAdapter(createList(30));
            recList.setAdapter(ca);
            recList.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    //Toast.makeText(v.getContext(), "" + position, Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(ListaAlgorytmow.this, Secondary_activity.class);
                    //zapakowac do intenta info jaki algorytm
                    Bundle b = new Bundle();
                    b.putInt("key", allAlgorithms.get(position).getId());
                    b.putString("algType", algType);
                    b.putString("jakiPlikZXML", allAlgorithms.get(position).getFile());
                    b.putString("jakiPlikObrazem", allAlgorithms.get(position).getImage());
                    myIntent.putExtras(b);
                    ListaAlgorytmow.this.startActivity(myIntent);
                }
            }));
        }
        catch (Exception e) {
            Toast.makeText(this.getBaseContext(), "Pliki algorytmów nie istnieją", Toast.LENGTH_LONG).show();
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private List<SingleAlgorithm> createList() {

        //czytanie z xmla ile jest algorytmow
        List<SingleAlgorithm> result= null;
        AlgoritmListXmlParser parser = new AlgoritmListXmlParser(algType);
        InputStream is = null;
        try
        {
            is = this.getAssets().open(algType+".xml");
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }

        try
        {
            result = parser.parse(is);
        } catch (XmlPullParserException e1)
        {
            e1.printStackTrace();
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
        /*
        List<AlgorithmInfo> result = new ArrayList<>();
        for (int i=0; i < size; i++) {
            AlgorithmInfo algoritmInfo = new AlgorithmInfo();
            algoritmInfo.name = algType + " " + Info.NAME_PREFIX + i;
            algoritmInfo.steps = Info.STEPS_PREFIX + i;
            algoritmInfo.meanTime = Info.TIME_PREFIX + i + "[min|h]";

            result.add(algoritmInfo);

        }*/

        return result;
    }
}
