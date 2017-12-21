package xiangmu.bawei.com.myapplication.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.adapter.AdapterFL;
import com.example.weicy.weicy_gw.adapter.JinRuAdapter;
import com.example.weicy.weicy_gw.adapter.ShouYeadapter;
import com.example.weicy.weicy_gw.fragment.Fragment_fl01;
import com.example.weicy.weicy_gw.fragment.Fragment_fl02;
import com.example.weicy.weicy_gw.fragment.jinruFragment_01;
import com.example.weicy.weicy_gw.fragment.jinruFragment_02;
import com.example.weicy.weicy_gw.fragment.jinruFragment_03;
import com.example.weicy.weicy_gw.fragment.jinruFragment_04;

import java.util.ArrayList;

public class Activity01 extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<ImageView> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
        LinearLayout linearLayout = findViewById(R.id.linear_layout_01);
        viewPager = findViewById(R.id.viewpager_01);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new jinruFragment_01());
        fragments.add(new jinruFragment_02());
        fragments.add(new jinruFragment_03());
        fragments.add(new jinruFragment_04());

        //viewPager小圆点的实现
        images = new ArrayList<>();
        linearLayout.removeAllViews();//清空/移除所有的view

        for (int i = 0;i<4;i++){
            ImageView imageView = new ImageView(Activity01.this);

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

            linearLayout.addView(imageView,params);
        }
            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int j = 0; j< images.size(); j++){
                    if (j== position% images.size()){
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

        JinRuAdapter adapterFL = new JinRuAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapterFL);





    }
}
