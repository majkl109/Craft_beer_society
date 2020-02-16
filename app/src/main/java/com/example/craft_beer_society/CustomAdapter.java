package com.example.craft_beer_society;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class CustomAdapter implements ListAdapter {
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
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

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
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final BeerData beerData = arrayList.get(position);
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.list_row,null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(beerData.Link));
                    context.startActivity(i);
                    Toast.makeText(context, beerData.Link, Toast.LENGTH_LONG).show();

                }
            });
            TextView tittle = convertView.findViewById(R.id.title);
            ImageView imag = convertView.findViewById(R.id.list_image);
            tittle.setText(beerData.BeerName);
            Picasso.get().load(beerData.Image).into(imag);
        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position){
        return position;
    }
    @Override
    public int getViewTypeCount(){
        return arrayList.size();
    }
    @Override
    public boolean isEmpty(){
        return false;
    }

}
