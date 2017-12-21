package xiangmu.bawei.com.myapplication.chushihua;


import com.example.weicy.weicy_gw.bean.FenLeBeand;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by weicy on 2017/12/6.
 */

public interface FenLeiDataBased {
    @GET("/product/getCatagory")
    Call<FenLeBeand> get();
}
