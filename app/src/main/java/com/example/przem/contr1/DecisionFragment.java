package com.example.przem.contr1;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DecisionFragment extends ListFragment {
    boolean inLandMode;

    public static class Info{
        public static final String[] INFO =
        {
            "Jakis wybor",
            "Inny wybor",
            "Inny wybor",
            "Jeszcze inny wybor",
        };
    }
    private ListView lw;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> connectArrayToListView = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_activated_1, Info.INFO);

        // Connect the ListView to our data
        setListAdapter(connectArrayToListView);

        //parsowanie XML do widoku
        View decisionFrame = getActivity().findViewById(R.id.decision);
        //getListView().addHeaderView(getActivity().findViewById(R.id.scroll_view));

        inLandMode = decisionFrame != null && decisionFrame.getVisibility() == View.VISIBLE;

        if (inLandMode){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            //
        }
        else
            getListView().addHeaderView(getActivity().findViewById(R.id.content));
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //
        if (inLandMode){
            getListView().setItemChecked(position, true);
            //
        }
    }
}
