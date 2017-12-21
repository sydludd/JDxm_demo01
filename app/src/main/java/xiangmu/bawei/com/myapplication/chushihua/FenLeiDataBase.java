package xiangmu.bawei.com.myapplication.chushihua;

import com.example.weicy.weicy_gw.bean.Beanlbt;
import com.example.weicy.weicy_gw.bean.FenLeiBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by weicy on 2017/12/6.
 */

public interface FenLeiDataBase {
    @GET("/product/getProductCatagory")
    Call<FenLeiBean> get(@Query("cid") int cid);
}
