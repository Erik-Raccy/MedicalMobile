package com.se3a04.medicalmobile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Requests extends ListActivity {
	
	
	// List view Adapter
	private ArrayAdapter<String> adapter;
	private ListView lv;

	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_list);

		LogIn.database.open();
		Vector<String> user_names = LogIn.database.readRequestColumn("who_requested");
		Vector<String> times = LogIn.database.readRequestColumn("requested_time");
		Vector<String> dates = LogIn.database.readRequestColumn("requested_day");
		Vector<String> infos = LogIn.database.readRequestColumn("info_requested");
		LogIn.database.close();
		
		final ArrayList<String> requests_lst = new ArrayList<String>(); // create an
		for(int i=0; i<user_names.size();i++){
			requests_lst.add(user_names.get(i) +" "+ dates.get(i)+" "+times.get(i)+" "+infos.get(i));
		}
		
		lv = getListView(); // get the type of view
		adapter = new ArrayAdapter<String>(this, R.layout.list_item,
				R.id.product_name, requests_lst);
		this.setListAdapter(adapter);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> adapter, View lv, int i, long l){
				
//				Toast.makeText(getApplicationContext(),requests[i]+ " selected",
//						Toast.LENGTH_SHORT).show();
			}
		});
	}
	

	
}
