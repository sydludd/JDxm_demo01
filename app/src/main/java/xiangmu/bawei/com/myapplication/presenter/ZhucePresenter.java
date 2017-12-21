package xiangmu.bawei.com.myapplication.presenter;


import com.example.weicy.weicy_gw.bean.ZhuceBean;
import com.example.weicy.weicy_gw.chushihua.ZhuceModelCallBack;
import com.example.weicy.weicy_gw.chushihua.ZhuceViewCallBack;
import com.example.weicy.weicy_gw.model.ZhuceModel;

/**
 * Created by Menglucywhh on 2017/12/7.
 */

public class ZhucePresenter {
    ZhuceModel zhuceModel = new ZhuceModel();
    ZhuceViewCallBack zhuceViewCallBack;
    public ZhucePresenter(ZhuceViewCallBack zhuceViewCallBack) {
        this.zhuceViewCallBack = zhuceViewCallBack;
    }

    public void getData(String zhuce_zh, String zhuce_pwd) {
        zhuceModel.getData(zhuce_zh,zhuce_pwd, new ZhuceModelCallBack() {
            @Override
            public void success(ZhuceBean zhuceBean) {
           zhuceViewCallBack.success(zhuceBean);
            }

            @Override
            public void failure() {
            zhuceViewCallBack.failure();
            }
        });
    }
}
