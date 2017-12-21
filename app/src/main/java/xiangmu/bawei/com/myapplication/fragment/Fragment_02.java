package xiangmu.bawei.com.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.weicy.weicy_gw.MainActivity;
import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.adapter.FenLeiadapter;
import com.example.weicy.weicy_gw.adapter.TiaoMuYiAdapter;
import com.example.weicy.weicy_gw.bean.Bean;
import com.example.weicy.weicy_gw.bean.Beanlbt;
import com.example.weicy.weicy_gw.bean.FenLeBeand;
import com.example.weicy.weicy_gw.bean.FenLeiBean;
import com.example.weicy.weicy_gw.chushihua.FenLeiDataBase;
import com.example.weicy.weicy_gw.chushihua.FenLeiDataBased;
import com.example.weicy.weicy_gw.chushihua.IGetDataBase;
import com.example.weicy.weicy_gw.chushihua.MyListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by weicy on 2017/12/6.
 */

public class Fragment_02 extends Fragment {
    private MyListView mListView1;
    private GridView mListView2;
    private List<FenLeBeand.DataBean> data;
    private List<FenLeiBean.DataBean> data1;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, null);
        mListView1 = view.findViewById(R.id.list1);
        mListView2 = view.findViewById(R.id.list2);
        //主口的网络请求事件
        Retrofit retrofit1 =  new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        FenLeiDataBased fenLeiDataBased = retrofit1.create(FenLeiDataBased.class);
        Call<FenLeBeand> fenLeBeandCall = fenLeiDataBased.get();
        fenLeBeandCall.enqueue(new Callback<FenLeBeand>() {
            @Override
            public void onResponse(Call<FenLeBeand> call, Response<FenLeBeand> response) {
                FenLeBeand body = response.body();
                data = body.getData();
                Log.i("123123123123123_01", "onResponse: "+ data);

                TiaoMuYiAdapter tiaoMuYiAdapter = new TiaoMuYiAdapter(getActivity(), data);
                mListView1.setAdapter(tiaoMuYiAdapter);
            }

            @Override
            public void onFailure(Call<FenLeBeand> call, Throwable t) {

            }
        });





        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                int cid = data.get(position).getCid();

                if (cid<6){
                    Toast.makeText(getActivity(),""+cid,Toast.LENGTH_SHORT).show();
                    //mListView2.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items));

                    Retrofit retrofit2 =  new Retrofit.Builder().baseUrl("https://www.zhaoapi.cn")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    FenLeiDataBase fenLeiDataBase_01 = retrofit2.create(FenLeiDataBase.class);
                    Call<FenLeiBean> call = fenLeiDataBase_01.get(cid);
                    call.enqueue(new Callback<FenLeiBean>() {
                        @Override
                        public void onResponse(Call<FenLeiBean> call, Response<FenLeiBean> response) {
                            FenLeiBean body = response.body();
                            data1 = body.getData();
                            Log.i("qweqweqweqweqwe", "onResponse: "+ data1.get(position).getName());
                            FenLeiadapter fenLeiadapter = new FenLeiadapter(getActivity(),data1);
                            mListView2.setAdapter(fenLeiadapter);
                        }

                        @Override
                        public void onFailure(Call<FenLeiBean> call, Throwable t) {

                        }
                    });

                }else {
                    Toast.makeText(getActivity(),"暂无更多内容",Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }
}
