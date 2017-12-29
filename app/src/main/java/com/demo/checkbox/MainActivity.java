package com.demo.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    private void initData() {
        ArrayList<String> lists = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            lists.add("text" + i);
        }
        lv.setAdapter(new MyAdapter(this,lists));

    }
}
