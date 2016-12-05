package com.example.psmo.medteam1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class AlgorithmAdapter extends RecyclerView.Adapter<AlgorithmAdapter.ContactViewHolder> {

    private List<SingleAlgorithm> contactList;

    AlgorithmAdapter(List<SingleAlgorithm> contactList) {
        this.contactList = contactList;
    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        SingleAlgorithm ci = contactList.get(i);
        contactViewHolder.vName.setText(ci.getName());
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

        ContactViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.txtName);
        }
    }
}
