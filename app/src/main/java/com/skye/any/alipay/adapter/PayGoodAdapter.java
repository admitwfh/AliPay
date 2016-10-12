package com.skye.any.alipay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skye.any.alipay.R;
import com.skye.any.alipay.bean.Good;


import java.util.List;

/**
 * Created by Administrator on 2016/10/12.
 */
public class PayGoodAdapter extends BaseAdapter {
    Context context;
    List<Good> goodList;

    public PayGoodAdapter(Context context, List<Good> goodList) {
        this.context = context;
        this.goodList = goodList;
    }

    @Override
    public int getCount() {
        return goodList.size();
    }

    @Override
    public Object getItem(int position) {
        return goodList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final PayViewHolder payViewHolder;
        if(convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.pay_lv_item,null);
            payViewHolder = new PayViewHolder(convertView);
        }else{
            payViewHolder = (PayViewHolder) convertView.getTag();
        }

        payViewHolder.pay_good_name.setText(goodList.get(position).getName());
        payViewHolder.btn_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = payViewHolder.pay_good_number.getText().toString();
                int number = Integer.parseInt(num);
                if(number>1){
                    int count= number-1;
                    payViewHolder.pay_good_number.setText(String.valueOf(count));
                }else{
                    payViewHolder.pay_good_number.setText(String.valueOf(1));
                }
            }
        });
        payViewHolder.btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = payViewHolder.pay_good_number.getText().toString();
                int number = Integer.parseInt(num);
                int count = number+1;
                if(count>goodList.get(position).getNumber()){
                    Toast.makeText(context,"库存不足",Toast.LENGTH_LONG).show();
                }else{
                    payViewHolder.pay_good_number.setText(String.valueOf(count));
                }
            }
        });

        return convertView;
    }
    class PayViewHolder{
        View view;
        TextView pay_good_name;
        Button btn_subtract;
        Button pay_good_number;
        Button btn_plus;
        public PayViewHolder(View view) {
            this.view = view;
            pay_good_name = (TextView) view.findViewById(R.id.pay_good_name);
            btn_subtract = (Button) view.findViewById(R.id.btn_subtract);
            pay_good_number = (Button) view.findViewById(R.id.pay_good_number);
            btn_plus = (Button) view.findViewById(R.id.btn_plus);
            view.setTag(this);
        }
    }
}
