package xiangmu.bawei.com.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.DengluBean;
import com.example.weicy.weicy_gw.bean.MessageEvent;
import com.example.weicy.weicy_gw.chushihua.DengluViewCallBack;
import com.example.weicy.weicy_gw.fragment.Fragment_05;
import com.example.weicy.weicy_gw.presenter.DengluPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengluActivity extends AppCompatActivity implements DengluViewCallBack {


    private DengluPresenter dengluPresenter;
    private TextView dengluCha;
    private EditText dengluZh;
    private EditText dengluPwd;
    private Button dengluBtn;
    private TextView zhuce;
    private String mobile;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        dengluCha = findViewById(R.id.denglu_cha);
        dengluZh = findViewById(R.id.denglu_zh);
        dengluPwd = findViewById(R.id.denglu_pwd);
        dengluBtn = findViewById(R.id.denglu_btn);
        zhuce = findViewById(R.id.zhuce);
        dengluPresenter = new DengluPresenter(this);
        dengluCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();//返回到之前的fragment
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Toast.makeText(this, "e", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DengluActivity.this, ZhuCeActivity.class);
                startActivity(intent);
            }
        });
        EventBus.getDefault().register(this);
        dengluBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(dengluZh.getText().toString()) && !TextUtils.isEmpty(dengluPwd.getText().toString())) {



                    //如果都不为空,请求接口
                    dengluPresenter.getData(dengluZh.getText().toString(),dengluPwd.getText().toString());
                    intent = new Intent(DengluActivity.this, MainActivity.class);
                    intent.putExtra("name",true);
                    intent.putExtra("namee",mobile+"");
                    //intent.putExtra("namee",mobile+"");
                    //Log.i("asdasd",mobile);
                    startActivity(intent);


                } else {
                    Toast.makeText(DengluActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Subscribe
    public void onMessageEvent(DengluBean dengluBean) {

        String mobile = dengluBean.getData().getMobile();


    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {

        event.isTag();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void success(DengluBean dengluBean) {
        mobile = dengluBean.getData().getMobile();

        Log.i("asd",mobile);
        Toast.makeText(this, dengluBean.getMsg(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void failure() {
        Toast.makeText(this, "请检查你的网络", Toast.LENGTH_SHORT).show();

    }

}
