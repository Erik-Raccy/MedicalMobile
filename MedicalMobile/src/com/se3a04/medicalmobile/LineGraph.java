package com.se3a04.medicalmobile;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.R.color;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

public class LineGraph {
	private String type;
	
	public LineGraph(String type){
		this.type = type;
	}
	
	public Intent getIntent(Context context)
	{
		int[] weightx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] weighty = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		int[] pressurex = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] pressurey = {90, 99, 104, 98, 95, 89, 96, 100, 97, 93};
		
		int[] heightx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] heighty = {50, 70, 80, 100, 150, 200, 210, 210, 210, 215};
		
		int[] powerx = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] powery = {0, 1, 4, 9, 16, 25, 100, 500, 1000, 9001 };
		
		TimeSeries series = new TimeSeries("Weight vs Time");
		double[] range = {-10, 20, -50, 120}; //adjust it according to the data
		int[] margin = {75, 90, 40, 90};
		String graphTitle = "Graphing"; 
		
		if (type == "weight"){
			for (int i = 0; i < weightx.length; i++)
			{
				series.add(weightx[i], weighty[i]);
				graphTitle = "Weight Measurements";
			}
		}
		
		if (type == "pressure"){
			for (int i = 0; i < pressurex.length; i++)
			{
				series.add(pressurex[i], pressurey[i]);
				graphTitle = "Blood Pressure Measurements";
			}
		}
		
		if (type == "height"){
			for (int i = 0; i < heightx.length; i++)
			{
				series.add(heightx[i], heighty[i]);
				graphTitle = "Height Measurements";
			}
		}
		
		if (type == "power"){
			for (int i = 0; i < powerx.length; i++)
			{
				series.add(powerx[i], powery[i]);
				graphTitle = "Power Level Measurements";
			}
		}
		
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		
		
		XYSeriesRenderer renderer = new XYSeriesRenderer();
		renderer.setColor(Color.BLUE);
		renderer.setPointStyle(PointStyle.SQUARE);
		renderer.setFillPoints(true);
		XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
		mRenderer.addSeriesRenderer(renderer);
		//mRenderer.addXTextLabel(2, "hi");
		
		System.out.print(mRenderer.getScale());
		mRenderer.setApplyBackgroundColor(true);
		mRenderer.setBackgroundColor(Color.WHITE);
		mRenderer.setPanEnabled(true, true);
		mRenderer.setLabelsColor(Color.BLUE);
		mRenderer.setAxisTitleTextSize(60);
		mRenderer.setChartTitleTextSize(50);
		mRenderer.setLabelsTextSize(25);
		mRenderer.setShowLegend(false);
		mRenderer.setMargins(margin);
		mRenderer.setYLabels(14);
		mRenderer.setXLabels(10);
		mRenderer.setMarginsColor(Color.LTGRAY);
		mRenderer.setShowAxes(true);
		mRenderer.setAxesColor(Color.BLACK);
		mRenderer.setDisplayValues(true);
		mRenderer.setBarSpacing(1);
		mRenderer.setPanLimits(range);	
		mRenderer.setYLabelsColor(0, Color.BLACK);
		mRenderer.setXLabelsColor(Color.BLACK);
		mRenderer.setChartTitle(graphTitle);
		mRenderer.setXTitle("Appointment #");
		mRenderer.setYTitle(type);
		
		
		Intent intent = ChartFactory.getLineChartIntent(context, dataset , mRenderer, "Graphing");
	return intent;
	}
}
