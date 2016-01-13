package com.se3a04.medicalmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppointmentCreate extends Activity {
	public static MedicalDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointmentprogress);
		final Bundle extras = getIntent().getExtras();
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

		cancel = (Button) findViewById(R.id.cancel_appointment_prog);

		weight = (EditText) findViewById(R.id.weight_input);

		height = (EditText) findViewById(R.id.height_input);

		age = (EditText) findViewById(R.id.age_input);

		powers = (EditText) findViewById(R.id.power_level_input);

		symptoms = (EditText) findViewById(R.id.symptoms_input);

		comments = (EditText) findViewById(R.id.add_details_input);

		bp_sys = (EditText) findViewById(R.id.bp_sys_input);

		bp_dia = (EditText) findViewById(R.id.bp_dia_input);

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// String inputted_weight = weight.getText().toString();
				// String inputted_height = height.getText().toString();
				// String inputted_age = age.getText().toString();
				// String inputted_powers = powers.getText().toString();
				// String inputted_symptoms = symptoms.getText().toString();
				// String inputted_comments = comments.getText().toString();
				// String inputted_bp_sys = bp_sys.getText().toString();
				// String inputted_bp_dia = bp_dia.getText().toString();;

				String display_name = extras.getString("nameSend");
				Toast.makeText(getApplicationContext(), display_name,
						Toast.LENGTH_SHORT).show();

				database = LogIn.database;
				database.open();

				database.modifyUser(MainMenu.display_name, "weight", weight
						.getText().toString());
				database.modifyUser(MainMenu.display_name, "height", height
						.getText().toString());
				database.modifyUser(MainMenu.display_name, "age", age.getText()
						.toString());
				database.modifyUser(MainMenu.display_name, "powers", powers
						.getText().toString());
				database.modifyUser(MainMenu.display_name, "symptoms", symptoms
						.getText().toString());
				database.modifyUser(MainMenu.display_name, "comments", comments
						.getText().toString());
				database.modifyUser(MainMenu.display_name, "bp_sys", bp_sys
						.getText().toString());
				database.modifyUser(MainMenu.display_name, "bp_dia", bp_dia
						.getText().toString());

				database.close();// broken

				setResult(RESULT_OK);
				finish();

			}

		});

		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				setResult(RESULT_OK);
				finish();

			}

		});

	}

}
