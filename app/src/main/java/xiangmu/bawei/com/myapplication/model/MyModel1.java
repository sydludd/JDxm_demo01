package xiangmu.bawei.com.myapplication.model;


import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.example.weicy.weicy_gw.chushihua.ModelCallBack1;
import com.example.weicy.weicy_gw.okhttp.AbstractUiCallBack;
import com.example.weicy.weicy_gw.okhttp.OkhttpUtils;

/**
 * Created by Menglucywhh on 2017/11/30.
 */

public class MyModel1 {
    //model层里面调用okhttp封装类 请求数据
   /* public void getLunBo(final ModelCallBack1 modelCallBack1) {
        String path = "http://120.27.23.105/ad/getAd";
        OkhttpUtils.getInstance().asy(null, path, new AbstractUiCallBack<ShouyeLunBoBean>() {

            @Override
            public void success(ShouyeLunBoBean shouyeLunBoBean) {
                modelCallBack1.success(shouyeLunBoBean);
            }

            @Override
            public void failure(Exception e) {
                modelCallBack1.failure();
            }
        });
    }*/

    public void getData(final ModelCallBack1 modelCallBack1) {
        String path = "http://120.27.23.105/ad/getAd";
        OkhttpUtils.getInstance().asy(null, path, new AbstractUiCallBack<ShouyeLunBoBean>() {

            @Override
            public void success(ShouyeLunBoBean shouyeLunBoBean) {
                modelCallBack1.success(shouyeLunBoBean);
            }

            @Override
            public void failure(Exception e) {
                modelCallBack1.failure();
            }
        });
    }
}
