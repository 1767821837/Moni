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

public class PicFragment extends Fragment {
    private Context context;
    private int layout;

    public PicFragment() {
    }

    @SuppressLint("ValidFragment")
    public PicFragment(Context context, int layout) {
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
        double[] values = {28.6, 71.3};
        CategorySeries dataset = new CategorySeries("");

        dataset.add("无违章：" + values[0] + "%", values[0]);
        dataset.add("有违章：" + values[1] + "%", values[1]);
        int[] colors = {Color.parseColor("#AA4644"), Color.parseColor("#4573A7")};
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLegendTextSize(20);
        renderer.setFitLegend(false);
        renderer.setZoomEnabled(false);
        renderer.setChartTitleTextSize(30);
        renderer.setChartTitle("平台上有违章车辆和没违章车辆的占比统计");
        renderer.setLabelsTextSize(20);
        renderer.setLabelsColor(Color.BLACK);
        renderer.setPanEnabled(false);
        renderer.setDisplayValues(false);
        renderer.setLegendHeight(0);
        renderer.setClickEnabled(true);
        renderer.setShowLegend(false);
        renderer.setStartAngle(200);
        renderer.setMargins(new int[]{20, 30});
        int i = 0;

        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);

            renderer.addSeriesRenderer(r);
        }
        GraphicalView pieChartView = ChartFactory.getPieChartView(context, dataset, renderer);//饼状图
        linear.removeAllViews();
        linear.addView(pieChartView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        return inflate;
    }
}
