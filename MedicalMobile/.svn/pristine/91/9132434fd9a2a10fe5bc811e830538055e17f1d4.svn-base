package com.se3a04.medicalmobile;

import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUser extends Activity {
	public static MedicalDatabase database;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adduser);

		final EditText name;
		final EditText username;
		final EditText password;
		final EditText type;
		final EditText address;
		final EditText birthday;
		final EditText telephone;
		
		Button submit;

		submit = (Button) findViewById(R.id.submit_user);

		name = (EditText) findViewById(R.id.name_display);

		username = (EditText) findViewById(R.id.username_display);

		password = (EditText) findViewById(R.id.password_display);

		type = (EditText) findViewById(R.id.type_display);

		address = (EditText) findViewById(R.id.address_display);

		birthday = (EditText) findViewById(R.id.birthday_display);

		telephone = (EditText) findViewById(R.id.telephone_display);

		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				String in_name = name.getText().toString();
				String in_username = username.getText().toString();
				String in_password = password.getText().toString();
				String in_type = type.getText().toString();
				String in_address = address.getText().toString();
				String in_birthday = birthday.getText().toString();
				String in_telephone = telephone.getText().toString();

				Toast.makeText(getApplicationContext(), "Sending data...",
						Toast.LENGTH_SHORT).show();
				database = LogIn.database;
				database.open();
				database.addUser(in_name, in_type, in_password, in_username,
						"", "", "", "", "", "", in_telephone, in_birthday,
						in_address);
				database.close();

				setResult(RESULT_OK);
				finish();

			}

		});
	}
}
