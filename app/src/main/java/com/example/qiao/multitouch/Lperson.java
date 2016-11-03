package com.example.qiao.multitouch;

/**
 * Created by qiao on 2016/11/3.
 */
public class Lperson {
    private int l_icon;
    private String l_name;

    public int getL_icon() {
        return l_icon;
    }

    public void setL_icon(int l_icon) {
        this.l_icon = l_icon;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Lperson(int l_icon, String l_name) {
        this.l_icon = l_icon;
        this.l_name = l_name;
    }

}
