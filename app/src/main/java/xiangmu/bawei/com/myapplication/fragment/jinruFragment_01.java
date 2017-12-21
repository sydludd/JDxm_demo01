package xiangmu.bawei.com.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.weicy.weicy_gw.R;
import com.example.weicy.weicy_gw.activity.SearchActivity;

/**
 * Created by weicy on 2017/12/7.
 */

public class jinruFragment_01 extends Fragment {

    private RadioButton radioButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jinrufragment_01, null);

        return view;
    }
}
