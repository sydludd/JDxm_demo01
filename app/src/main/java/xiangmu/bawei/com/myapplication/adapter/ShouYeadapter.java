package xiangmu.bawei.com.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.activity.XinxiaActivity;
import com.example.weicy.weicy_gw.activity.ZhuHuiChang;
import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.Beanlbt;
import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.example.weicy.weicy_gw.chushihua.BannerImageLoader;
import com.example.weicy.weicy_gw.fragment.Fragment_fl01;
import com.example.weicy.weicy_gw.fragment.Fragment_fl02;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by weicy on 2017/12/7.
 */

public class ShouYeadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Bean.DataBean.SubjectsBean> data;
    ArrayList<String> listimage = new ArrayList<>();
    Context context;
    private Myadapter myadapter;
    private ArrayList<Fragment> fragments;
    Fragment_fl01 m1;
    FragmentManager supportFragmentManager;
    Fragment_fl02 m2;
    private List<ImageView> images;


    public ShouYeadapter(List<Bean.DataBean.SubjectsBean> data, List<Beanlbt.DataBean> list, Context context, FragmentManager supportFragmentManager) {
        this.context=context;
        this.data=data;
        this.supportFragmentManager=supportFragmentManager;
        for (int i = 0; i < list.size(); i++) {
            listimage.add(list.get(i).getIcon());
        }
    }

    @Override
    public int getItemViewType(int position) {

        return position==0?0:1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_lunbo, null);

            return new ViewHolder1(view);

        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_huodong, null);
            return new ViewHolder2(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder1){

            ((ViewHolder1) holder).banner.setImageLoader(new BannerImageLoader());
            //设置图片集合
            ((ViewHolder1) holder).banner.setImages(listimage);
            //开始启动轮播
            ((ViewHolder1) holder).banner.start();
            ArrayList<Fragment> fragments = new ArrayList<>();
            fragments.add(new Fragment_fl01());
            fragments.add(new Fragment_fl02());

            //viewPager小圆点的实现
            images = new ArrayList<>();
            ((ViewHolder1) holder).linearLayout.removeAllViews();//清空/移除所有的view

            for (int i = 0;i<2;i++){
                ImageView imageView = new ImageView(context);

                if (i==0){
                    imageView.setImageResource(R.drawable.ys_no);
                }else {
                    imageView.setImageResource(R.drawable.ys);
                }

                //添加到集合
                images.add(imageView);

                //加入到线性布局中显示
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                params.setMargins(5,0,5,0);

                ((ViewHolder1) holder).linearLayout.addView(imageView,params);
            }
            ((ViewHolder1) holder).viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for (int j = 0;j<images.size();j++){
                    if (j== position%images.size()){
                        images.get(j).setImageResource(R.drawable.ys_no);
                    }else {
                        images.get(j).setImageResource(R.drawable.ys);
                    }
                }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            AdapterFL adapterFL = new AdapterFL(supportFragmentManager,fragments);
            ((ViewHolder1) holder).viewPager.setAdapter(adapterFL);

            //12.12主会场
            ((ViewHolder1) holder).imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ZhuHuiChang.class);
                    context.startActivity(intent);
                }
            });



        }else if (holder instanceof ViewHolder2){
            String icon = data.get(position-1).getImage();
            Glide.with(context).load(icon).into(((ViewHolder2) holder).imageView);

            ((ViewHolder2) holder).recyclerView.setLayoutManager(new GridLayoutManager(context,2));
            myadapter = new Myadapter(context,data.get(position-1).getGoodsList());
            ((ViewHolder2) holder).recyclerView.setAdapter(myadapter);

            ((ViewHolder2) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context,Web.class);
                    intent.putExtra("url",""+(position+2));
                    context.startActivity(intent);




                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data==null ? 0 : data.size()+1;
    }

    List<ShouyeLunBoBean.TuijianBean.ListBean> list_01;
    public void addTuijian(List<ShouyeLunBoBean.TuijianBean.ListBean> list) {
        this.list_01=list_01;
    }


    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final Banner banner;
        private final ViewPager viewPager;
        private final LinearLayout linearLayout;
        private final ImageView imageView1;

        public ViewHolder1(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            imageView1 = itemView.findViewById(R.id.image_02);
            viewPager = itemView.findViewById(R.id.viewpager);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            ViewFlipper vf =  itemView.findViewById(R.id.view_filpper);
            vf.addView(View.inflate(context, R.layout.item_paomadeng, null));
            vf.addView(View.inflate(context, R.layout.item_paomadeng01, null));
        }

    }


    public class ViewHolder2 extends RecyclerView.ViewHolder {


        private final RecyclerView recyclerView;
        private final ImageView imageView;

        public ViewHolder2(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_01);
            recyclerView = itemView.findViewById(R.id.item_rv);
        }


    }


}
