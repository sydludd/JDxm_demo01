package xiangmu.bawei.com.myapplication.chushihua;

import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.Beanlbt;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by weicy on 2017/12/6.
 */

public interface IGetDataBased {
    @GET("/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Call<Bean> get();
}
