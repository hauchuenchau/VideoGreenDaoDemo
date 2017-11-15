package net.eanfang.videogreendaodemo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by MrHou
 *
 * @on 2017/11/15  16:15
 * @email houzhongzhou@yeah.net
 * @desc
 */

public class MyAdapter extends BaseQuickAdapter<Model,BaseViewHolder>{
    public MyAdapter(int layoutResId, List<Model> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Model item) {
        helper.setText(R.id.tv_content,item.getContent());
        ((SimpleDraweeView) helper.getView(R.id.iv_header)).setImageURI(item.getPic_url());

    }
}
