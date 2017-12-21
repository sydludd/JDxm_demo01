package xiangmu.bawei.com.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.example.weicy.weicy_gw.bean.TJ;
import com.example.weicy.weicy_gw.bean.WebBean;
import com.example.weicy.weicy_gw.chushihua.ViewCallBack1;
import com.example.weicy.weicy_gw.chushihua.WebDataBase;
import com.example.weicy.weicy_gw.presenter.MyPresenter1;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class XiangQing extends AppCompatActivity implements ViewCallBack1 {

    private MyPresenter1 presenter1;
    private int i;
    private RecyclerView recyclerView;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                ShouyeLunBoBean bean = (ShouyeLunBoBean) msg.obj;
                String[] images = bean.getTuijian().getList().get(i).getImages().split("\\|");
                Glide.with(XiangQing.this).load(images[0]).into(imageView);
                shouyeXqTextName.setText(bean.getTuijian().getList().get(i).getTitle());
                shouyeXqAddcart.setText(bean.getTuijian().getList().get(i).getSubhead());
                shouyeXqTextPrice.setText("¥：" + bean.getTuijian().getList().get(i).getPrice() + "");
            }
        }
    };

    private TextView shouyeXqTextName;
    private TextView shouyeXqAddcart;
    private TextView shouyeXqTextPrice;
    private ImageView imageView;
    private int pid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);

        imageView = findViewById(R.id.Shouye_xiangqing_simpleDeawee);
        shouyeXqTextName = findViewById(R.id.shouye_xq_text_name);
        shouyeXqAddcart = findViewById(R.id.shouye_xq_text_title);
        shouyeXqTextPrice = findViewById(R.id.shouye_xq_text_price);
        TextView shouye_xq_addcart = findViewById(R.id.shouye_xq_addcart);
        shouye_xq_addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                WebDataBase webDataBase = retrofit.create(WebDataBase.class);
                Toast.makeText(XiangQing.this, "" + pid, Toast.LENGTH_SHORT).show();
                Call<TJ> call = webDataBase.get(81,pid, "android");
                call.enqueue(new Callback<TJ>() {
                    @Override
                    public void onResponse(Call<TJ> call, Response<TJ> response) {
                        TJ body = response.body();
                        String msg = body.getMsg();
                        Toast.makeText(XiangQing.this, "" + msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<TJ> call, Throwable t) {

                    }
                });


            }
        });

        MyPresenter1 myPresenter1 = new MyPresenter1(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.i("123123123123_02'", "onCreate: " + url);
        i = Integer.parseInt(url);
        Log.i("123123123123_01'", "onCreate: " + i);

        ButterKnife.bind(this);

    }

    @Override
    public void success(ShouyeLunBoBean shouyeLunBoBean) {
        pid = shouyeLunBoBean.getTuijian().getList().get(i).getPid();
        //https://www.zhaoapi.cn/product/addCart?uid=71&pid=57&source=android//添加购物车


        Message message = new Message();
        message.what = 0;
        message.obj = shouyeLunBoBean;
        handler.sendMessage(message);
    }

    @Override
    public void failure() {

    }
}
