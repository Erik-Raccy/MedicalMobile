package com.se3a04.medicalmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

public class GraphActivity extends Activity {
	
	
	// List view Adapter
	private String[] graphOptions = new String[] { "Weight Over Time Test",
			"graph functionallity over time", "work done with respect to due date"};
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.graphoptions);
	}
		
		public void WeightHandler(View view){
			LineGraph line = new LineGraph("weight");
			Intent lineintent = line.getIntent(this);
			lineintent.putExtra("sendType", "weight");
			startActivity(lineintent);	
		}
		
		public void PressureHandler(View view){
			LineGraph line = new LineGraph("pressure");
			Intent lineintent = line.getIntent(this);
			lineintent.putExtra("sendType", "pressure");
			startActivity(lineintent);
		}
		
		public void HeightHandler(View view){
			LineGraph line = new LineGraph("height");
			Intent lineintent = line.getIntent(this);
			lineintent.putExtra("sendType", "height");
			startActivity(lineintent);	
		}
		public void PowerHandler(View view){
			LineGraph line = new LineGraph("power");
			Intent lineintent = line.getIntent(this);
			lineintent.putExtra("sendType", "power");
			startActivity(lineintent);
			
		}
}
	

