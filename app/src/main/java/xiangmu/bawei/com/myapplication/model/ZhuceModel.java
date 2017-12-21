package xiangmu.bawei.com.myapplication.model;



import com.example.weicy.weicy_gw.bean.ZhuceBean;
import com.example.weicy.weicy_gw.chushihua.ZhuceModelCallBack;
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

public class ZhuceModel {


    public void getData(String zhuce_zh, String zhuce_pwd, final ZhuceModelCallBack zhuceModelCallBack) {
//https://www.zhaoapi.cn/user/reg?mobile=15810680959&password=123456
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetDataService service = retrofit.create(IGetDataService.class);

        Map<String,String> map = new HashMap<>();
        map.put("mobile",zhuce_zh);
        map.put("password",zhuce_pwd);
        service.zhuce(map).enqueue(new Callback<ZhuceBean>() {

            @Override
            public void onResponse(Call<ZhuceBean> call, Response<ZhuceBean> response) {
                ZhuceBean zhuceBean = response.body();
                zhuceModelCallBack.success(zhuceBean);
            }

            @Override
            public void onFailure(Call<ZhuceBean> call, Throwable t) {
                zhuceModelCallBack.failure();
            }
        });
    }
}
