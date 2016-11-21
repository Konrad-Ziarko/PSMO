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

public class Ginekologia_lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ginekologia_lista);
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
                Intent myIntent = new Intent(Ginekologia_lista.this, Secondary_activity.class);
                //zapakowac do intenta info jaki algorytm
                myIntent.putExtra("key", position);
                Ginekologia_lista.this.startActivity(myIntent);
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



    private List<AlgorithmInfo> createList(int size) {

        List<AlgorithmInfo> result = new ArrayList<>();
        for (int i=0; i < size; i++) {
            AlgorithmInfo algoritmInfo = new AlgorithmInfo();
            algoritmInfo.name = AlgorithmInfo.NAME_PREFIX + i;
            algoritmInfo.steps = AlgorithmInfo.STEPS_PREFIX + i;
            algoritmInfo.meanTime = AlgorithmInfo.TIME_PREFIX + i + "[min|h]";

            result.add(algoritmInfo);

        }

        return result;
    }
}
