package xiangmu.bawei.com.myapplication.chushihua;

import com.example.weicy.weicy_gw.bean.WebBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by weicy on 2017/12/6.
 */

public interface TianJiaGouWuChe {
    //https://www.zhaoapi.cn/product/getProductDetail?pid=100&source=android

    @GET("/product/getProductDetail")
    Call<WebBean> get(@Query("pid") int pid, @Query("source") String source);
}
