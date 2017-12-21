package xiangmu.bawei.com.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.activity.CustomXiangQiangActivity;
import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Menglucywhh on 2017/11/27.
 */
public class RecyTuijianAdapter extends RecyclerView.Adapter<RecyTuijianAdapter.TuijianViewHolder>{

    Context context;
    public RecyTuijianAdapter(Context context) {
        this.context = context;
    }
    @Override
    public TuijianViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shouye_recy_tuijian_item,null);
        TuijianViewHolder tuijianViewHolder = new TuijianViewHolder(view);
        return tuijianViewHolder;
    }

    @Override
    public void onBindViewHolder(TuijianViewHolder holder, final int position) {
        if(listDa.size()>0) {
            if(listDa.get(position).getImages().contains("|")) {
                String[] split = listDa.get(position).getImages().split("\\|");
                holder.tuijian_image.setImageURI(split[0]);
                holder.tuijian_text.setText(listDa.get(position).getTitle());

             }
            holder.tuijian_image.setImageURI(listDa.get(position).getImages());
            holder.tuijian_text.setText(listDa.get(position).getTitle());

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Intent intent = new Intent(context, XiangQingActivity.class);
                intent.putExtra("detailUrl",listDa.get(0).getList().get(position).getDetailUrl());
                context.startActivity(intent);
*/
                 Intent intent = new Intent(context, CustomXiangQiangActivity.class);
                intent.putExtra("pid",listDa.get(position).getPid()+"");
                intent.putExtra("images",listDa.get(position).getImages());
                intent.putExtra("bargainPrice",listDa.get(position).getBargainPrice()+"");
                intent.putExtra("title",listDa.get(position).getTitle());
                intent.putExtra("price",listDa.get(position).getPrice()+"");

                 context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listDa==null?0:listDa.size();
    }

    List<ShouyeLunBoBean.TuijianBean.ListBean> listDa;
    public void addData(List<ShouyeLunBoBean.TuijianBean.ListBean> listDa) {
        this.listDa=listDa;
    }


    public static class TuijianViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView tuijian_image;
        private final TextView tuijian_text;

        public TuijianViewHolder(View itemView) {
            super(itemView);
            tuijian_image = (SimpleDraweeView) itemView.findViewById(R.id.tuijian_image);
            tuijian_text = (TextView) itemView.findViewById(R.id.tuijian_text);
        }
    }
}
