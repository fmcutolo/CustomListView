package com.example.frank.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;

    //    String listFruit[];
    ArrayList<StockProperty> propertyList;

    int listImages[];
    LayoutInflater inflater;


//    public CustomBaseAdapter(Context ctx, String[] fruitlist, int [] images) {
    public CustomBaseAdapter(Context ctx, ArrayList<StockProperty> propertyList, int [] images) {
        this.context = ctx;
//        this.listFruit = fruitlist;
        this.propertyList= propertyList;
        this.listImages = images;
        inflater=LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
//        return listFruit.length;
        return propertyList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textView);
        ImageView fruitImg = (ImageView) convertView.findViewById(R.id.imageIcon);

        //        txtView.setText(listFruit[position]);
        StockProperty property = new StockProperty("","");
        property = propertyList.get(position);
        String xx = property.title;
        txtView.setText(xx);

        fruitImg.setImageResource(listImages[position]);
        return convertView;
    }
}
