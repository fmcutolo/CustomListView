package com.example.frank.customlistview;

public class StockProperty {
    String title;
    String value;

    StockProperty(String title, String value) {
        this.title = title;
        this.value = value;
    }


    class Mapping{
        public Mapping(String title, int position){
            this.title = title;
            this.position = position;
        }
        String title;
        int position;
    }

    Mapping show_map[] = { new Mapping("Price",1),
            new Mapping("Market Cap", 3),
            new Mapping("Avg. Volume",4),
            new Mapping("52 Week Range",2),
            new Mapping("Total Revenue",5)  // Used WebView
    } ;
//            new Mapping("Forward Dividend & Yield",5)  // moved for testing

    boolean show() {
        boolean status = false;
        int length = show_map.length;
        for (int i = 0; i < length; ++i) {
            if (title.contentEquals(show_map[i].title)){
                status = true;
                break;
            }
        }
        return status;
    }

    String getTitle(int row)
    {
        int i;
        for (i=0; i<show_map.length;++i)
        {
            if (show_map[i].position == row) {
                break;
            }
        }
        return show_map[i].title;
    }
}
