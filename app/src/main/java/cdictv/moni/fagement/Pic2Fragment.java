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
import android.widget.LinearLayout;
import android.widget.TextView;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

import cdictv.moni.R;


public class Pic2Fragment extends Fragment {
    private Context context;
    private int layout;

    public Pic2Fragment() {
    }

    @SuppressLint("ValidFragment")
    public Pic2Fragment(Context context, int layout) {
        this.context = context;
        this.layout = layout;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(layout, container, false);
        LinearLayout linear = inflate.findViewById(R.id.linear);
        TextView tv_titlewu = inflate.findViewById(R.id.tv_titlewu);
        TextView tv_titleyou = inflate.findViewById(R.id.tv_titleyou);
        tv_titlewu.setText("无重复违章");
        tv_titleyou.setText("有重复违章");
        double[] values = {13.8, 86.2};
        CategorySeries dataset = new CategorySeries("");

        dataset.add("有重复违章：" + values[0] + "%", values[0]);
        dataset.add("无重复违章：" + values[1] + "%", values[1]);

        int[] colors = {Color.parseColor("#AA4644"), Color.parseColor("#4573A7")};
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLegendTextSize(20);
        renderer.setZoomEnabled(false);
        renderer.setChartTitleTextSize(30);
        renderer.setChartTitle("有无“重复违章记录的车辆”占比统计");
        renderer.setLabelsTextSize(20);
        renderer.setLabelsColor(Color.BLACK);
        renderer.setPanEnabled(false);
renderer.setStartAngle(220 );
        renderer.setDisplayValues(false);
        renderer.setClickEnabled(true);
        renderer.setMargins(new int[]{20, 30});
        renderer.setShowLegend(false);
        int i = 0;
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            if (i == 0) {
                r.setHighlighted(true);
                i++;
            }
            renderer.addSeriesRenderer(r);
        }
        GraphicalView pieChartView = ChartFactory.getPieChartView(context, dataset, renderer);//饼状图
        linear.removeAllViews();
        linear.addView(pieChartView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        return inflate;
    }
}
