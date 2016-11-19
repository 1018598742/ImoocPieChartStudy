package com.example.administrator.imoocpiechartstudy;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/18 0018.
 */

public class PieFragment extends android.support.v4.app.Fragment {
    private static final String DATA_KEY = "piefragment_data_key";
    private MonthBean mData;
    private PieChart mChart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mData = arguments.getParcelable(DATA_KEY);
        }

    }

    public static PieFragment newInstance(MonthBean data) {

        Bundle args = new Bundle();
        args.putParcelable(DATA_KEY, data);
        PieFragment fragment = new PieFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_pie, null);
        mChart = ((PieChart) inflate.findViewById(R.id.pc_chart));

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.RED);
        mChart.setCenterText("饼状账单");
        mChart.setCenterTextSize(30);
        //饼状账单表添加文字
        initView();
        return inflate;
    }

    private void initView() {
        setData();

    }

    private void setData() {

        List<PieEntry> entrys = new ArrayList<>();
        for (int i = 0; i < mData.obj.size(); i++) {
            MonthBean.PieBean pieBean = mData.obj.get(i);
            PieEntry pieEntry = new PieEntry(pieBean.value,pieBean.title);
            entrys.add(pieEntry);
        }
        PieDataSet dataSet = new PieDataSet(entrys,"");
        List<Integer> mColors = new ArrayList<Integer>();
        mColors.add(Color.rgb(216,77,719));
        mColors.add(Color.rgb(183,56,63));
        mColors.add(Color.rgb(247,85,47));
//        dataSet.setValueTextColors(mColors);
        dataSet.setValueTextSize(20);
        dataSet.setColors(mColors);
        PieData pieData = new PieData(dataSet);
        mChart.setData(pieData);
    }
}
