package net.eanfang.videogreendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.eanfang.videogreendaodemo.adapter.LocalAdapter;
import net.eanfang.videogreendaodemo.localcache.CacheGetCallBack;
import net.eanfang.videogreendaodemo.localcache.CacheUtil;
import net.eanfang.videogreendaodemo.model.ParseVideoBean;
import net.eanfang.videogreendaodemo.model.VideoBean;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by MrHou
 *
 * @on 2018/3/29  15:52
 * @email houzhongzhou@yeah.net
 * @desc
 */

public class LocalCacheActivity extends AppCompatActivity {
    @BindView(R.id.rev_list)
    RecyclerView revList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        CacheUtil.get(LocalCacheActivity.this, getPackageName(), "test", new CacheGetCallBack() {
            @Override
            public void readValue(String result) {

                if (result != null) {
//
                    Log.e("cahce",result);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            final List<VideoBean> list = ParseVideoBean.parseData(result);
                            setData(list);
                        }
                    });

                } else {
                    getByNet();
                }
            }
        });


    }

    private void getByNet() {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder()
                    .url(Url.APP_URL)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String json = response.body().string();
                    final List<VideoBean> list = ParseVideoBean.parseData(json);
                    CacheUtil.put(LocalCacheActivity.this, getPackageName(), "test", json);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setData(list);
                        }
                    });


                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setData(List<VideoBean> list) {
        LocalAdapter adapter = new LocalAdapter(R.layout.recyclerview_item, list);
        revList.setLayoutManager(new LinearLayoutManager(this));
        revList.setAdapter(adapter);
    }
}
