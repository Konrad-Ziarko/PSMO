package com.example.psmo.medteam1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Algorithm_activity extends FragmentActivity{
    private ViewPager viewPager;
    private View v;
    FloatingActionButton fab;
    private TextView description;
    private TextView labelnext;
    private int parentID=-1;
    private int count_moves=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_layout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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
                is = this.getAssets().open("2.xml");
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

        SwipeAdapter swipe=new SwipeAdapter(getSupportFragmentManager(), getBaseContext(),parentID);
        viewPager.setAdapter(swipe);
    }
}

