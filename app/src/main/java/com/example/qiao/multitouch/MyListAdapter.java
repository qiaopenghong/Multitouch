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
public class MyListAdapter extends BaseAdapter{
    private Context context;
    private List<Lperson> llist;
    public MyListAdapter(Context context, List<Lperson> llist) {
        this.context=context;
        this.llist=llist;
    }

    @Override
    public int getCount() {
        return llist.size();
    }

    @Override
    public Object getItem(int i) {
        return llist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=View.inflate(context,R.layout.l_listview,null);
            ImageView list_image = (ImageView) view.findViewById(R.id.list_image);
            TextView list_name = (TextView) view.findViewById(R.id.list_name);
            list_image.setImageResource(llist.get(i).getL_icon());
            list_name.setText(llist.get(i).getL_name());
        }
        return view;
    }
}
