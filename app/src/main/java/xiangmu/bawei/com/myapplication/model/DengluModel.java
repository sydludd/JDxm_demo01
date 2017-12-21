package xiangmu.bawei.com.myapplication.model;


import com.example.weicy.weicy_gw.bean.DengluBean;
import com.example.weicy.weicy_gw.chushihua.DengluModelCallBack;
import com.example.weicy.weicy_gw.retrofit.IGetDataService;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Menglucywhh on 2017/12/7.
 */

public class DengluModel {


    public void getData(String denglu_zh, String denglu_pwd, final DengluModelCallBack dengluModelCallBack) {
//https://www.zhaoapi.cn/user/reg?mobile=15810680959&password=123456
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetDataService service = retrofit.create(IGetDataService.class);

        Map<String,String> map = new HashMap<>();
        map.put("mobile",denglu_zh);
        map.put("password",denglu_pwd);
        service.denglu(map).enqueue(new Callback<DengluBean>() {

            @Override
            public void onResponse(Call<DengluBean> call, Response<DengluBean> response) {
                DengluBean dengluBean = response.body();
                dengluModelCallBack.success(dengluBean);
            }

            @Override
            public void onFailure(Call<DengluBean> call, Throwable t) {
                dengluModelCallBack.failure();
            }
        });
    }
}
