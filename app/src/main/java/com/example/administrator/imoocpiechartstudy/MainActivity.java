package com.example.administrator.imoocpiechartstudy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager vpMain;
    private String mJson = "[{\"date\":\"2016年5月\",\"obj\":[{\"title\":\"外卖\",\"value\":34},{\"title\":\"娱乐\",\"value\":21},{\"title\":\"其他\",\"value\":21}]},{\"date\":\"2016年6月\",\"obj\":[{\"title\":\"外卖2\",\"value\":35},{\"title\":\"娱乐2\",\"value\":26},{\"title\":\"其他2\",\"value\":28}]}]";
    private ArrayList<MonthBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpMain = ((ViewPager) findViewById(R.id.vp_main));
        initData();
        initView();
    }

    private void initData() {
        Gson gson = new Gson();
        mData = gson.fromJson(mJson, new TypeToken<ArrayList<MonthBean>>() {
        }.getType());
    }

    private void initView() {
        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return PieFragment.newInstance(mData.get(position));
            }

            @Override
            public int getCount() {
                return mData.size();
            }
        });
    }
}
