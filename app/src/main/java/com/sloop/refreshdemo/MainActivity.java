package com.sloop.refreshdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sloop.pulltorefreshlibary.GodRefreshLayout;

public class MainActivity extends AppCompatActivity {

    private GodRefreshLayout godRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        godRefresh = (GodRefreshLayout) findViewById(R.id.god_refresh);
        initRefreshLayout();
    }

    private void initRefreshLayout() {
        //1、采用默认的方式
//        godRefresh.setRefreshManager();
        //2、要支持用户自定义
        godRefresh.setRefreshManager(new MeiTuanRefreshManager(this));
        godRefresh.setRefreshListener(new GodRefreshLayout.RefreshingListener() {
            @Override
            public void onRefreshing() {
                godRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        godRefresh.refreshOver();
                    }
                }, 2000);
            }
        });
    }
}
