package com.yaoyifei.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yaoyifei.demo.fragment.ListViewFragment;

import java.util.List;

public class MyListAdapter extends BaseAdapter {
    private List<MyListViewData> mData;
    private Context mListViewFragment;
    private int mResourceId;
    private ViewHolder viewHolder;

    public MyListAdapter(ListViewFragment context, int ResourceId, List<MyListViewData> data){
//        super(context, ResourceId, data);
        mListViewFragment = context.getContext();
        mResourceId = ResourceId;
        mData = data;
    }

    @Override
    public int getCount() {//得到数据的行数
        return mData.size();
    }

    @Override
    public MyListViewData getItem(int position) {//根据position得到某一行的记录
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {//根据position得到某一条记录的ID
        return 0;
    }

    //相比于其它几个方法这个方法是最重要的，它显式的定义了适配器将要以什么样的方式去显示我们所填充的数据,
    // 在自定义的适配器里面我们通常会给它写个布局文件。第一个参数position指定位置，
    // 即要获得哪一个数据项的View，第二个参数view可复用的视图项，第三个参数指定父元素视图组。
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        MyListViewData myListViewData = getItem(position);//获取当前项的MyListViewData实例
        View myView;
        if (view == null) {
            //LayoutInflater的inflate()方法接收3个参数：需要实例化布局资源的id、ViewGroup类型视图组对象、false
            //false表示只让父布局中声明的layout属性生效，但不会为这个view添加父布局
            myView = LayoutInflater.from(mListViewFragment).inflate(mResourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) myView.findViewById(R.id.lv_imageView);
            viewHolder.textView = (TextView) myView.findViewById(R.id.lv_textView);
            myView.setTag(viewHolder);//保存
        } else {
            myView = view;
            viewHolder = (ViewHolder) myView.getTag();//取出
        }
        //设置图片和文字
        viewHolder.textView.setText(myListViewData.getItemText());
        viewHolder.imageView.setImageResource(myListViewData.getItemImage());
        return myView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

}