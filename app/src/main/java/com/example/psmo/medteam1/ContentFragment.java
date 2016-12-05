package com.example.psmo.medteam1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ContentFragment extends Fragment{
    boolean inLandMode;
    int currentDiagram = 0;
    int currentDiagramPosition=0;
    TouchImageView image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_content_panel, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("currentDiagram", currentDiagram);
        outState.putInt("currentDiagramPosition", currentDiagramPosition);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        image=(TouchImageView) getActivity().findViewById(R.id.img);
        String img = getActivity().getIntent().getStringExtra("jakiPlikObrazem");
        int res = getResources().getIdentifier(img, "drawable", getActivity().getPackageName());
        image.setimage(res);
        View contentFrame = getActivity().findViewById(R.id.content);
        inLandMode = contentFrame != null && contentFrame.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null) {
            currentDiagram = savedInstanceState.getInt("currentDiagram", 0);
            currentDiagramPosition = savedInstanceState.getInt("currentDiagramPosition", 0);
        }

        if (inLandMode){
            //
        }
    }
}
