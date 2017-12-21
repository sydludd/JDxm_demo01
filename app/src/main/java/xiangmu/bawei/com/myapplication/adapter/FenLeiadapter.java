package xiangmu.bawei.com.myapplication.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.activity.Jdadapter;
import com.example.weicy.weicy_gw.bean.FenLeiBean;

import java.util.List;

/**
 * Created by weicy on 2017/12/9.
 */

public class FenLeiadapter extends BaseAdapter{
    Context context;
    List<FenLeiBean.DataBean> list1;
    private String icon;

    public FenLeiadapter(Context context, List<FenLeiBean.DataBean> list1) {
        this.list1=list1;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list1.size();
    }

    @Override
    public Object getItem(int position) {
        return list1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_item_02, null);
        TextView textView =  convertView.findViewById(R.id.text_03);
        ImageView imageView = convertView.findViewById(R.id.image_03);


        icon = list1.get(position).getList().get(0).getIcon();
        Glide.with(context).load(icon).into(imageView);
        textView.setText(list1.get(position).getName());

        List<FenLeiBean.DataBean.ListBean> listBeans = list1.get(position).getList();
        Jdadapter jdadapter = new Jdadapter(context,listBeans);


        return convertView;
    }
}
