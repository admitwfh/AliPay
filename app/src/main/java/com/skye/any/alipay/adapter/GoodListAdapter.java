package com.skye.any.alipay.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skye.any.alipay.R;
import com.skye.any.alipay.bean.Good;
import com.skye.any.alipay.bean.ListGood;
import com.skye.mygreendao.db.DaoMaster;
import com.skye.mygreendao.db.GoodDao;

import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2016/10/12.
 */
public class GoodListAdapter extends BaseAdapter {
    Context context;
    List<ListGood> list;

    public GoodListAdapter(Context context, List<ListGood> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.good_lv_item,null);
            viewHolder = new ViewHolder(convertView);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_name.setText(list.get(position).getgName());
        viewHolder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将数据插入数据库
                DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "Good.db");
                SQLiteDatabase database = helper.getWritableDatabase();
                DaoMaster daoMaster = new DaoMaster(database);
                GoodDao dao = daoMaster.newSession().getGoodDao();
                insertData(dao,list.get(position));
                Toast.makeText(context,"加入成功",Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }
    class ViewHolder{
        TextView tv_name;
        Button btn_add;
        View view;

        public ViewHolder(View view) {
            this.view = view;
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            btn_add = (Button) view.findViewById(R.id.btn_add);
            view.setTag(this);
        }
    }

    public void insertData(GoodDao dao,ListGood listGood){
        String name = listGood.getgName();
        int price = listGood.getgPrice();
        int number = listGood.getgNumber();
        Random random = new Random();
        int goodId = random.nextInt(100);
        dao.insert(new Good(name,price,number,goodId));
    }
}
