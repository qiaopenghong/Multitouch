package com.example.qiao.multitouch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by qiao on 2016/11/3.
 */
public class MyGridAdapter extends BaseAdapter{
    private Context context;
    private List<Person> glist;
    public MyGridAdapter(Context context,List<Person> glist) {
        this.context=context;
        this.glist=glist;
    }
    @Override
    public int getCount() {
        return glist.size();
    }

    @Override
    public Object getItem(int i) {
        return glist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=View.inflate(context,R.layout.grid_listview,null);
            ImageView grid_image = (ImageView) view.findViewById(R.id.grid_image);
            TextView  grid_name = (TextView) view.findViewById(R.id.grid_name);
            grid_image.setImageResource(glist.get(i).getIcon());
            grid_name.setText(glist.get(i).getName());
        }
        return view;
    }
}
