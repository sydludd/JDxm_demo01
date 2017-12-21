package xiangmu.bawei.com.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.Beanlbt;
import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weicy on 2017/12/7.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder1>{

    Context context;
    List<Bean.DataBean.SubjectsBean.GoodsListBeanX> list;

    public Myadapter(Context context, List<Bean.DataBean.SubjectsBean.GoodsListBeanX> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.adapter, null);

        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, final int position) {
        String icon = list.get(position).getGoodsImage();
        Glide.with(context).load(icon).into(holder.imageView);
        holder.textView.setText(list.get(position).getGoodsName());
        //Log.i("123123",list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"条目是：  "+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,XiangQing.class);
                intent.putExtra("url",""+(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list==null ?0: list.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView textView;
        private final ImageView imageView;


        public ViewHolder1(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_01);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
