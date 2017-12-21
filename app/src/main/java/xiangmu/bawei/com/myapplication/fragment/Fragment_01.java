package xiangmu.bawei.com.myapplication.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.activity.SearchActivity;
import com.example.weicy.weicy_gw.activity.SouSuo;
import com.example.weicy.weicy_gw.activity.XinxiaActivity;
import com.example.weicy.weicy_gw.adapter.ShouYeadapter;
import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.Beanlbt;
import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.example.weicy.weicy_gw.chushihua.IGetDataBase;
import com.example.weicy.weicy_gw.chushihua.IGetDataBased;
import com.example.weicy.weicy_gw.chushihua.ViewCallBack1;
import com.example.weicy.weicy_gw.presenter.MyPresenter1;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weicy on 2017/12/6.
 */

@SuppressLint("ValidFragment")
public class Fragment_01 extends Fragment  {
    private Banner banner;
    XRecyclerView xRecyclerView;
    private ShouYeadapter shouYeadapter;
    private List<Beanlbt.DataBean> subjects;
    private List<Bean.DataBean.SubjectsBean> data=new ArrayList<>();
    private ArrayList<Fragment> fragments;
    private ViewPager vp;
    private MyPresenter1 myPresenter1;

    FragmentManager supportFragmentManager;

    public Fragment_01(FragmentManager supportFragmentManager) {
        this.supportFragmentManager=supportFragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, null);
        LinearLayout editText  =view.findViewById(R.id.editText);
        ImageView rwm_01 = view.findViewById(R.id.rwm_01);
        ImageView xx = view.findViewById(R.id.xx);
        xRecyclerView = view.findViewById(R.id.xRecyclerView);

        /*myPresenter1 = new MyPresenter1(this);*/

        //跳转搜索页面
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        //跳转信息页面
        xx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XinxiaActivity.class);
                startActivity(intent);
            }
        });
        //跳转二维码页面
        rwm_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                getActivity().startActivity(intent);
            }
        });


        //1获取网络数据
        Retrofit retrofit =  new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IGetDataBase iGetDataBase = retrofit.create(IGetDataBase.class);
        Call<Beanlbt> call = iGetDataBase.get();
        call.enqueue(new Callback<Beanlbt>() {
            //请求成功
            @Override
            public void onResponse(Call<Beanlbt> call, Response<Beanlbt> response) {
                Beanlbt bean = response.body();
                subjects = bean.getData();

                //网络请求
                Retrofit retrofit1 =  new Retrofit.Builder().baseUrl("http://result.eolinker.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                IGetDataBased iGetDataBased = retrofit1.create(IGetDataBased.class);
                Call<Bean> beanlbtCall = iGetDataBased.get();
                beanlbtCall.enqueue(new Callback<Bean>() {
                    @Override
                    public void onResponse(Call<Bean> call, final Response<Bean> response) {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (subjects!=null){

                                    Bean body = response.body();
                                    data = body.getData().getSubjects();

                                    xRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                                    shouYeadapter = new ShouYeadapter(data,subjects, getActivity(),supportFragmentManager);
                                    xRecyclerView.setAdapter(shouYeadapter);
                                    xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
                                        @Override
                                        public void onRefresh() {
                                            xRecyclerView.refreshComplete();
                                        }

                                        @Override
                                        public void onLoadMore() {

                                        }
                                    });
                                }
                            }
                        });
                    }
                    @Override
                    public void onFailure(Call<Bean> call, Throwable t) {

                    }
                });
            }
            //请求失败
            @Override
            public void onFailure(Call<Beanlbt> call, Throwable t) {

            }
        });


        return view;
    }

}
