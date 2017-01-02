package com.example.psmo.medteam1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Algorithm_activity extends AppCompatActivity{
    private ViewPager viewPager;
    private View v;
    FloatingActionButton fab;
    FloatingActionButton fab2;
    private TextView description;
    private TextView labelnext;
    private int parentID=-1;
    private String xmlfile;
    private int count_moves=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_layout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
                Intent intentMain = new Intent(Algorithm_activity.this ,
                        ViewAlgorithm.class);
                Bundle bundle=new Bundle();
                bundle.putString("algName", getIntent().getStringExtra("algName"));
                intentMain.putExtras(bundle);
                Algorithm_activity.this.startActivity(intentMain);
            }
        });
        description=(TextView)findViewById(R.id.TextDescription);
        description.setMovementMethod(new ScrollingMovementMethod());
        labelnext=(TextView)findViewById(R.id.TextMove);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        if (getIntent().hasExtra("parentID"))
        {

            InputStream is = null;
            List<AlgorithmElement> list = null;
            String opis="";
            parentID=getIntent().getIntExtra("parentID",-1);
            try
            {
                //is = this.getAssets().open("2.xml");
                xmlfile = getIntent().getStringExtra("jakiPlikZXML");
                is = this.getAssets().open(xmlfile);
            } catch (IOException e1)
                {
                    e1.printStackTrace();
                }

            try
            {
                list = new XmlParser().parse(is);
                opis = list.get(parentID).getDescription();
                count_moves=list.get(parentID).getSuccessors().size();
                description.setText(opis);
            } catch (XmlPullParserException e1)
                {
                     e1.printStackTrace();
                } catch (IOException e1)
                    {
                         e1.printStackTrace();
                    }

        }
        labelnext.setText(count_moves==0 ? "Koniec algorytmu...":"Następny Krok");
        if(count_moves==0){
            labelnext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                    startActivityForResult(myIntent,0);
                    //xfinish();
                }
            });
        }
        if(xmlfile!=null) {
            SwipeAdapter swipe = new SwipeAdapter(getSupportFragmentManager(), getBaseContext(), parentID, xmlfile, getIntent().getStringExtra("algName"));
            viewPager.setAdapter(swipe);
        }
        this.setTitle(getIntent().getStringExtra("algName"));
        //Zmiana koloru Actionbar
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#02B375")));

    }

    public void onClick(View v) {
        switch(v.getId())
        {
            default:
                break;
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
        /*if (id == R.id.action_settings) {
            return true;
        }*/
        if (id == R.id.tutorial) {
            startActivity(new Intent(this, IntroActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

