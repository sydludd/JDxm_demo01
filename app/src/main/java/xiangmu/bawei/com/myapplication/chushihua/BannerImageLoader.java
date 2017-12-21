package xiangmu.bawei.com.myapplication.chushihua;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by weicy on 2017/12/6.
 */

public class BannerImageLoader extends com.youth.banner.loader.ImageLoader {

    //传过来图片接口
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        com.nostra13.universalimageloader.core.ImageLoader imageLoaderInstance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        imageLoaderInstance.displayImage((String) path, imageView);
    }
}
