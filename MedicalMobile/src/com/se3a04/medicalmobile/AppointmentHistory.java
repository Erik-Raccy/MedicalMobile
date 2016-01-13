package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AppointmentHistory extends ListActivity {
	
	
	// List view Adapter
	private ArrayAdapter<String> adapter;
	private ListView lv;
	private String[] appointmentHistory = new String[] { "appointment 1",
			"appointment 2", "appointment 3"};
	private EditText inputFilter;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);

		lv = getListView(); // get the type of view
		inputFilter = (EditText) findViewById(R.id.input_filter);

		final ArrayList<String> appointmentHistory_lst = new ArrayList<String>(); // create an
		appointmentHistory_lst.addAll(Arrays.asList(appointmentHistory));
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, appointmentHistory_lst);
		this.setListAdapter(adapter);
		

		for (int i = 0; i < adapter.getCount(); i++) {
			System.out.println(adapter.getItem(i));
		}

		/**
		 * Enabling Search Filter
		 * */
		inputFilter.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {

				// When user changed the Text
				AppointmentHistory.this.adapter.getFilter().filter(cs);

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View lv, int i, long l){
				
				Toast.makeText(getApplicationContext(),appointmentHistory[i] ,
						Toast.LENGTH_SHORT).show();
				
				Intent toPastAppointment = new Intent(getApplicationContext(),
						AppointmentInProgress.class);
								//add putExtra();
				startActivity(toPastAppointment);
			
			}
		});
	}
	

	
}
