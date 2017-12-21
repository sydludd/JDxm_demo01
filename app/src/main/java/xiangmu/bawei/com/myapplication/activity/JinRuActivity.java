package xiangmu.bawei.com.myapplication.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;

public class JinRuActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                Intent intent = new Intent(JinRuActivity.this, Activity01.class);
                startActivity(intent);
                finish();

            } else {
                Intent intent = new Intent(JinRuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin_ru);

        SharedPreferences preferences = getSharedPreferences("shibian", MODE_PRIVATE);
        boolean b = preferences.getBoolean("name", false);
        if (b){
            handler.sendEmptyMessageDelayed(1,2000);
        }else {
            preferences.edit().putBoolean("name",true).commit();
            handler.sendEmptyMessageDelayed(0,2000);
        }

    }


}
