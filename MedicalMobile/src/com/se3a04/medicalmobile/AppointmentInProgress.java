package com.se3a04.medicalmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppointmentInProgress extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointmentprogress);

		final EditText weight;
		final EditText height;
		final EditText age;
		final EditText bp_sys;
		final EditText bp_dia;
		final EditText powers;
		final EditText symptoms;
		final EditText comments;

		Button submit, cancel;

		submit = (Button) findViewById(R.id.submit_appointment_prog);
		submit.setVisibility(View.INVISIBLE);

		cancel = (Button) findViewById(R.id.cancel_appointment_prog);
		cancel.setVisibility(View.INVISIBLE);

		weight = (EditText) findViewById(R.id.weight_input);
		weight.setKeyListener(null);
		weight.setFocusable(false);

		height = (EditText) findViewById(R.id.height_input);
		height.setKeyListener(null);
		height.setFocusable(false);

		age = (EditText) findViewById(R.id.age_input);
		age.setKeyListener(null);
		age.setFocusable(false);

		powers = (EditText) findViewById(R.id.power_level_input);
		powers.setKeyListener(null);
		powers.setFocusable(false);

		symptoms = (EditText) findViewById(R.id.symptoms_input);
		symptoms.setKeyListener(null);
		symptoms.setFocusable(false);

		comments = (EditText) findViewById(R.id.add_details_input);
		comments.setKeyListener(null);
		comments.setFocusable(false);

		bp_sys = (EditText) findViewById(R.id.bp_sys_input);
		bp_sys.setKeyListener(null);
		bp_sys.setFocusable(false);

		bp_dia = (EditText) findViewById(R.id.bp_dia_input);
		bp_dia.setKeyListener(null);
		bp_dia.setFocusable(false);

	}

}
