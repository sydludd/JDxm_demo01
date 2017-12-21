package xiangmu.bawei.com.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.bean.ZhuceBean;
import com.example.weicy.weicy_gw.chushihua.ZhuceViewCallBack;
import com.example.weicy.weicy_gw.presenter.ZhucePresenter;

import butterknife.BindView;

public class ZhuCeActivity extends AppCompatActivity implements ZhuceViewCallBack {
    private ZhucePresenter zhucePresenter;
    private TextView zhuceCha;
    private EditText zhuceZh;
    private EditText zhucePwd;
    private Button zhuceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        zhuceCha = findViewById(R.id.zhuce_cha);
        zhuceZh = findViewById(R.id.zhuce_zh);
        zhucePwd = findViewById(R.id.zhuce_pwd);
        zhuceBtn = findViewById(R.id.zhuce_btn);

        zhucePresenter = new ZhucePresenter(this);

        zhuceCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        zhuceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //https://www.zhaoapi.cn/user/reg?mobile=15810680959&password=123456
                if (!TextUtils.isEmpty(zhuceZh.getText().toString()) && !TextUtils.isEmpty(zhucePwd.getText().toString())) {

                    // mvp请求注册的接口
                    zhucePresenter.getData(zhuceZh.getText().toString(), zhucePwd.getText().toString());

                } else {
                    Toast.makeText(ZhuCeActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void success(ZhuceBean zhuceBean) {
        Toast.makeText(this, zhuceBean.getMsg(), Toast.LENGTH_SHORT).show();
        if(zhuceBean.getMsg().equals("注册成功")){
            try {
                Thread.sleep(2000);
                Toast.makeText(this, "即将跳转到登录页面", Toast.LENGTH_SHORT).show();

                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void failure() {
        Toast.makeText(this, "请检查你的网络", Toast.LENGTH_SHORT).show();

    }
}
