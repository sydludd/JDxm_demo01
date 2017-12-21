package xiangmu.bawei.com.myapplication.chushihua;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by weicy on 2017/12/6.
 */

public class MApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化组件
//        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this).build();
//        ImageLoader.getInstance().init(configuration);
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(getApplicationContext());
        ImageLoader.getInstance().init(aDefault);

    }
}
