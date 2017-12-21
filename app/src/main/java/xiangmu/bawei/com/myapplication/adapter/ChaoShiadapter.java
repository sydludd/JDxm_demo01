package xiangmu.bawei.com.myapplication.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.CaiPuBean;


import java.util.List;

/**
 * Created by weicy on 2017/12/8.
 */

public class ChaoShiadapter extends RecyclerView.Adapter<ChaoShiadapter.ViewHolder1> {

    Context context;
    List<CaiPuBean.ResultBean.DataBean> list;
    public ChaoShiadapter(Context context, List<CaiPuBean.ResultBean.DataBean> list) {
        this.context=context;
        this.list=list;
    }


    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);

        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder1 holder, int position) {
        String url = list.get(position).getAlbums().get(0);
        Glide.with(context).load(url).into(holder.imageView);
        holder.te.setText(list.get(position).getTitle());
        holder.te1.setText(list.get(position).getTags());
    }

    @Override
    public int getItemCount() {
        return list==null ? 0:list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder{
        TextView te, te1;
        private final ImageView imageView;


        public ViewHolder1(View itemView) {
            super(itemView);
            te = itemView.findViewById(R.id.item_te);
            te1 = itemView.findViewById(R.id.item_te1);
            imageView = itemView.findViewById(R.id.item_img);
        }
    }
}
