package xiangmu.bawei.com.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.adapter.ChaoShiadapter;
import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.CaiPuBean;
import com.example.weicy.weicy_gw.fragment.Fragment_01;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChaoShiActivity extends AppCompatActivity {
    String menu;
    private Gson gson = new Gson();
    private int num = 10;
    String path;
    private List<CaiPuBean.ResultBean.DataBean> list = new ArrayList<>();
    boolean ss = false;
    private EditText searchshowEditSousuo;
    private Button searchshowBtnSousuo;
    private RecyclerView searchshowXRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao_shi);
        searchshowEditSousuo = findViewById(R.id.searchshow_edit_sousuo);
        searchshowBtnSousuo = findViewById(R.id.searchshow_btn_sousuo);
        searchshowXRecyclerView = findViewById(R.id.searchshow_xRecyclerView);
        ImageButton imageButton = findViewById(R.id.searchshow_imgbtn_return);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ChaoShiActivity.this, MainActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        searchshowBtnSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = searchshowEditSousuo.getText().toString().trim();
                isGB2312(s);
                if (ss) {
                    Intent intent = new Intent(ChaoShiActivity.this, ChaoShiActivity.class);
                    intent.putExtra("name", s);
                    startActivity(intent);
                }

            }
        });


        ButterKnife.bind(this);
        Intent intent = getIntent();
        menu = intent.getStringExtra("name");
        searchshowEditSousuo.setText(menu);
        LinearLayoutManager manager = new LinearLayoutManager(ChaoShiActivity.this);
        searchshowXRecyclerView.setLayoutManager(manager);
        try {

            path = "http://apis.juhe.cn/cook/query?key=9004667d3d4fcb7c16c9277b33c929c2&menu="+ URLEncoder.encode(menu, "utf-8") + "&rn=" + num + "&pn=1";
            Log.i("qweqweqwe",path);
            if (menu.equals("")) {
                Toast.makeText(ChaoShiActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
            } else {
                toYiBu();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toYiBu() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(path);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    int responseCode = urlConnection.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = urlConnection.getInputStream();
                        String json = ZhuanHuan(inputStream);
                        return json;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String json) {
                super.onPostExecute(json);
                Gson gson = new Gson();
                CaiPuBean bean = gson.fromJson(json, CaiPuBean.class);
                String resultcode = bean.getResultcode();
                int i = Integer.parseInt(resultcode);
                Log.i("asdasdasd",list.toString());
                if (i==200){
                    List<CaiPuBean.ResultBean.DataBean> list = bean.getResult().getData();
                    //设置适配器
                    ChaoShiadapter imagePager = new ChaoShiadapter(ChaoShiActivity.this, list);
                    //
                    searchshowXRecyclerView.setAdapter(imagePager);
                }else {
                    Toast.makeText(ChaoShiActivity.this,"暂无此内容",Toast.LENGTH_SHORT).show();


                }


            }
        };
        asyncTask.execute();
    }

    private String ZhuanHuan(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String string = null;
        try {
            while ((string=bufferedReader.readLine())!=null){
                builder.append(string);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean isGB2312(String str) {
        for (int i = 0; i < str.length(); i++) {
            String bb = str.substring(i, i + 1);
            // 生成一个Pattern,同时编译一个正则表达式,其中的u4E00("一"的unicode编码)-\u9FA5("龥"的unicode编码)
            boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);
            if (cc == false) {
                Toast.makeText(ChaoShiActivity.this, "请输入中文", Toast.LENGTH_SHORT).show();
                return cc;
            } else {
                ss = true;
            }
        }
        return true;

    }
}

