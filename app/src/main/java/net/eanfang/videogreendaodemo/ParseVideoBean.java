package net.eanfang.videogreendaodemo;

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
    private List<Model> items;

    public List<Model> getItems() {
        return items;
    }

    public void setItems(List<Model> items) {
        this.items = items;
    }

    public static List<Model> parseData(String json) {
        return new Gson().fromJson(json, ParseVideoBean.class).getItems();
    }
}
