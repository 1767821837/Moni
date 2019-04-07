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

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import cdictv.moni.R;

public class Bar1Fragment extends Fragment {
    private Context context;
    private int layout;

    public Bar1Fragment() {
    }

    @SuppressLint("ValidFragment")
    public Bar1Fragment(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layout, container, false);
        HorizontalBarChart barChart = inflate.findViewById(R.id.barChart);
        List<BarDataSet> datasets = new ArrayList<>();
        List<String> xvalue = new ArrayList<>();
        List<BarEntry> yVals = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            yVals.add(new BarEntry(getInt(), i));
        }

        BarDataSet barDataSet = new BarDataSet(yVals, "dffds");
        int[] ints = {Color.parseColor("#C10100"),
                Color.parseColor("#5082C0"),Color.parseColor("#90D34F")};
        barDataSet.setColors(ints);

        barDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                float val = entry.getVal();
                return String.format("%.2f",val)+"%";
            }
        });

        barDataSet.setBarSpacePercent(55f);



        Legend legend = barChart.getLegend();
        legend.setEnabled(false);




        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineColor(Color.TRANSPARENT);
        xAxis.setDrawGridLines(false);

        xvalue.add("1-2条违章");
        xvalue.add("3-5条违章");
        xvalue.add("5条以上违章");
        xAxis.setTextSize(15f);
        xAxis.setLabelsToSkip(0);
        xAxis.setXOffset(25f);

        YAxis axisLeft = barChart.getAxisLeft();
        axisLeft.setAxisLineColor(Color.TRANSPARENT);
        axisLeft.setTextColor(Color.TRANSPARENT);
        axisLeft.setDrawAxisLine(false);
        axisLeft.setXOffset(20f);
        axisLeft.setGridColor(Color.TRANSPARENT);


        YAxis axisRight = barChart.getAxisRight();
        axisRight.setAxisLineColor(Color.TRANSPARENT);
        axisRight.setDrawAxisLine(false);
        axisRight.setXOffset(20f);
        axisRight.setAxisMaxValue(30);
        axisRight.setLabelCount(12,true);
        axisRight.setValueFormatter(new YAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, YAxis yAxis) {
                return String.format("%.2f",v)+"%";
            }
        });
        axisRight.setAxisMaxValue(70f);
        axisRight.setLabelCount(7,true);


        barChart.setDescription("");

        datasets.add(barDataSet);
        BarData barData = new BarData(xvalue, datasets);
        barChart.setData(barData);



        return inflate;
    }

    public int getInt() {
        return (int) (Math.random() * 60 + 1);
    }
}
