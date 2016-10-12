package com.skye.any.alipay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.skye.any.alipay.adapter.GoodListAdapter;
import com.skye.any.alipay.bean.ListGood;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView lv_good;
    Button btn_settle;
    List<ListGood> listGoods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_good = (ListView) findViewById(R.id.lv_good);
        btn_settle = (Button) findViewById(R.id.btn_settle);
        setData();
    }


    public void setData(){
        listGoods = new ArrayList<>();
        listGoods.add(new ListGood("书柜",1,10));
        listGoods.add(new ListGood("凳子",1,8));
        listGoods.add(new ListGood("钢笔",1,9));
        listGoods.add(new ListGood("水壶",1,10));
        listGoods.add(new ListGood("笔记本",1,7));
        listGoods.add(new ListGood("Java in Thinking",1,8));
        listGoods.add(new ListGood("算法导论",1,10));
        listGoods.add(new ListGood("Android开发艺术探索",1,9));
        listGoods.add(new ListGood("程序员面试金典",1,11));
        GoodListAdapter adapter = new GoodListAdapter(this,listGoods);
        lv_good.setAdapter(adapter);
    }

    public void toPay(View view){
        Intent intent = new Intent(this,PayActivity.class);
        startActivity(intent);
    }

}
