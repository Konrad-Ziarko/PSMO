package com.example.psmo.medteam1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.ContactViewHolder> {

    private List<Info> contactList;

    AlgorithmAdapter(List<Info> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Info ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.name);
        contactViewHolder.vSteps.setText(ci.steps);
        contactViewHolder.vMeanTime.setText(ci.meanTime);
    }

    @Override
    public ContactViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);
        return new ContactViewHolder(itemView);
    }
    static class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView vName;
        TextView vSteps;
        TextView vMeanTime;

        ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
            vSteps = (TextView)  v.findViewById(R.id.txtSteps);
            vMeanTime = (TextView)  v.findViewById(R.id.txtTime);
        }
    }
}
