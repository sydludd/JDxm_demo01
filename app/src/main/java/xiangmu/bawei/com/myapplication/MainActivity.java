package xiangmu.bawei.com.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.weicy.weicy_gw.fragment.Fragment_01;
import com.example.weicy.weicy_gw.fragment.Fragment_02;
import com.example.weicy.weicy_gw.fragment.Fragment_03;
import com.example.weicy.weicy_gw.fragment.Fragment_03_01;
import com.example.weicy.weicy_gw.fragment.Fragment_04;
import com.example.weicy.weicy_gw.fragment.Fragment_05;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radio;
    private RadioButton shouye;
    private RadioButton fenlei;
    private RadioButton faxian;
    private RadioButton gouwuche;
    private RadioButton wude;
    boolean a = false;
    int num = 2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        radio = findViewById(R.id.rg_cus);
        shouye = findViewById(R.id.shouye);
        fenlei = findViewById(R.id.fenlei);
        faxian = findViewById(R.id.faxian);
        gouwuche = findViewById(R.id.gouwuche);
        wude = findViewById(R.id.wude);


        Intent intent = getIntent();



        a = intent.getBooleanExtra("name", a);

        if (a) {
            Fragment_05 fragment_05 = new Fragment_05();
            String namee = intent.getStringExtra("namee");

            Bundle bundle = new Bundle();

            bundle.putString("str", "1300110011");
            bundle.putString("strr",namee);
            fragment_05.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment_05);
            fragmentTransaction.commit();
        }else {
            Fragment_01 fragment_01 = new Fragment_01(getSupportFragmentManager());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, fragment_01);
            fragmentTransaction.commit();
        }



        shouye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_01 fragment_01 = new Fragment_01(getSupportFragmentManager());
                shouye.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.sy02), null, null);
                faxian.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fx01), null, null);
                fenlei.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fl01), null, null);
                gouwuche.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.gwh), null, null);
                wude.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.wd01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment_01);
                fragmentTransaction.commit();
            }
        });
        fenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_02 fragment_02 = new Fragment_02();
                fenlei.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fl02), null, null);
                shouye.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.sy1), null, null);
                faxian.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fx01), null, null);
                gouwuche.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.gwh), null, null);
                wude.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.wd01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment_02);
                fragmentTransaction.commit();
            }
        });
        gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_03 fragment_03 = new Fragment_03();
                fenlei.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fl01), null, null);
                shouye.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.sy1), null, null);
                faxian.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fx01), null, null);
                gouwuche.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.gw), null, null);
                wude.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.wd01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment_03);
                fragmentTransaction.commit();
            }
        });

        faxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_03_01 fragment_04 = new Fragment_03_01();
                fenlei.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fl01), null, null);
                shouye.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.sy1), null, null);
                faxian.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fx02), null, null);
                gouwuche.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.gwh), null, null);
                wude.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.wd01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment_04);
                fragmentTransaction.commit();
            }
        });

        /*gouwuche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_04 fragment_04 = new Fragment_04();
                fenlei.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fl01), null, null);
                shouye.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.sy1), null, null);
                faxian.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fx01), null, null);
                gouwuche.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.gwc11), null, null);
                wude.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.wd01), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment_04);
                fragmentTransaction.commit();
            }
        });*/
        wude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_05 fragment_05 = new Fragment_05();
                wude.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.wd), null, null);
                shouye.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.sy1), null, null);
                faxian.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fx01), null, null);
                fenlei.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.fl01), null, null);
                gouwuche.setCompoundDrawablesWithIntrinsicBounds(null, ContextCompat.getDrawable(MainActivity.this, R.drawable.gwh), null, null);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, fragment_05);
                fragmentTransaction.commit();
            }
        });


    }
}
