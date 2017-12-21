package xiangmu.bawei.com.myapplication.presenter;


import com.example.weicy.weicy_gw.bean.DengluBean;
import com.example.weicy.weicy_gw.chushihua.DengluModelCallBack;
import com.example.weicy.weicy_gw.chushihua.DengluViewCallBack;
import com.example.weicy.weicy_gw.model.DengluModel;

/**
 * Created by Menglucywhh on 2017/12/7.
 */

public class DengluPresenter {
    DengluModel dengluModel = new DengluModel();
    DengluViewCallBack dengluViewCallBack;
    public DengluPresenter(DengluViewCallBack dengluViewCallBack) {
        this.dengluViewCallBack = dengluViewCallBack;
    }

    public void getData(String denglu_zh, String denglu_pwd) {
        dengluModel.getData(denglu_zh,denglu_pwd, new DengluModelCallBack() {
            @Override
            public void success(DengluBean dengluBean) {
                dengluViewCallBack.success(dengluBean);
            }

            @Override
            public void failure() {
                dengluViewCallBack.failure();
            }
        });
    }
}
