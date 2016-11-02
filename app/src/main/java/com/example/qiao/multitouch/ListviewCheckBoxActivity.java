package com.example.qiao.multitouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class ListviewCheckBoxActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_selectAll;
    private Button bt_cancel;
    private Button bt_noseselectAll;
    private String[] data={"dsf","s","sdf","fds","fds","sf","fs","sdf","fsdg"};
    private Customlistview lv;
    private MyAdapter adapter;
    private int checkNum; // 记录选中的条目数量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_check_box);
        initView();
    }
    public void initView() {
        bt_selectAll = (Button) findViewById(R.id.bt_selectAll);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);
        bt_noseselectAll = (Button) findViewById(R.id.bt_noseselectAll);
        bt_selectAll.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
        bt_noseselectAll.setOnClickListener(this);
        lv = (Customlistview) findViewById(R.id.lv);
        adapter = new MyAdapter(getApplicationContext(),data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // 取得ViewHolder对象，这样就省去了通过层层的findViewById去实例化我们需要的cb实例的步骤

                MyAdapter.ViewHolder viewholder = (MyAdapter.ViewHolder) view.getTag();
                // 改变CheckBox的状态
                viewholder.cb.toggle();
                // 将CheckBox的选中状况记录下来
                MyAdapter.getIsSelected().put(i,
                        viewholder.cb.isChecked());
                // 调整选定条目
                if (viewholder.cb.isChecked() == true) {
                    checkNum++;
                } else {
                    checkNum--;
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_selectAll:
                for (int i = 0; i < data.length; i++) {
                    MyAdapter.getIsSelected().put(i, true);
                }
                // 数量设为list的长度
                checkNum =data.length;
                // 刷新listview和TextView的显示
                dataChanged();
            break;
            case R.id.bt_cancel:
                // 遍历list的长度，将已选的设为未选，未选的设为已选
                for (int i = 0; i <data.length; i++) {
                    if (MyAdapter.getIsSelected().get(i)) {
                        MyAdapter.getIsSelected().put(i, false);
                        checkNum--;
                    } else {
                        MyAdapter.getIsSelected().put(i, true);
                        checkNum++;
                    }
                }
                // 刷新listview和TextView的显示
                dataChanged();
                break;
            case R.id.bt_noseselectAll:
                for (int i = 0; i < data.length; i++) {
                    MyAdapter.getIsSelected().put(i,false);
                }
                // 数量设为list的长度
                checkNum =data.length;
                // 刷新listview和TextView的显示
                dataChanged();
                break;
        }
    }
    private void dataChanged() {
        // 通知listView刷新
        adapter.notifyDataSetChanged();
    };


}
