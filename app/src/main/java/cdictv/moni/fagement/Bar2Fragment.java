package cdictv.moni.fagement;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;

public class Bar2Fragment extends Fragment {
    private Context context;
    private int layout;
    float count=0;
    public Bar2Fragment() {
    }

    @SuppressLint("ValidFragment")
    public Bar2Fragment(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layout, container, false);
        BarChart barChart = inflate.findViewById(R.id.barChart);
        List<BarDataSet> datasets = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<BarEntry> yVals = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add("tyh" + (i + 1));
            int anInt = getInt();
            count=count+anInt;
            yVals.add(new BarEntry(anInt, i));
        }

        BarDataSet barDataSet = new BarDataSet(yVals, "dffds");
        barDataSet.setColor(Color.parseColor("#6A9800"));
        barDataSet.setValueTextColor(Color.parseColor("#B93953"));
        barDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                float val = entry.getVal();
                float v1 = (val / count)*100;
                return String.format("%.1f",v1)+"%";
            }
        });


        barDataSet.setBarSpacePercent(70f);
        Legend legend = barChart.getLegend();
        legend.setEnabled(false);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(Color.TRANSPARENT);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new XAxisValueFormatter() {
            @Override
            public String getXValue(String s, int i, ViewPortHandler viewPortHandler) {
                switch (i) {
                    case 0:
                        return "90后";
                    case 1:
                        return "80后";
                    case 2:
                        return "70后";
                    case 3:
                        return "60后";
                    case 4:
                        return "50后";
                }
                return s;
            }
        });
        xAxis.setTextSize(15f);
        xAxis.setLabelsToSkip(0);


        barChart.setDescription("");

        YAxis axisLeft = barChart.getAxisLeft();
        //axisLeft.setAxisLineColor(Color.TRANSPARENT);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setXOffset(20f);
        axisLeft.setAxisMaxValue(1200);
        axisLeft.setTextSize(30f);
        axisLeft.setLabelCount(7, true);

        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisLineColor(Color.TRANSPARENT);
        axisRight.setTextColor(Color.TRANSPARENT);
        axisRight.setDrawAxisLine(false);
        axisRight.setXOffset(20f);
        axisRight.setGridColor(Color.TRANSPARENT);

        barChart.setDescription("");

        datasets.add(barDataSet);
        BarData barData = new BarData(list, datasets);
        barChart.setData(barData);


        return inflate;
    }

    public int getInt() {
        return (int) (Math.random() * 1200 + 1);
    }
}
