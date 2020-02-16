package com.example.craft_beer_society;

import android.content.Context;
import android.database.DataSetObserver;
import android.widget.ListAdapter;
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


}
