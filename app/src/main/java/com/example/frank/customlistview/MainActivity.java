package com.example.frank.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String fruitList[] = {"Apple","Banana","Apricot","Orange","Water boy"};
    int fruitImages[] = {R.drawable.bookmark,R.drawable.ok,R.drawable.baseline_done_black_24dp,R.drawable.close,R.drawable.ribbon,R.drawable.search};

    static boolean mFirstTime = true;
    public static final int MAX_SYMBOLS = 2;
    static List<StockProperty>[] stockPropertyList = new List[MAX_SYMBOLS];

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mFirstTime)
        {
            mFirstTime = false;
            for (int i = 0; i < MAX_SYMBOLS; i++) {
                stockPropertyList[i] = new ArrayList<>();
            }
        }
        stockPropertyList[0].add(new StockProperty("rv","alot"));
        stockPropertyList[0].add(new StockProperty("xxrv","asdfalot"));
        stockPropertyList[0].add(new StockProperty("Revenue","1,042"));

        listView = (ListView) findViewById(R.id.customListView);

//        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),fruitList,fruitImages);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),(ArrayList<StockProperty>)stockPropertyList[0],fruitImages);

        listView.setAdapter(customBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("CUSTOM_LIST_VIEW","Item is clicked @ Position :: " + position);
            }
        });
    }
}