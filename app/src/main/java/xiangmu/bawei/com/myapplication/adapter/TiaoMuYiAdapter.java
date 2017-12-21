package xiangmu.bawei.com.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.FenLeBeand;

import java.util.List;

/**
 * Created by weicy on 2017/12/9.
 */

public class TiaoMuYiAdapter extends BaseAdapter {
    Context context;
    List<FenLeBeand.DataBean> list;

    public TiaoMuYiAdapter(Context context, List<FenLeBeand.DataBean> list) {
        this.list=list;
        this.context=context;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, null);
        TextView tv = (TextView) convertView.findViewById(R.id.tv);

        tv.setText(list.get(position).getName());

        return convertView;
    }
}
