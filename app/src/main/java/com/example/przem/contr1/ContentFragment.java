package com.example.przem.contr1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.przem.contr1.R;


public class ContentFragment extends Fragment{
    boolean inLandMode;
    int currentDiagram = 0;
    int currentDiagramPosition=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_panel, container, false);
        return view;
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
        //parsowanie XML do widoku

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
