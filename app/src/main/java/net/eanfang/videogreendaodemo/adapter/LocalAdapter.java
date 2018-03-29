package net.eanfang.videogreendaodemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import net.eanfang.videogreendaodemo.R;
import net.eanfang.videogreendaodemo.model.VideoBean;

import java.util.List;

/**
 * Created by MrHou
 *
 * @on 2017/11/15  16:15
 * @email houzhongzhou@yeah.net
 * @desc
 */

public class LocalAdapter extends BaseQuickAdapter<VideoBean,BaseViewHolder>{
    public LocalAdapter(int layoutResId, List<VideoBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBean item) {
        helper.setText(R.id.tv_content,item.getContent());
        ((SimpleDraweeView) helper.getView(R.id.iv_header)).setImageURI(item.getPic_url());

    }
}
