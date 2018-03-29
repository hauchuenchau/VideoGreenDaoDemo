package net.eanfang.videogreendaodemo.model;

import com.google.gson.Gson;

import java.util.List;

/**
 * Created by MrHou
 *
 * @on 2017/11/15  16:30
 * @email houzhongzhou@yeah.net
 * @desc
 */

public class ParseVideoBean {
    private List<VideoBean> items;

    public List<VideoBean> getItems() {
        return items;
    }

    public void setItems(List<VideoBean> items) {
        this.items = items;
    }

    public static List<VideoBean> parseData(String json) {
        return new Gson().fromJson(json, ParseVideoBean.class).getItems();
    }
}
