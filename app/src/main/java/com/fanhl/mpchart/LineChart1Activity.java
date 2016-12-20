package com.fanhl.mpchart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineChart1Activity extends AppCompatActivity {
    private LineChart chart;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, LineChart1Activity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart1);
        assignViews();
        initData();
        refreshData();
    }

    private void assignViews() {
        this.chart = (LineChart) findViewById(R.id.chart);
    }

    private void initData() {
        chart.setTouchEnabled(false);
//        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        chart.setDescription("");

        chart.setNoDataText("无数据");
        chart.getLegend().setEnabled(true);
        chart.getLegend().setTextSize(14);
        chart.getLegend().setFormSize(14);

        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
//        chart.getXAxis().setLabelsToSkip(0);
        chart.getXAxis().setDrawGridLines(false);
        chart.getXAxis().setTextSize(14);
        chart.getXAxis().setYOffset(4);
        chart.getXAxis().setTextColor(Color.BLACK);
        chart.getXAxis().setAxisLineColor(0xFFD7D7D7);

        chart.setExtraBottomOffset(0);

        chart.getAxisLeft().setDrawAxisLine(true);
        chart.getAxisLeft().setTextColor(0xFF969696);
        chart.getAxisLeft().setTextSize(16);
        chart.getAxisLeft().setLabelCount(5, false);
        chart.getAxisLeft().setGridColor(0xFFD7D7D7);
        chart.getAxisLeft().setGridLineWidth(1f);

        chart.getAxisRight().setDrawAxisLine(true);
        chart.getAxisRight().setDrawLabels(true);
        chart.getAxisRight().setDrawGridLines(false);
    }


    private void refreshData() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                LineData data = parseData();
                chart.setData(data);
                chart.invalidate();
                chart.animateX(800);
            }
        }, 1000);
    }

    @NonNull private LineData parseData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");


        List<String> xVals = new ArrayList<>();
        List<Entry> yVals = new ArrayList<>();
        List<Entry> yVals2 = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            xVals.add("周一");
            yVals.add(new Entry(new Random().nextFloat(), i));
            yVals2.add(new Entry(new Random().nextFloat(), i));
        }

        LineDataSet dataSet1 = new LineDataSet(yVals, "里程？");
        dataSet1.setColors(new int[]{0xFFF6AB00});
        dataSet1.setDrawValues(true);
        dataSet1.setValueTextSize(12);
        dataSet1.setValueTextColor(0xFFF6AB00);
//        dataSet1.setValueFormatter(new NationAreaRobberyIndexFragment.YValueFormatter());
        dataSet1.setCubicIntensity(1);//阴影
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.gradient);
//        drawable.setAlpha(200);
        dataSet1.setFillDrawable(drawable);
        dataSet1.setDrawFilled(true);

        LineDataSet dataSet2 = new LineDataSet(yVals2, "时间？");
        dataSet2.setColors(new int[]{0xFFAB00F6});
        dataSet2.setDrawValues(true);
        dataSet2.setValueTextSize(12);
        dataSet2.setValueTextColor(0xFFF6AB00);
//        dataSet1.setValueFormatter(new NationAreaRobberyIndexFragment.YValueFormatter());
        dataSet2.setCubicIntensity(1);//阴影
        Drawable drawable2 = ContextCompat.getDrawable(this, R.drawable.gradient2);
//        drawable2.setAlpha(200);
        dataSet2.setFillDrawable(drawable2);
        dataSet2.setDrawFilled(true);

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);

        LineData lineData = new LineData(xVals, dataSets);
        return lineData;
    }
}
