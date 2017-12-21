package xiangmu.bawei.com.myapplication.activity;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.fragment.Fragment_01;


public class SearchActivity extends AppCompatActivity {
    String s;
    boolean ss = false;

    boolean a=true;
    int b = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final EditText sousuo = findViewById(R.id.search_edit_sousuo);
        Button btn = findViewById(R.id.search_btn_sousuo);
        ImageButton imageButton = findViewById(R.id.search_imgbtn_return);
        final TextView textView = findViewById(R.id.search_tv_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = sousuo.getText().toString().trim();
                textView.append("\n" + s);
//                textView.setText("\n" + s);

                isGB2312(s);
                if (ss) {
                    Intent intent = new Intent(SearchActivity.this, ChaoShiActivity.class);
                    intent.putExtra("name", s);
                    startActivity(intent);
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public Boolean isGB2312(String str) {
        for (int i = 0; i < str.length(); i++) {
            String bb = str.substring(i, i + 1);
// 生成一个Pattern,同时编译一个正则表达式,其中的u4E00("一"的unicode编码)-\u9FA5("龥"的unicode编码)
            boolean cc = java.util.regex.Pattern.matches("[\u4E00-\u9FA5]", bb);
            if (cc == false) {
                Toast.makeText(SearchActivity.this, "请输入中文", Toast.LENGTH_SHORT).show();

                return cc;
            } else {
                ss = true;
            }
        }
        return true;

    }
}