package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class InfoChange extends Activity {
	private MedicalDatabase database;
	EditText info;
	Button confirm;
	Spinner list;

	private int chosen = -1;
	final ArrayList<String> displayList = new ArrayList<String>();

	final String[] options = {"Address", "Birthday", "Telephone"};
	public String[] value = {"", "", ""};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infochange);
		

		
		confirm = (Button) findViewById(R.id.confirm);
		info = (EditText) findViewById(R.id.info);
		list = (Spinner) findViewById(R.id.spinner2);

		displayList.addAll(Arrays.asList(options));

		ArrayAdapter<String> spin_adapter = new ArrayAdapter<String>(
				InfoChange.this, android.R.layout.simple_spinner_item, options);
		list.setAdapter(spin_adapter);
		
		infoListener();

	}

	public void infoListener() {
		Bundle extras = getIntent().getExtras();
		final String display_name = extras.getString("nameSend");
		confirm.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				value[chosen] = info.getText().toString();
				if (chosen != -1) {

					if(options[chosen].equals("Address")){
						options[chosen] = "address";
					}
					if(options[chosen].equals("Telephone")){
						options[chosen] = "telephone";
					}
					if(options[chosen].equals("Birthday")){
						options[chosen] = "birthday";
					}
					
					Toast.makeText(getApplicationContext(),
							options[chosen] + " Updated to " + value[chosen],
							Toast.LENGTH_SHORT).show();
					database = LogIn.database;
					database.open();
					database.modifyUser(display_name, options[chosen], value[chosen]);
					database.close();
					
					setResult(RESULT_OK);
					finish();
				}

			}

		});

		list.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub

				chosen = position;
				Toast.makeText(getApplicationContext(),
						options[position] + " selected", Toast.LENGTH_SHORT)
						.show();
				
				

			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

}
