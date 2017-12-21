package xiangmu.bawei.com.myapplication.presenter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.adapter.Myadapter;
import com.example.weicy.weicy_gw.adapter.XiangQing;
import com.example.weicy.weicy_gw.bean.ShouyeLunBoBean;
import com.example.weicy.weicy_gw.chushihua.ModelCallBack1;
import com.example.weicy.weicy_gw.chushihua.ViewCallBack1;
import com.example.weicy.weicy_gw.model.MyModel1;

import java.util.List;

/**
 * Created by Menglucywhh on 2017/11/30.
 */

public class MyPresenter1{

    ViewCallBack1 viewCallBack1;

    public MyPresenter1(final ViewCallBack1 viewCallBack1) {
        this.viewCallBack1 = viewCallBack1;
        MyModel1 myModel1 = new MyModel1();
        myModel1.getData(new ModelCallBack1() {
            @Override
            public void success(ShouyeLunBoBean shouyeLunBoBean) {
                viewCallBack1.success(shouyeLunBoBean);
            }

            @Override
            public void failure() {

            }
        });
    }

}



