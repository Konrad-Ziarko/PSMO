package com.example.przem.contr1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.ContactViewHolder> {

    private List<AlgorithmInfo> contactList;

    public AlgorithmAdapter(List<AlgorithmInfo> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        AlgorithmInfo ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSteps.setText(ci.steps);
        contactViewHolder.vMeanTime.setText(ci.meanTime);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;
        protected TextView vSteps;
        protected TextView vMeanTime;

        public ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vSteps = (TextView)  v.findViewById(R.id.txtSteps);
            vMeanTime = (TextView)  v.findViewById(R.id.txtTime);
        }
    }
}
