package com.demo.checkbox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/29 0029.
 */

class MyAdapter extends BaseAdapter {
    private ArrayList<String> lists = new ArrayList<>();
    private Context context;

    public MyAdapter(Context context, ArrayList<String> lists) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = View.inflate(context,R.layout.listview_item,null);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb);
            holder.checkedTextView = (CheckedTextView) convertView.findViewById(R.id.ctv);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position%2 == 0){
            holder.checkedTextView.setVisibility(View.GONE);
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setText(lists.get(position));
        }else {
            holder.checkBox.setVisibility(View.GONE);
            holder.checkedTextView.setVisibility(View.VISIBLE);
            holder.checkedTextView.setText(lists.get(position));
        }

        //监听CheckBox选择状态发生改变
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //checkbox选中时
                }else {
                    //checkbox未选中时
                }
            }
        });

        //CheckedTextView必须设置点击事件，否则选择时不会有效果
        holder.checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换CheckedTextView的选择状态\
                CheckedTextView checkedTextView = (CheckedTextView) v;
                checkedTextView.toggle();
//                checkedTextView.setChecked(!holder.checkedTextView.isChecked());
            }

        });
        return convertView;
    }


    class ViewHolder{
        CheckBox checkBox;
        CheckedTextView checkedTextView;
    }
}
