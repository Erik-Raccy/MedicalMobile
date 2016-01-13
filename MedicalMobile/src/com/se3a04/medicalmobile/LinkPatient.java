package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LinkPatient extends ListActivity {
	private String display_name="";
	
	private String [] selecteddoctors = {"",""};
	// List view Adapter
	private ArrayAdapter<String> adapter;
	private ListView lv;
	private String[] doctors = new String[] { "Doctor Who",
			"Doc Brown", "House", "Zoidberg", "Doctor Manhattan" };
	
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);

	Bundle extras = getIntent().getExtras();
		
		if (extras != null) {
			display_name = extras.getString("nameSend");
		}
		lv = getListView(); // get the type of view

		final ArrayList<String> doctors_lst = new ArrayList<String>(); // create an
		doctors_lst.addAll(Arrays.asList(doctors));
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, doctors_lst);
		this.setListAdapter(adapter);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View lv, int i, long l){
				
				Toast.makeText(getApplicationContext(),doctors[i]+ " is now paired to " + display_name,
						Toast.LENGTH_SHORT).show();
				//saves doctors
				selecteddoctors[1]=doctors[i];
				
			
			}
		});
	}
	

	
}
