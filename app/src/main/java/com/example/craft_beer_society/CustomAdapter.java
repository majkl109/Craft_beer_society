package com.example.craft_beer_society;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter implements ListAdapter {
    ArrayList<BeerData> arrayList;
    Context context;

    public CustomAdapter(ArrayList<BeerData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @Override
    public boolean areAllItemsEnabled(){
        return false;
    }
    @Override
    public boolean isEnabled(int position){
        return true;
    }
    @Override
    public void registerDataObserver(DataSetObserver observer){
    }
    @Override
    public void unregisterDataObserver(DataSetObserver observer){
    }
    @Override
    public int getCount(){
        return arrayList.size();
    }
    @Override
    public Object getItem(int position){
        return position;
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public  boolean hasStableIds(){
        return false;
    }
    @Override View getView(int position, View convertView, ViewGroup parent){
        BeerData beerData = arrayList.get(position);
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_row,null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            TextView tittle = convertView.findViewById(R.id.title);
            ImageView imag = convertView.findViewById(R.id.list_image);
            tittle.setText(beerData.BeerName);
            Picasso.with(context).load(beerData.Image).into(imag);
        }
        return convertView;
    }


}
