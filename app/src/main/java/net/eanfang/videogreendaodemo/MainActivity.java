package net.eanfang.videogreendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.eanfang.videogreendaodemo.dao.DBUtils;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rev_list)
    RecyclerView revList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getByNet();
    }

    private void initView() {
        if (DBUtils.queryAll(Model.class).size() > 0) {
            setData(DBUtils.loadAll(Model.class));
        } else {
            getByNet();
        }
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
                    final List<Model> list = ParseVideoBean.parseData(json);
                    DBUtils.insertOrReplaceList(Model.class, list);
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

    private void setData(List<Model> list) {
        MyAdapter adapter = new MyAdapter(R.layout.recyclerview_item, list);
        revList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        revList.setAdapter(adapter);
    }
}
