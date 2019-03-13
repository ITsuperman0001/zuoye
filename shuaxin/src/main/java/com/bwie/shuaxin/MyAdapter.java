package com.bwie.shuaxin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.shuaxin.bean.One;

import java.util.List;

/**
 * @Author：余振华
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/13 19:10
 * @Description：描述信息
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private  List<JsonBean.DataBean> list;

    public MyAdapter(Context context, List<JsonBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.list,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.image);
            holder.textView=convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getTheme_name());
        Glide.with(context).load(list.get(position).getCdn_img()).into(holder.imageView);
        return convertView;
    }
    class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
