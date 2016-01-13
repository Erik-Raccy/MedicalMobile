package com.se3a04.medicalmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TimePicker;
import android.widget.EditText;

public class AppointmentRequest extends Activity {
	
	private String date;
	private String currentUser;
	private String currentMode;
	private TimePicker timepicker;
	private EditText textField;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointmentrequest);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			date = extras.getString("date");
			currentUser = extras.getString("currentUser");
			currentMode = extras.getString("currentMode");
		}
		boolean tempppp = date.equals("2013-12-04");
		Toast.makeText(getApplicationContext(), String.valueOf(tempppp),
				Toast.LENGTH_SHORT).show();
		TextView dateText = (TextView) findViewById(R.id.textDate);
		dateText.setText(date);
		
		timepicker = (TimePicker) findViewById(R.id.timePicker1);
		textField = (EditText) findViewById(R.id.editInfoText);
		
		Button submitButton = (Button) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//save appointment here
				String hour = timepicker.getCurrentHour().toString();
				String minute = timepicker.getCurrentMinute().toString();
				if(minute.length()==1){
					minute = "0" + minute;
				}
				String time = hour + ":" + minute;
				
				String info = textField.getText().toString();
				
				LogIn.database.open();
				if(currentMode.equals("Secretary")){
					//save AppointmentMiniInfo for currentUser
					System.out.println("Add: "+currentUser+date+time+info);
					LogIn.database.addAppt(time,date,currentUser,info);
				}else{
					//request AppointmentMiniInfo for currentUser
					System.out.println("Request: "+currentUser+date+time+info);
					LogIn.database.addRequest(time,date,currentUser,info);
				}
				LogIn.database.close();
				Intent returnIntent = new Intent();
				returnIntent.putExtra("result","yay");
				setResult(RESULT_OK,returnIntent);     
				finish();
			}	
		});
		
		Button cancelButton = (Button) findViewById(R.id.cancelButton);
		cancelButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent returnIntent = new Intent();
				setResult(RESULT_CANCELED, returnIntent);        
				finish();
			}	
		});
	}
}
