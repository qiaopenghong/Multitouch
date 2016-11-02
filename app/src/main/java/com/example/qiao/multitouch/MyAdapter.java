package com.example.qiao.multitouch;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by qiao on 2016/11/2.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private String[] data;
    private static HashMap<Integer, Boolean> isSelected;
    public MyAdapter(Context context, String[] data) {
        this.context=context;
        this.data=data;
        isSelected = new HashMap<Integer, Boolean>();
        initData();
    }
    private void initData() {
        // TODO Auto-generated method stub
        for (int i = 0; i < data.length; i++) {
            getIsSelected().put(i, false);
        }

    }
    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewholder;
        if(view==null){
            viewholder=new ViewHolder();
            view=View.inflate(context,R.layout.list_item,null);
            viewholder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            viewholder.cb = (CheckBox) view.findViewById(R.id.cb_all);
            view.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) view.getTag();
        }
        viewholder.tv_name.setText(data[i]);
        viewholder.cb.setChecked(getIsSelected().get(i));

        return view;
    }
    static class ViewHolder{
        TextView tv_name;
        public CheckBox cb;
    }
    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer,Boolean> isSelected) {
        MyAdapter.isSelected = isSelected;
    }
}
