package com.example.frank.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<StockProperty> propertyList;
    int listImages[];
    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx, ArrayList<StockProperty> propertyList, int [] images) {
        this.context = ctx;
        this.propertyList= propertyList;
        this.listImages = images;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
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
        CheckBox checkbox =
                (CheckBox) convertView.findViewById( R.id.checkBox);
        checkbox.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText( context,"ImageButton clicked",Toast.LENGTH_SHORT).show();
                        if (checkbox.isChecked()) {
                            Log.i("CUSTOM_LIST_VIEW","Checkbox:Item is selected @ Position :: " + position);
                        }
                        else {
                            Log.i("CUSTOM_LIST_VIEW","Checkbox:Item is not selected @ Position :: " + position);
                        }
                    }
                });

        TextView txtView = (TextView) convertView.findViewById(R.id.textView);
        ImageView fruitImg = (ImageView) convertView.findViewById(R.id.imageIcon);
        Log.i("CUSTOM_LIST_VIEW","in GetView!");

        StockProperty property = new StockProperty("","");
        property = propertyList.get(position);
        String xx = property.title;
        txtView.setText(xx);

        fruitImg.setImageResource(listImages[position]);
        return convertView;
    }
}
