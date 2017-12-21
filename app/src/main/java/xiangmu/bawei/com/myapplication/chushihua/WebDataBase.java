package xiangmu.bawei.com.myapplication.chushihua;

import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.TJ;
import com.example.weicy.weicy_gw.bean.WebBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by weicy on 2017/12/6.
 */

public interface WebDataBase {
    //https://www.zhaoapi.cn/product/addCart?uid=71&pid=57&source=android//添加购物车
    @GET("/product/addCart")
    Call<TJ> get(@Query("uid") int uid, @Query("pid") int pid, @Query("source") String source);
}
