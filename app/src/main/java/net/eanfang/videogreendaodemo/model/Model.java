package net.eanfang.videogreendaodemo.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by MrHou
 *
 * @on 2017/11/15  13:42
 * @email houzhongzhou@yeah.net
 * @desc 实体类
 */
@Entity
public class Model {
    @Id(autoincrement = true)
    private Long id;

    private String pic_url;
    private String content;
    private String low_url;

    @Generated(hash = 2118404446)
    public Model() {
    }


    @Generated(hash = 1127618522)
    public Model(Long id, String pic_url, String content, String low_url) {
        this.id = id;
        this.pic_url = pic_url;
        this.content = content;
        this.low_url = low_url;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", pic_url='" + pic_url + '\'' +
                ", content='" + content + '\'' +
                ", low_url='" + low_url + '\'' +
                '}';
    }
}
