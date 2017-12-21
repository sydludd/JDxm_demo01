package xiangmu.bawei.com.myapplication.chushihua;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by weicy on 2017/12/8.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
