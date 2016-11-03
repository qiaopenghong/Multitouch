package com.example.qiao.multitouch;

/**
 * Created by qiao on 2016/11/3.
 */
public class Person {
    private int icon;
    private String name;
    public Person(int icon, String name) {
        super();
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
