package com.bwie.shuaxin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bwie.shuaxin.bean.One;
import com.bwie.shuaxin.bean.Three;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView listView;
    private MyAdapter adapter;
    private List<JsonBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        listView = findViewById(R.id.listview);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        //解析数据
        HttpUtils.getAsyncTask("https://www.apiopen.top/satinApi?type=1&page=1", new HttpUtils.CallBackA() {



            @Override
            public void getData(String s) {
                Gson gson=new Gson() ;
                JsonBean bean = gson.fromJson(s, JsonBean.class);
                list = bean.getData();

                adapter = new MyAdapter(MainActivity.this, list);
                listView.setAdapter(adapter);
            }
        });
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                //解析数据
                HttpUtils.getAsyncTask("https://www.apiopen.top/satinApi?type=1&page=1", new HttpUtils.CallBackA() {



                    @Override
                    public void getData(String s) {
                        Gson gson=new Gson() ;
                        JsonBean bean = gson.fromJson(s, JsonBean.class);
                        list = bean.getData();

                        adapter = new MyAdapter(MainActivity.this, list);
                        listView.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        listView.onRefreshComplete();
                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                //解析数据
                HttpUtils.getAsyncTask("https://www.apiopen.top/satinApi?type=1&page=1", new HttpUtils.CallBackA() {



                    @Override
                    public void getData(String s) {
                        Gson gson=new Gson() ;
                        JsonBean bean = gson.fromJson(s, JsonBean.class);
                        List<JsonBean.DataBean> list1 = bean.getData();
                        list.addAll(list1);
                        adapter.notifyDataSetChanged();
                        listView.onRefreshComplete();

                    }
                });
            }
        });
    }
}
