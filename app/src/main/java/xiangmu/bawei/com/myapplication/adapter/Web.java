package xiangmu.bawei.com.myapplication.adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.WebBean;
import com.example.weicy.weicy_gw.chushihua.IGetDataBase;
import com.example.weicy.weicy_gw.chushihua.WebDataBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Web extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = findViewById(R.id.web_view);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.i("123123123123_02'", "onCreate: "+url);
        int i = Integer.parseInt(url);
        Log.i("123123123123_01'", "onCreate: "+i);
        //https://www.zhaoapi.cn/product/getProductDetail?pid=100&source=android
        Retrofit retrofit =  new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WebDataBase webDataBase = retrofit.create(WebDataBase.class);

        /*Call<WebBean> beanCall = webDataBase.get(i, "android");
        beanCall.enqueue(new Callback<WebBean>() {
            @Override
            public void onResponse(Call<WebBean> call, Response<WebBean> response) {
                WebBean body = response.body();
                String detailUrl = body.getData().getDetailUrl();
                Log.i("123123123123_03", "onResponse: "+detailUrl);
                webView.loadUrl(detailUrl);
                webView.setWebViewClient(new WebViewClient());
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
            }

            @Override
            public void onFailure(Call<WebBean> call, Throwable t) {

            }
        });*/

    }
}
