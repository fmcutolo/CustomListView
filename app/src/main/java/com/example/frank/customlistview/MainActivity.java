package com.example.frank.customlistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String fruitList[] = {"Apple","Banana","Apricot","Orange","Water boy"};
    int fruitImages[] = {R.drawable.bookmark,
                        R.drawable.ok,
                        R.drawable.baseline_done_black_24dp,
                        R.drawable.close,
                        R.drawable.ribbon,
                        R.drawable.search};

    static boolean mFirstTime = true;
    CustomBaseAdapter mCustomBaseAdapter;
    public static final int MAX_SYMBOLS = 2;
    static List<StockProperty>[] stockPropertyList = new List[MAX_SYMBOLS];

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         //getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        final Button button_add = (Button) findViewById(R.id.buttonAdd);
        button_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                if (stockPropertyList[0].size()  < 6)
                {

                    stockPropertyList[0].add(new StockProperty("Revenue","1,042"));
                    mCustomBaseAdapter.notifyDataSetChanged();
                }
            }
        });

        final Button button_remove = (Button) findViewById(R.id.buttonRemove);
        button_remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (stockPropertyList[0].size()>0)
                {
                    int index = stockPropertyList[0].size();
                    stockPropertyList[0].remove(index-1);
                    mCustomBaseAdapter.notifyDataSetChanged();
                }

                // your handler code here
            }
        });

        if (mFirstTime)
        {
            mFirstTime = false;
            for (int i = 0; i < MAX_SYMBOLS; i++) {
                stockPropertyList[i] = new ArrayList<>();
            }
            stockPropertyList[0].add(new StockProperty("rv","alot"));
            stockPropertyList[0].add(new StockProperty("xxrv","asdfalot"));
            stockPropertyList[0].add(new StockProperty("Revenue","1,042"));
        }

        listView = (ListView) findViewById(R.id.customListView);
        mCustomBaseAdapter = new CustomBaseAdapter(getApplicationContext(),(ArrayList<StockProperty>)stockPropertyList[0],fruitImages);
        listView.setAdapter(mCustomBaseAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("CUSTOM_LIST_VIEW","Item is clicked @ Position :: " + position);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.stock_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.create_a_profile:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}