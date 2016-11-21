package com.example.psmo.medteam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListaAlgorytmow extends AppCompatActivity {

    public String algType;

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
        AlgorithmAdapter ca = new AlgorithmAdapter(createList(30));
        recList.setAdapter(ca);
        recList.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int position) {
                //Toast.makeText(v.getContext(), "" + position, Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(ListaAlgorytmow.this, Secondary_activity.class);
                //zapakowac do intenta info jaki algorytm
                Bundle b = new Bundle();
                b.putInt("key", position);
                b.putString("algType", algType);
                myIntent.putExtras(b);
                ListaAlgorytmow.this.startActivity(myIntent);
            }
        }));
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


    private List<Info> createList(int size) {

        //czytanie z xmla ile jest algorytmow
        List<Info> result = new ArrayList<>();
        for (int i=0; i < size; i++) {
            Info algoritmInfo = new Info();
            algoritmInfo.name = algType + " " + Info.NAME_PREFIX + i;
            algoritmInfo.steps = Info.STEPS_PREFIX + i;
            algoritmInfo.meanTime = Info.TIME_PREFIX + i + "[min|h]";

            result.add(algoritmInfo);

        }

        return result;
    }
}
