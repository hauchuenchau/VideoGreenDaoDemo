package net.eanfang.videogreendaodemo.model;

import java.io.Serializable;

/**
 * Created by MrHou
 *
 * @on 2018/3/29  15:49
 * @email houzhongzhou@yeah.net
 * @desc
 */

public class VideoBean implements Serializable {
    private String pic_url;
    private String content;
    private String low_url;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLow_url() {
        return low_url;
    }

    public void setLow_url(String low_url) {
        this.low_url = low_url;
    }
}
