package xiangmu.bawei.com.myapplication.chushihua;

import com.example.weicy.weicy_gw.bean.Beanlbt;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by weicy on 2017/12/6.
 */

public interface IGetDataBase {
    @GET("/ad/getAd")
    Call<Beanlbt> get();
}
