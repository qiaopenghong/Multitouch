package com.example.qiao.multitouch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private MyGridView gridView;
    private MyListView listView;
    private List<Person> glist;
    private MyGridAdapter gadapter;
    private List<Lperson> llist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        initData();
        gridView = (MyGridView) findViewById(R.id.grid);
        listView = (MyListView) findViewById(R.id.lv);
        gadapter = new MyGridAdapter(GridActivity.this, glist);
        gridView.setAdapter(gadapter);
        MyListAdapter ladapter = new MyListAdapter(GridActivity.this, llist);
        listView.setAdapter(ladapter);
        ScrollView sl = (ScrollView) findViewById(R.id.sl);
        sl.scrollTo(0, 0);
        sl.smoothScrollTo(0, 0);

    }

    private void initData() {
        glist = new ArrayList<Person>();
        Person p = new Person(R.drawable.gv1, "呵呵");
        Person p1 = new Person(R.drawable.gv2, "呵呵");
        Person p2 = new Person(R.drawable.gv3, "呵呵");
        Person p3 = new Person(R.drawable.gv4, "呵呵");
        Person p4 = new Person(R.drawable.gv5, "呵呵");
        Person p5 = new Person(R.drawable.gv6, "呵呵");
        Person p6 = new Person(R.drawable.gv8, "呵呵");
        Person p7 = new Person(R.drawable.gv9, "呵呵");
        Person p8 = new Person(R.drawable.gv10, "呵呵");
        Person p9 = new Person(R.drawable.gv11, "呵呵");
        Person p10 = new Person(R.drawable.gv12, "呵呵");
        Person p11 = new Person(R.drawable.gv13, "呵呵");
        Person p12 = new Person(R.drawable.gv14, "呵呵");
        glist.add(p);
        glist.add(p1);
        glist.add(p2);
        glist.add(p3);
        glist.add(p4);
        glist.add(p5);
        glist.add(p6);
        glist.add(p7);
        glist.add(p8);
        glist.add(p9);
        glist.add(p10);
        glist.add(p11);

        llist = new ArrayList<Lperson>();
        for (int i = 0; i < 20; i++) {
            Lperson lp = new Lperson(R.drawable.gv4, "呵呵");
            llist.add(lp);
        }


    }

}
