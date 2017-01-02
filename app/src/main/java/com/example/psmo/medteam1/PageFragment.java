package com.example.psmo.medteam1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class PageFragment extends Fragment implements View.OnClickListener {

    private TextView textView;
    private TextView textView2;
    private ImageButton  infobutton;
    private ImageButton nextbutton;
    private ImageButton prevbutton;
    private Activity act;
    private int positionID;
    private int count_successors;
    private String extrainfo="";
    private String move="";
    private String message="";
    private String xmlfile;
    private String algName;
    private String next;
    private String prev;
    private int image=-1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.page_fragment_layout, container, false);
        textView = (TextView) view.findViewById(R.id.textView);
        textView2=(TextView) view.findViewById(R.id.textView2);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView2.setMovementMethod(new ScrollingMovementMethod());
        infobutton=(ImageButton) view.findViewById(R.id.info_button);
        nextbutton=(ImageButton) view.findViewById(R.id.next_button);
        prevbutton=(ImageButton) view.findViewById(R.id.prev_button);
        Bundle bundle = getArguments();
        extrainfo=bundle.getString("extrainfo");
        message = bundle.getString("opis");
        move=bundle.getString("krok");
        positionID=bundle.getInt("position");
        image=bundle.getInt("image");
        count_successors=bundle.getInt("count_successors");
        xmlfile = bundle.getString("xml");
        algName = bundle.getString("algName");
        next = bundle.getString("next");
        prev = bundle.getString("prev");
        infobutton.setVisibility(extrainfo==""?View.INVISIBLE:View.VISIBLE);
        nextbutton.setVisibility(next=="1"?View.VISIBLE:View.INVISIBLE);
        prevbutton.setVisibility(prev=="1"?View.VISIBLE:View.INVISIBLE);
        textView2.setText(move==""?"to końcowy krok":"\n"+move);
        textView.setText(message=="" ? (count_successors==1 ? "Bezwarunkowo przejdź do kolejnego kroku" : "Opisany w kroku" ) : message);

        List<AlgorithmElement> list = null;
        try
        {
            AssetManager mngr = getContext().getAssets();
            InputStream is = mngr.open(xmlfile);

        } catch (IOException e)
            {
                 e.printStackTrace();
            }

        textView2.setOnClickListener(this);
        textView.setOnClickListener(this);
        infobutton.setOnClickListener(this);
        return view;

    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
        case R.id.info_button :
            InfoDialog InfoDialog = new InfoDialog(getContext());
            InfoDialog.setTitle("Dodatkowe Informacje");
            InfoDialog.setMessage(extrainfo);
            InfoDialog.setImage(image);
            InfoDialog.show();
        break;

        default:
            Intent go2Act4 = new Intent(v.getContext(), Algorithm_activity.class);
            go2Act4.putExtra("parentID",positionID);
            go2Act4.putExtra("jakiPlikZXML",xmlfile);
            go2Act4.putExtra("algName", algName);
            startActivity(go2Act4);
        break;
        }

    }


}
