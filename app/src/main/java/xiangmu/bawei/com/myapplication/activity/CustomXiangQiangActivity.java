package xiangmu.bawei.com.myapplication.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.R;

import butterknife.BindView;

public class CustomXiangQiangActivity extends AppCompatActivity {
    private ImageView customFanhui;
    private ViewPager customXqViewpager;
    private TextView customXqTitle;
    private TextView customXqBarginPrice;
    private TextView customXqPrice;
    private TextView jiagouBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_xiang_qiang);
        customFanhui = findViewById(R.id.custom_fanhui);
        customXqViewpager = findViewById(R.id.custom_xq_viewpager);
        customXqTitle = findViewById(R.id.custom_xq_title);
        customXqBarginPrice = findViewById(R.id.custom_xq_bargin_price);
        customXqPrice = findViewById(R.id.custom_xq_price);
        jiagouBtn = findViewById(R.id.jiagou_btn);

        jiagouBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomXiangQiangActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
